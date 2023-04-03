package uqac.dim.personnages;

public class Mage extends Personnage{

    public int pm;

    public Mage(){

        super("Mage", Alignement.BON, "Le maitre des runes", 3, 5, 7);
        pm = 5;
    }

    public int getPM(){
        return pm;
    }

    public final void setPM(int pm){

        this.pm = validerValeur(pm);
    }
}
