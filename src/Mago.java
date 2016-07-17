public class Mago extends Personajes {

    public Mago(double vida, double mana, String nombre,int armadura,String nombreclase) {
        super (vida,mana,nombre,armadura,nombreclase);
    }

    public int valorAtaque=8;
    public int numeroaleatorio=(int)(Math.random()*2+1);
    public double ataque=(valorAtaque*numeroaleatorio);
    @Override
    public double ataque(){
        return ataque;
    }


    public String menu="[1]Atacar\n" +
            "[2]Tu ataque hace un 50% menos de daño pero te cura un 50%\n" +
            "[3]Pasar turno (recuperas el 25% de salud)";
    @Override
    public String devolverMenu(){
        return menu;
    }
}
