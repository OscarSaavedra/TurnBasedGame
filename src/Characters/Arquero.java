package Characters;



public class Arquero extends Personajes {

    public Arquero(double vida, double mana,String nombre,int armadura,String nombreclase) {
        super(vida,mana,nombre,armadura,nombreclase);
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

    private int valorAtaque=2;
    private double ataque=(valorAtaque*(int)(Math.random()*15+1));
    private int money=100;
    private String menu= "[1]Atacar\n" +
            "[2]El próximo ataque que recibas tiene un 50% de fallar\n" +
            "[3]Pasar turno (recuperas el 40% de salud)\n"+
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

    public String toString() {
        return "Arquero {"+nombre+"}";
    }
}
