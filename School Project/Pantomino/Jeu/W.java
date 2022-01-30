import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class W extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public W() throws IOException{
        super("W.txt",'W');
    }
}