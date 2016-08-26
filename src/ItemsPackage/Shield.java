package ItemsPackage;


public class Shield extends Item {

    protected Shield(String itemName,int price,int size, int addDefense, int addLife) {
        super(itemName,price,size);
        this.addDefense=addDefense;
        this.addLife=addLife;
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

    public int getPrice() {
        return price;
    }
}
