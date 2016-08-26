package ItemsPackage;

public class Sword extends Item{

    public Sword(String itemName,int price,int size,int addAttack){
        super(itemName,price,size);
        this.addAttack=addAttack;
    }

    public int getAddAttack() {
        return addAttack;
    }
    public void setAddAttack(int addAttack) {
        this.addAttack = addAttack;
    }
    public int getPrice() {
        return price;
    }
}
