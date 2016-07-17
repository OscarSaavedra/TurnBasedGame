public abstract class Personajes {
    protected String nombre;
    protected double vida;
    protected double mana;
    protected int armadura;
    protected String nombreclase;
    protected double ataque;
    protected String menu;

    public Personajes(double vida, double mana, String nombre,int armadura,String nombreclase){
        this.vida=vida;
        this.mana=mana;
        this.nombre=nombre;
        this.armadura=armadura;
        this.nombreclase=nombreclase;
    }

    public String getNombre(){
        return nombre;
    }
    public double getVida(){
        return vida;
    }
    public double getMana(){
        return mana;
    }
    public int getArmadura(){
        return armadura;
    }
    public String devolverClase(){
        return nombreclase;
    }

    public double ataque(){
        return ataque;
    }
    public String devolverMenu(){
        return menu;
    }

}
