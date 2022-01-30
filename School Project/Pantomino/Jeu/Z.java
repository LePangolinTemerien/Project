import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class Z extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public Z() throws IOException{
        super("Z.txt",'Z');
    }
}