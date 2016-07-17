public class Guerrero extends Personajes {

    public Guerrero(double vida, double mana, String nombre,int armadura,String nombreclase) {
        super (vida,mana,nombre,armadura,nombreclase);
    }

    public int valorAtaque=5;
    public double ataque=valorAtaque;


    @Override
    public double ataque(){
        return ataque;
    }


    public int numAleatorio=(int)(Math.random()*4+1);



    public String menu= "[1]Atacar\n" +
            "[2]Escudarse, la armadura aumenta 20 puntos\n" +
            "[3]Pasar turno (recuperas el 30% de salud)";
    @Override
    public String devolverMenu(){
        return menu;
    }

    public double getVida(){
        return vida;
    }
}
