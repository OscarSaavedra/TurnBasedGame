package Characters;

public abstract class Personajes {
    protected String nombre;
    protected double vida;
    protected double mana;
    protected int armadura;
    protected String nombreclase;
    protected double ataque;
    protected String menu;
    protected int money;

    public Personajes(double vida,double mana, String nombre,int armadura,String nombreclase){
        this.vida=vida;
        this.mana=mana;
        this.nombre=nombre;
        this.armadura=armadura;
        this.nombreclase=nombreclase;
    }

    public void setVida(double restedLife){
        this.vida=restedLife;
    }
    public void setMana(double manaRestante){
        mana=manaRestante;
    }
    public void setArmor(int nArmorValue){
        this.armadura=nArmorValue;
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

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public boolean enoughMoney(int playerMoney, int itemPrice){
        boolean enough=true;
        if (playerMoney>itemPrice||playerMoney==itemPrice){
            enough=true;
        }else if (playerMoney<itemPrice){
            enough=false;
        }
        return enough;
    }

    public String devolverMenu(){
        return menu;
    }

}
