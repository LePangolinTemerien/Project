import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class L extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public L() throws IOException{
        super("L.txt",'L');
    }
}