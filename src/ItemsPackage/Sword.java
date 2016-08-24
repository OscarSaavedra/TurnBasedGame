package ItemsPackage;

public class Sword extends Item{

    public Sword(String itemName,int price,int addAttack){
        super(itemName,price);
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
