package ItemsPackage;

public class SwordItems {
    private static Sword sword;
    public static Sword createSword1(){
        sword=new Sword("Espada1",1,30);
        return sword;
    }

    public static Sword createSword2(){
        sword=new Sword("Espada2",2,40);
        return sword;
    }

    public static Sword createSword3(){
        sword=new Sword("Espada3",3,50);
        return sword;
    }

    public static Sword createSword4(){
        sword=new Sword("Espada4",4,60);
        return sword;
    }
}
