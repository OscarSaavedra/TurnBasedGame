package Characters;

public class Mago extends Personajes {

    public Mago(double vida, double mana, String nombre,int armadura,String nombreclase) {
        super (vida,mana,nombre,armadura,nombreclase);
    }

    private int valorAtaque=8;
    private int numeroaleatorio=(int)(Math.random()*2+1);
    private double ataque=(valorAtaque*numeroaleatorio);
    private int money=100;
    public String menu="[1]Atacar\n" +
            "[2]Tu ataque hace un 50% menos de daño pero te cura un 50% (coste 50mp)\n" +
            "[3]Pasar turno (recuperas el 25% de salud)\n"+
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

    public void setMana(double manaRestante){
        this.mana=manaRestante;
    }
    public void setVida(double vidaRestante){
        this.vida=vidaRestante;
    }

    public void setArmor(int nArmorValue){
        this.armadura=nArmorValue;
    }

    public String toString() {
        return "Mago {"+nombre+"}";
    }
}
