package ItemsPackage;

import java.util.ArrayList;

public class PotionItems {

    private static Potions potion;

    public static Potions createHPpotion1(){//ID0
        potion=new Potions("Poción pequeña de salud",20,5,0,10);
        return potion;
    }

    public static Potions createMPpotion1(){
        potion=new Potions("Poción pequeña de maná",20,5,0,10);
        return potion;
    }

    public static Potions createHPpotion2(){
        potion=new Potions("Pocion mediana de salud",40,10,0,20);
        return potion;
    }

    public static Potions createMPpotion2(){
        potion=new Potions("Poción mediana de salud",40,10,0,20);
        return potion;
    }

    public static Potions potionsList(int potionID){
        Potions potion1=createHPpotion1();
        Potions potion2=createHPpotion2();
        Potions potion3=createMPpotion1();
        Potions potion4=createMPpotion2();
        ArrayList<Potions>list=new ArrayList<>();
        list.add(potion1);
        list.add(potion2);
        list.add(potion3);
        list.add(potion4);

        return list.get(potionID-1);
    }
}
