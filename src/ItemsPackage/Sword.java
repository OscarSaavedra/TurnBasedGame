package ItemsPackage;

public class Sword extends Item{

    public Sword(String itemName,int addAttack){
        super(itemName);
        this.addAttack=addAttack;
    }

    public int getAddAttack() {
        return addAttack;
    }
    public void setAddAttack(int addAttack) {
        this.addAttack = addAttack;
    }
}
