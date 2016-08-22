package Characters;


public class Guerrero extends Personajes {

    public Guerrero(double vida, double mana, String nombre,int armadura,String nombreclase) {
        super (vida,mana,nombre,armadura,nombreclase);
    }

    private int valorAtaque=5;
    private double ataque=valorAtaque;
    private int money=100;
    private String menu= "[1]Atacar\n" +
            "[2]Escudarse, la armadura aumenta 20 puntos\n" +
            "[3]Pasar turno (recuperas el 30% de salud)\n"+
            "[4]Abrir inventario.";

    public double ataque(){
        return ataque;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String devolverMenu(){
        return menu;
    }


    public void setVida(double vidaRestante){
        this.vida=vidaRestante;
    }
    public void setMana(double manaRestante){
        this.mana=manaRestante;
    }

    public void setArmor(int nArmorValue){
        this.armadura=nArmorValue;
    }

    public String toString() {
        return "Guerrero {"+nombre+"}";
    }

    public double getVida(){
        return vida;
    }
}
