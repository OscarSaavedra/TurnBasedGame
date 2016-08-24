import ItemsPackage.*;

public class Shop {
    public static void shopMenuTitle(){
        System.out.println("++++++++++");
        System.out.println("++TIENDA++");
        System.out.println("++++++++++");
    }

    public static void shopMenuOptions(){
        System.out.println("[1]Armas");
        System.out.println("[2]Armaduras");
        System.out.println("[3]Pociones");
        System.out.println("[4]Salir");

    }
    public static void weaponShop(){
        Sword sword1= SwordItems.createSword1();
        Sword sword2= SwordItems.createSword2();
        Sword sword3=SwordItems.createSword3();
        Sword sword4=SwordItems.createSword4();
        Sword sword5=SwordItems.createSword5();
        Sword sword6=SwordItems.createSword6();
        System.out.println("[1] "+sword1);
        System.out.println("[2] "+sword2);
        System.out.println("[3] "+sword3);
        System.out.println("[4] "+sword4);
        System.out.println("[5] "+sword5);
        System.out.println("[6] "+sword6);
        System.out.println("[7] Atrás");
    }

    public static void armorShop(){
        Shield shield1= ShieldItems.createShield1();
        Shield shield2= ShieldItems.createShield2();
        Shield shield3= ShieldItems.createShield3();
        Shield shield4= ShieldItems.createShield4();
        Shield shield5= ShieldItems.createShield5();
        Shield shield6= ShieldItems.createShield6();
        System.out.println("[1] "+shield1);
        System.out.println("[2] "+shield2);
        System.out.println("[3] "+shield3);
        System.out.println("[4] "+shield4);
        System.out.println("[5] "+shield5);
        System.out.println("[6] "+shield6);
        System.out.println("[7] Atrás");
    }

    public static void potionShop(){
        Potions potionHP1=PotionItems.createHPpotion1();
        Potions potionHP2=PotionItems.createHPpotion2();
        Potions potionMP1=PotionItems.createMPpotion1();
        Potions potionMP2=PotionItems.createMPpotion2();
        System.out.println("[1] "+potionHP1);
        System.out.println("[2] "+potionHP2);
        System.out.println("[3] "+potionMP1);
        System.out.println("[4] "+potionMP2);
        System.out.println("[5] Atrás");

    }
}
