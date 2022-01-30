/**
 * Class exception
 */
public class PieceDebordeException extends Exception{

    /**
     * constructeur vide de l'exception
     */
    public PieceDebordeException(){
        super();
    }

    /**
     * Constructeur avec message de l'exception
     * @param m : message
     */
    public PieceDebordeException(String m){
        super(m);
    }
}