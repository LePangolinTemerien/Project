import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class S extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public S() throws IOException{
        super("S.txt",'S');
    }
}