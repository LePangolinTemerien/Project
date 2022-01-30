import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class X extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public X() throws IOException{
        super("X.txt",'X');
    }
}