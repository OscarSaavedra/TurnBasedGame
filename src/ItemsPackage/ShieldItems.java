package ItemsPackage;

import java.util.ArrayList;

public class ShieldItems {
    private static Shield shield;

    public static Shield createShield1(){ //ID0
        shield=new Shield("Escudo de madera",10,10,50);
        return shield;
    }

    public static Shield createShield2(){//ID1
        shield=new Shield("Escudo de piedra",20,15,60);
        return shield;
    }

    public static Shield createShield3(){//ID2
        shield=new Shield("Escudo de bronce",30,20,70);
        return shield;
    }

    public static Shield createShield4(){//ID3
        shield=new Shield("Escudo de hierro",40,25,80);
        return shield;
    }

    public static Shield createShield5(){//ID4
        shield=new Shield("Escudo de acero",50,30,90);
        return shield;
    }

    public static Shield createShield6(){//ID5
        shield=new Shield("Escudo de fuego",100,60,150);
        return shield;
    }

    public static Shield shieldList(int shieldID){
        Shield shield1=createShield1();
        Shield shield2=createShield2();
        Shield shield3=createShield3();
        Shield shield4=createShield4();
        Shield shield5=createShield5();
        Shield shield6=createShield6();
        ArrayList<Shield> list=new ArrayList<>();
        list.add(shield1);
        list.add(shield2);
        list.add(shield3);
        list.add(shield4);
        list.add(shield5);
        list.add(shield6);
        return list.get(shieldID-1);
    }
}
