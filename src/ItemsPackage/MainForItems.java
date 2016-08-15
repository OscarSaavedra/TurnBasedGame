package ItemsPackage;

import java.util.ArrayList;

public class MainForItems {
    /////////////////////////////////////////////
    ///////////////TEST CLASS////////////////////
    /////////////////////////////////////////////
    public static void main(String args[]){
        ArrayList<Item>listaItems=new ArrayList<>();
        Sword espada1=new Sword("Espada1",10);
        Shield escudo1=new Shield("Escudo1",15,20);
        listaItems.add(espada1);
        listaItems.add(escudo1);
        for (Item lista:listaItems) {
            if (!(lista instanceof Sword)){
                lista.setAddLife(99);
            }
            System.out.println(lista);
        }

        Shield shield1=ShieldItems.createShield1();
        Shield shield2=ShieldItems.createShield2();
        Shield shield3=ShieldItems.createShield3();


        System.out.println("Escudo 1: "+shield1);
        System.out.println("Escudo 2: "+shield2);
        System.out.println("Escudo 3: "+shield3);
    }
}
