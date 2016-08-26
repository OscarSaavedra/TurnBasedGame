package ItemsPackage;

import com.sun.javaws.Main;

import java.util.ArrayList;


public class SwordItems {
    private static Sword sword;
    public static Sword createSword1(){//ID0
        sword=new Sword("Espada de madera",30,30,1);
        return sword;
    }

    public static Sword createSword2(){//ID1
        sword=new Sword("Espada de piedra",40,30,2);
        return sword;
    }

    public static Sword createSword3(){//ID2
        sword=new Sword("Espada de bronce",50,30,3);
        return sword;
    }

    public static Sword createSword4(){//ID3
        sword=new Sword("Espada de hierro",60,30,4);
        return sword;
    }

    public static Sword createSword5(){//ID4
        sword=new Sword("Espada de acero",70,30,5);
        return sword;
    }

    public static Sword createSword6(){
        sword=new Sword("Espada de fuego",100,30,10);
        return sword;
    }

    public static Sword swordList(int swordId){
        Sword sword1=createSword1();
        Sword sword2=createSword2();
        Sword sword3=createSword3();
        Sword sword4=createSword4();
        Sword sword5=createSword5();
        Sword sword6=createSword6();
        ArrayList<Sword>list=new ArrayList<>();
        list.add(sword1);
        list.add(sword2);
        list.add(sword3);
        list.add(sword4);
        list.add(sword5);
        list.add(sword6);

        return list.get(swordId-1);

    }
}
