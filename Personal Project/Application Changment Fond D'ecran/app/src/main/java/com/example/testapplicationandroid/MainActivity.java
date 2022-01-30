package com.example.testapplicationandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements Serializable {


    private TextView txt;
    private Button change;
    private Button gallery;
    private ImageView img;
    private Button enregistre;
    private FloatingActionButton wallpaperDroite;
    private FloatingActionButton wallpaperGauche;
    boolean wallpaper;
    protected SharedPreferences.Editor editor;
    private SharedPreferences sharedPref;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    private ArrayList<String> wallpaperSaved;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    private Button suppr;


    @SuppressLint({"CommitPrefEdits", "ClickableViewAccessibility", "SourceLockedOrientationActivity"})
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Context context = this.getBaseContext();
        if(savedInstanceState != null) {
            wallpaper = savedInstanceState.getBoolean("wallpaper");
        }
        sharedPref = context.getSharedPreferences(getString(R.string.preferences),Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        if(sharedPref.getAll() != null){
            wallpaper = sharedPref.getBoolean(getString(R.string.wallpaper),true);
        }
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.BTM);
        txt.setVisibility(View.INVISIBLE);
        enregistre = findViewById(R.id.button3);
        enregistre.setOnClickListener(enregistreListener);
        wallpaperSaved = this.jsonToHash();
        wallpaperDroite = findViewById(R.id.floatingActionButton);
        wallpaperGauche = findViewById(R.id.floatingActionButton2);
        wallpaperGauche.setOnClickListener(gauche);
        wallpaperDroite.setOnClickListener(droite);
        if(wallpaperSaved.size() < 2){
            wallpaperDroite.setEnabled(false);
            wallpaperGauche.setEnabled(false);
        }
        change = findViewById(R.id.button);
        change.setOnClickListener(changeListener);
        gallery = findViewById(R.id.button2);
        gallery.setOnClickListener(galleryListener);
        img = findViewById(R.id.imageView2);
        suppr = findViewById(R.id.button4);
        suppr.setOnClickListener(supprListener);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final View.OnClickListener changeListener = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            if (txt.getText().toString().contains("Timido") || txt.getText().toString().contains("Shenhe")) {
                if (wallpaper) {
                    txt.setText("Fond d'écran changé pour Timido");
                    img.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.timido));
                    try {
                        wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.timido),null,false,WallpaperManager.FLAG_SYSTEM);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    editor.putBoolean("wallpaper", wallpaper);
                    boolean p = editor.commit();
                    if (p) {
                        System.out.println("Enregistrer " + wallpaper);
                    }
                    wallpaper = false;
                    editor.putString("LastWallpaper","Timido");
                    editor.commit();
                } else {
                    try {
                        txt.setText("Fond d'écran changé pour Shenhe");
                        img.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.shenhe));
                        wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.shenhe),null,false,WallpaperManager.FLAG_SYSTEM);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    editor.putBoolean("wallpaper", wallpaper);
                    boolean p = editor.commit();
                    if (p) {
                        System.out.println("Enregistrer " + wallpaper);
                    }
                    wallpaper = true;
                    editor.putString("LastWallpaper","Shenhe");
                    editor.commit();
                }
            }else{
                if(checkPermissionREAD_EXTERNAL_STORAGE(getBaseContext())) {
                    Uri i = Uri.parse(wallpaperSaved.get(sharedPref.getInt("Act",0)));
                    txt.setText(i.toString());
                    try {
                        img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(i)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        wallpaperManager.setBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(i)), null, false, WallpaperManager.FLAG_SYSTEM);
                    } catch (Exception ignored) {
                    }
                    editor.putString("LastWallpaper", i.toString());
                    editor.commit();
                }
            }
        }
    };

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if(height>reqHeight || width > reqWidth){
            final int halfheight = height/2;
            final int halfWidth = width/2;
            while((halfheight/inSampleSize) >= reqHeight && (halfWidth/inSampleSize) >= reqWidth){
                inSampleSize *=2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromRessources(Resources res, int resid, int reqWidth, int reqHeight){
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resid,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res,resid,options);
    }

    private void init() throws Exception{
        String res = sharedPref.getString("LastWallpaper","Timido");
        if(res.equals("Timido")){
            img.setImageBitmap(decodeSampledBitmapFromRessources(getResources(),R.drawable.timido,258,479));
            txt.setText("Fond d'écran actuelle : Timido");
        }else{
            if (checkPermissionREAD_EXTERNAL_STORAGE(this)) {
                Uri i = Uri.parse(res);
                txt.setText(i.toString());
                img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(i)));
                editor.putString("LastWallpaper", i.toString());
                editor.commit();
            }
        }
    }

    private final View.OnClickListener galleryListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,0);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            txt.setText(targetUri.toString());
            try {
                img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            editor.putString("LastWallpaper",targetUri.toString());
            editor.commit();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putBoolean("wallpaper",wallpaper);
        System.out.println("On Passe dedans");
    }
    public boolean checkPermissionREAD_EXTERNAL_STORAGE(final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        (Activity) context,
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showDialog("External storage", context, Manifest.permission.READ_EXTERNAL_STORAGE);

                } else {
                    ActivityCompat
                            .requestPermissions(
                                    (Activity) context,
                                    new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }

        } else {
            return true;
        }
    }

    public void showDialog(final String msg, final Context context, final String permission) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setCancelable(true);
        alertBuilder.setTitle("Permission necessary");
        alertBuilder.setMessage(msg + " permission is necessary");
        alertBuilder.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions((Activity) context,
                                new String[] { permission },
                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    }
                });
        AlertDialog alert = alertBuilder.create();
        alert.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // do your stuff
            } else {
                //Toast.makeText(, "GET_ACCOUNTS Denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions,
                    grantResults);
        }
    }

    private final View.OnClickListener enregistreListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!wallpaperSaved.contains(txt.getText().toString())) {
                wallpaperSaved.add(txt.getText().toString());
            }
            System.out.println(wallpaperSaved.toString());
            Gson gson = new Gson();
            String json = gson.toJson(wallpaperSaved);
            editor.putString("WallpaperSaveList",json);
            editor.commit();
            if(wallpaperSaved.size() >= 2){
                wallpaperDroite.setEnabled(true);
                wallpaperGauche.setEnabled(true);
            }
            int i = wallpaperSaved.size()-1;
            editor.putInt("Act",i);
            editor.commit();
        }
    };

    public ArrayList<String> jsonToHash(){
        ArrayList<String> out = new ArrayList<>();
        String stored = sharedPref.getString("WallpaperSaveList","new");
        if(!stored.equals("new")){
            java.lang.reflect.Type type = new TypeToken<ArrayList<String>>(){}.getType();
            Gson gson = new Gson();
            out = gson.fromJson(stored,type);
        }
        return out;
    }

    private final View.OnClickListener gauche = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            gauche();
        }
    };


    private final View.OnClickListener droite = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           droite();
        }
    };


    protected void gauche(){
        int i = sharedPref.getInt("Act",0);
        if(i==0){
            i = wallpaperSaved.size()-1;
        }else{
            i--;
        }
        editor.putInt("Act",i);
        editor.commit();
        String uri = wallpaperSaved.get(i);
        txt.setText(uri);
        Uri uri1 = Uri.parse(uri);
        try {
            img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(uri1)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void droite(){
        int i = sharedPref.getInt("Act",0);
        if(i==wallpaperSaved.size()-1){
            i = 0;
        }else{
            i++;
        }
        editor.putInt("Act",i);
        editor.commit();
        String uri = wallpaperSaved.get(i);
        txt.setText(uri);
        Uri uri1 = Uri.parse(uri);
        try {
            img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(uri1)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                       droite();
                    }

                    // Right to left swipe action
                    else
                    {
                        gauche();
                    }

                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private final View.OnClickListener supprListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int i = sharedPref.getInt("Act",0);
            wallpaperSaved.remove(i);
            Gson gson = new Gson();
            String json = gson.toJson(wallpaperSaved);
            editor.putString("WallpaperSaveList",json);
            editor.commit();
            i--;
            editor.putInt("Act",i);
            editor.commit();
            try {
                img.setImageBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(wallpaperSaved.get(i)))));
            }catch (Exception ignored){}
            txt.setText(wallpaperSaved.get(i));
        }
    };

}