import java.io.IOException;
/**
 * Class héritière de piece
 */
public class T extends Piece{
    /**
     * constructeur de la classe de la lettre
     * @throws IOException : Si le fichier n'est pas trouvé
     */
    public T() throws IOException {
        super("T.txt",'T');
    }
}
