import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class N extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public N() throws IOException{
        super("N.txt",'N');
    }
}