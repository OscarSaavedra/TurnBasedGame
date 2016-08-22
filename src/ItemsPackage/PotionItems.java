package ItemsPackage;

public class PotionItems {

    private static Potions potion;

    public static Potions createHPpotion1(){
        potion=new Potions("Poción pequeña de salud",20,0,10);
        return potion;
    }

    public static Potions createMPpotion1(){
        potion=new Potions("Poción pequeña de maná",0,20,10);
        return potion;
    }

    public static Potions createHPpotion2(){
        potion=new Potions("Pocion mediana de salud",40,0,20);
        return potion;
    }

    public static Potions createMPpotion2(){
        potion=new Potions("Poción mediana de salud",40,0,20);
        return potion;
    }
}
