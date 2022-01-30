import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class Recup implements Serializable {

    private Menu menu;
    private final ArrayList<Menu> menuMap;
    private String date;

    public Recup() throws IOException {
        menuMap = new ArrayList<>();
        URL url = new URL("https://www.crous-lorraine.fr/restaurant/medreville/");
        String essaie;
        try (InputStream inputStream = url.openConnection().getInputStream()) {
            try (OutputStream outputStream = new FileOutputStream("out.txt")) {
                byte[] buffer = new byte[8192];
                int len;
                // boucle de lecture/ecriture
                while ((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.flush();
            }
        }
    }

    public void creationMenuMap() throws IOException {
        int i = 0;
        String key="";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("out.txt"));
        String s = "";
        while((s = bufferedReader.readLine()) != null){
            Menu menu = new Menu();
            if(s.contains("Menu du") || s.contains("Self")){
                s = s.replace("<h3>","");
                s = s.replace("</h3>","");
                String[] jsp = s.split("\\s+M");
                for(String s1 : jsp){
                    if(s1.contains("du") && !s1.contains("<ul") && !s1.contains("</ul>") && !s1.contains("div") && !s1.contains("<div><h4>Déjeuner</h4><div class=\"content-repas\"><div><span class=\"name\">Self</span><ul class=\"liste-plats\">")) {
                        s1 = "M"+s1;
                        System.out.println(s1);
                        byte[] date1 = s1.getBytes(StandardCharsets.ISO_8859_1);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DAY_OF_MONTH,i);
                        if(calendar.get(Calendar.WEEK_OF_MONTH) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
                            while(calendar.get(Calendar.WEEK_OF_MONTH) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
                                i++;
                                calendar.add(Calendar.DAY_OF_MONTH,i);
                            }
                        }
                        key = simpleDateFormat.format(calendar.getTime());
                        System.out.println(key);
                        date = new String(date1, StandardCharsets.UTF_8);
                        i++;
                    }
                }
                if(s.contains("Self")){
                    String[] jsp2 = s.split("</li>");
                    for(String s3 : jsp2){
                        s3 = s3.replace("<li>","");
                        s3 = s3.replace("<div><h4>Déjeuner</h4><div class=\"content-repas\"><div><span class=\"name\">Self</span><ul class=\"liste-plats\">","");
                        byte[] repas = s3.getBytes(StandardCharsets.ISO_8859_1);
                        if(!s3.contains("<ul") && !s3.contains("</ul>") && !s3.contains("div")){
                            menu.addListe(new String(repas,StandardCharsets.UTF_8));
                        }
                    }
                }
                menu.setTitre(date);
                System.out.println(menu);
                menuMap.add(menu);
            }
        }

    }

    public ArrayList<Menu> getMenuMap() {
        return menuMap;
    }
}
