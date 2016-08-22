package ItemsPackage;

public class ShieldItems {
    private static Shield shield;

    public static Shield createShield1(){
        shield=new Shield("Shield1",1,10,50);
        return shield;
    }

    public static Shield createShield2(){
        shield=new Shield("Shield2",2,15,60);
        return shield;
    }

    public static Shield createShield3(){
        shield=new Shield("Shield3",3,20,70);
        return shield;
    }

    public static Shield createShield4(){
        shield=new Shield("Shield4",4,25,80);
        return shield;
    }
}
