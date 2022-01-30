import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class J extends Piece {
    /**
     * constructeur de la piece J
     * @throws IOException : Si le fichier n'est pas trouvé
     */

    public J() throws IOException{
        super("J.txt",'J');
    }
}