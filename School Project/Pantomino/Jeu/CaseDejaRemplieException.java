/**
 * Class excpetion
 */
public class CaseDejaRemplieException extends Exception{

    /**
     * Constructeur vide de l'exception
     */
    public CaseDejaRemplieException(){
        super();
    }

    /**
     * Constructeur avec message de l'eexception
     * @param m : message
     */
    public  CaseDejaRemplieException(String m){
        super(m);
    }
}