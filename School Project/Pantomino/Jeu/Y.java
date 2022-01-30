import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class Y extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public Y() throws IOException{
        super("Y.txt",'Y');
    }
}