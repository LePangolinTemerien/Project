import java.io.*;
import java.util.ArrayList;

/**
 * Class héritière de piece
 */
public class F extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public F() throws IOException{
        super("F.txt",'F');
    }
}
