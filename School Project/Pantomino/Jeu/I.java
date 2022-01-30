import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class I extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public I() throws IOException{
        super("I.txt",'I');
    }
}