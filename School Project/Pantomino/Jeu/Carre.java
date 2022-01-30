import java.io.Serializable;

/**
 * Class qui va crée les carré et toutes ses intercation qui serviront a formée les pièces
 */
public class Carre implements Serializable {

  private int x;
  private int y;

  /**
   * constructeur vide  mettant les deux attributs à 0.
   */
  public Carre(){
    this.x=0;
    this.y=0;
  }

  /**
   * constructeur à 2 paramètres vérifie si ils ne sont pas negatifs
   * @param abs abscisse du carré
   * @param ord ordonnée du carré
   */
  public Carre(int abs, int ord){
    if (abs < 0 || ord < 0) {
      this.x=0;
      this.y=0;
    }else{
      this.x=abs;
      this.y=ord;
    }
  }

  /**
   * getteur retournant
   * @return x , abscisse du carré
   */
  public int getX(){
    return this.x;
  }

  /**
   * getteur retournant
   * @return y , ordonnée du carré
   */
  public int getY(){
    return this.y;
  }

  /**
   * methode toString
   * @return Sring contenant les infos du carré
   */
  public String toString(){
    return "("+this.getX()+","+this.getY()+")";
  }






}
