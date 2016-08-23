package ItemsPackage;

import java.util.Comparator;

public class Potions extends Item{

    protected Potions (String itemName, int price, int lifeRestored,int manaRestored){
        super(itemName,price);
        this.lifeRestored=lifeRestored;
        this.manaRestored=manaRestored;
    }

    @Override
    public int getLifeRestored() {
        return lifeRestored;
    }
    @Override
    public void setLifeRestored(int lifeRestored) {
        this.lifeRestored = lifeRestored;
    }

    @Override
    public int getManaRestored() {
        return manaRestored;
    }
    @Override
    public void setManaRestored(int manaRestored) {
        this.manaRestored = manaRestored;
    }

    public int getPrice() {
        return price;
    }
}

