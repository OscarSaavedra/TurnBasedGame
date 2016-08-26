package ItemsPackage;

import java.util.Comparator;

public abstract class Item {
    protected String itemName;
    protected int price;
    protected int addAttack;
    protected int addDefense;
    protected int addLife;
    protected int lifeRestored;
    protected int manaRestored;
    protected int size;


    public Item(String itemName,int price, int size) {
        this.itemName=itemName;
        this.price=price;
        this.size=size;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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

    public int getLifeRestored() {
        return lifeRestored;
    }
    public void setLifeRestored(int lifeRestored) {
        this.lifeRestored = lifeRestored;
    }

    public int getManaRestored() {
        return manaRestored;
    }
    public void setManaRestored(int manaRestored) {
        this.manaRestored = manaRestored;
    }



    @Override
    public String toString() {
        if (this instanceof Sword ){
            return "Espada{"+itemName +"}, Bonus ataque="+addAttack+", Precio="+price+
                    ", Espacio en inventario="+size;
        }else if(this instanceof Shield){
            return "Escudo {"+itemName +"}, Bonus defensa="+addDefense+
                    ", Bonus vida="+addLife+", Precio="+price+
                    ", Espacio en inventario="+size;
        }else if(this instanceof Potions){
            return "Poción{"+itemName+"}, Vida restaurada="+lifeRestored+
                    ", Maná restaurado="+manaRestored+", Precio="+price+
                    ", Espacio en inventario="+size;
        }
        return "";
    }

    public static class ComparatorByPrice implements Comparator<Item> {
        public int compare(Item i1,Item i2){
            if (i1.getPrice()>i2.getPrice()){
                return 1;
            }else if (i1.getPrice()==i2.getPrice()){
                return 0;
            }
            else return -1;
        }
    }

    public static class ComparatorByName implements Comparator<Item>{
        public int compare (Item i1,Item i2){
            return i1.getItemName().compareTo(i2.getItemName());
        }
    }
}


