package Characters;

import Characters.Personajes;

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

    @Override
    public double ataque(){
        return ataque;
    }


    private String menu= "[1]Atacar\n" +
            "[2]El próximo ataque que recibas tiene un 50% de fallar\n" +
            "[3]Pasar turno (recuperas el 40% de salud)\n"+
            "[4]Abrir inventario.";
    @Override
    public String devolverMenu(){
        return menu;
    }

    @Override
    public String toString() {
        return "Arquero {"+nombre+"}";
    }
}
