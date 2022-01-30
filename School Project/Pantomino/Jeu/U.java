import java.io.*;
import java.util.ArrayList;
/**
 * Class héritière de piece
 */
public class U extends Piece {
  /**
   * constructeur de la classe de la lettre
   * @throws IOException : Si le fichier n'est pas trouvé
   */
  public U() throws IOException{
    super("U.txt",'U');
  }
}