package ItemsPackage;

public abstract class Item {
    protected String itemName;
    protected int addAttack;
    protected int addDefense;
    protected int addLife;


    public Item(String itemName) {
        this.itemName=itemName;
    }

    public int getAddAttack() {
        return addAttack;
    }
    public void setAddAttack(int addAttack) {
        this.addAttack = addAttack;
    }

    public int getAddDefense() {
        return addDefense;
    }
    public void setAddDefense(int addDefense) {
        this.addDefense = addDefense;
    }

    public int getAddLife() {
        return addLife;
    }
    public void setAddLife(int addLife) {
        this.addLife = addLife;
    }



    @Override
    public String toString() {
        if (this instanceof Sword ){
            return "Espada{"+itemName +"}, Bonus ataque=" + addAttack +'}';
        }else if(this instanceof Shield){
            return "Escudo {"+itemName +"}, Bonus defensa=" + addDefense +
                    ", Bonus vida=" + addLife +'}';
        }
        return "";
    }
}
