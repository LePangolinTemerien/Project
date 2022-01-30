import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class O extends Piece {
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public O() throws IOException{
        super("O.txt",'O');
    }
}