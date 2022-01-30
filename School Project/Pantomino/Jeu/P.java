import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class P extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public P() throws IOException{ 
        super("P.txt",'P');
    }
}