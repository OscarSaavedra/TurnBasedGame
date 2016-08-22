import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Characters.Arquero;
import Characters.Guerrero;
import Characters.Mago;
import Characters.Personajes;
import ItemsPackage.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main{
    private static final String reset = "\u001B[0m";
    private static final String red= "\u001B[31m";
    private static final String blue = "\u001B[34m";
    private static final String green = "\u001B[32m";
    private static final String negrita = "\033[0;1m";
    private static final Multimap<Personajes,List<Item>> pjItems =ArrayListMultimap.create();
    private static final List<Personajes> listaPersonajes = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        crearPersonajes();
        int contPJ=1;
        shop(contPJ);
        resumen();
        battle();
    }

    private static void crearPersonajes() {
        double vida,mana;
        int armadura,i;
        String nombre;
        boolean confirmacion = true;
        System.out.println("Cuantos personajes quieres crear? (introduce 2 para 1vs1)");
        int cantidadPJ = sc.nextInt();
        while (confirmacion) {
            for (i = 1; i <= cantidadPJ; i++) {
                System.out.println("Selecciona la clase del personaje :");
                System.out.println("--------------------");
                System.out.println("[1]Guerrero----[2]Arquero----[3]Mago");
                int seleccion = sc.nextByte();
                switch (seleccion){
                    case 1:
                        String clase1 = "Guerrero";
                        System.out.println("Has seleccionado el GUERRERO");
                        System.out.println("!La vida y el maná solo pueden sumar 175!");

                        do{System.out.println("Introduce la vida [de 1 al 175]");
                            vida = sc.nextDouble();} while(vida<1||vida>175);
                        do{System.out.println("Introduce el mana [de 1 a "+(175-vida)+"]");
                            mana = sc.nextDouble();}while (mana<1||mana>175-vida);
                        System.out.println("Introduce el nombre");
                        nombre = sc.next();
                        do{System.out.println("Introduce el valor de armadura [de 1 a 20]");
                            armadura = sc.nextInt();}while (armadura<1||armadura>20);
                        Guerrero guerrero = new Guerrero(vida, mana, nombre, armadura, clase1);
                        listaPersonajes.add(guerrero);
                        break;
                    case 2:
                        String clase2 = "Arquero";
                        System.out.println("Has seleccionado el ARQUERO");
                        System.out.println("!La vida y el maná solo pueden sumar 175!");
                        do{System.out.println("Introduce la vida [de 1 a 175]");
                            vida = sc.nextDouble();}while (vida<1||vida>175);
                        do{System.out.println("Introduce el mana [de 1 a "+(175-vida)+"]");
                            mana = sc.nextDouble();}while (mana<0||mana>175-vida);
                        System.out.println("Introduce el nombre");
                        nombre = sc.next();
                        do{System.out.println("Introduce el valor de armadura [de 1 a 10]");
                            armadura = sc.nextInt();}while (armadura<1||armadura>10);
                        Arquero arquero = new Arquero(vida, mana, nombre, armadura, clase2);
                        listaPersonajes.add(arquero);
                        break;
                    case 3:
                        String clase3 = "Mago";
                        System.out.println("Has seleccionado el MAGO");
                        System.out.println("!La vida y el maná solo pueden sumar 175!");
                        do{System.out.println("Introduce la vida [de 1 a 175]");
                            vida = sc.nextDouble();}while(vida<1||vida>175);
                        do{System.out.println("Introduce el mana [de 1 a "+(175-vida)+"]");
                            mana = sc.nextDouble();}while (mana<1||mana>175-vida);
                        System.out.println("Introduce el nombre");
                        nombre = sc.next();
                        do{System.out.println("Introduce el valor de armadura [de 1 a 10]");
                            armadura = sc.nextInt();}while (armadura<1||armadura>10);
                        Mago mago = new Mago(vida, mana, nombre, armadura, clase3);
                        listaPersonajes.add(mago);
                }
            }

            System.out.println("¿Quieres crear mas personajes? Si--No" );
            String confString = sc.next();
            if (confString.equals("no")) {
                confirmacion = false;
            }else {
                if (confString.equals("si")){
                    confirmacion=true;
                }
            }
        }
    }

    static final List<Item>itemspl1=new ArrayList<>();
    static final List<Item>itemspl2=new ArrayList<>();
    private static void shop(int contPJ) {
        for (Personajes personajes:listaPersonajes ) {
            if(personajes.getMoney()>=0){

            Shop.shopMenuTitle();
            System.out.print(personajes.devolverClase()+" "+personajes.getNombre()+" elige");
            System.out.println(" (dinero actual "+personajes.getMoney());
            Shop.shopMenuOptions();

            int eleccion=sc.nextInt();
                if (!pjItems.containsKey(personajes)){
                    pjItems.put(personajes,itemspl1);
                }

                    switch (eleccion){
                        case 1:
                            Shop.weaponShop();
                            int ans=sc.nextInt();
                            switch (ans){
                                case 1:
                                    if (contPJ==1){
                                        Sword sword1=SwordItems.createSword1();
                                        itemspl1.add(sword1);
                                        personajes.setMoney(personajes.getMoney()-sword1.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 2:
                                    if (contPJ==1){
                                        Sword sword2=SwordItems.createSword2();
                                        itemspl1.add(sword2);
                                        personajes.setMoney(personajes.getMoney()-sword2.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }


                                case 3:
                                    if (contPJ==1){
                                        Sword sword3=SwordItems.createSword3();
                                        itemspl1.add(sword3);
                                        personajes.setMoney(personajes.getMoney()-sword3.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 4:
                                    if (contPJ==1){
                                        Sword sword4=SwordItems.createSword4();
                                        itemspl1.add(sword4);
                                        personajes.setMoney(personajes.getMoney()-sword4.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 5:
                                    shop(1);
                                    break;
                            }

                        case 2:
                            Shop.armorShop();
                            int ans2=sc.nextInt();
                            switch (ans2){
                                case 1:
                                    if (contPJ==1){
                                        itemspl1.add(ShieldItems.createShield1());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 2:
                                    if (contPJ==1){
                                        itemspl1.add(ShieldItems.createShield2());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 3:
                                    if (contPJ==1){
                                        itemspl1.add(ShieldItems.createShield3());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 4:
                                    if (contPJ==1){
                                        itemspl1.add(ShieldItems.createShield4());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 5:
                                    shop(1);
                                    break;

                            }

                        case 3:
                            Shop.potionShop();
                            int ans3=sc.nextInt();
                            switch (ans3){
                                case 1:
                                    if (contPJ==1){
                                        Potions hpPotion1=PotionItems.createHPpotion1();
                                        itemspl1.add(hpPotion1);
                                        personajes.setMoney(personajes.getMoney()-hpPotion1.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 2:
                                    if (contPJ==1){
                                        Potions hpPotion2=PotionItems.createHPpotion2();
                                        itemspl1.add(hpPotion2);
                                        personajes.setMoney(personajes.getMoney()-hpPotion2.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 3:
                                    if (contPJ==1){
                                        Potions mpPotion1=PotionItems.createMPpotion1();
                                        itemspl1.add(mpPotion1);
                                        personajes.setMoney(personajes.getMoney()-mpPotion1.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }


                                case 4:
                                    if (contPJ==1){
                                        Potions mppotion2=PotionItems.createMPpotion2();
                                        itemspl1.add(mppotion2);
                                        personajes.setMoney(personajes.getMoney()-mppotion2.getPrice());
                                        if (personajes.getMoney()>0){
                                            shop(1);
                                        }else {
                                            break;
                                        }
                                    }

                                case 5:
                                    shop(1);
                                    break;
                            }

                    }
                }else{
                    System.out.println("Gastaste tu dinero");
                    break;
                }

        }
    }
    private static void resumen() {
        int contPJ2=0;
        for (Personajes personajes : listaPersonajes) {
            System.out.println("  " + personajes.devolverClase() + " " + personajes.getNombre());
            System.out.println(red+"[HP]: " + personajes.getVida()+reset);
            System.out.println(blue+"[MP]: " + personajes.getMana()+reset);
            System.out.println(green+"[DEF]: " + personajes.getArmadura()+reset);

            if (contPJ2==0){
                System.out.println("[ITEMS]: "+ pjItems.get(personajes));
                contPJ2++;
                System.out.println("  ");
            }else{
                System.out.println("[ITEMS]: "+pjItems.get(personajes));
            }
            System.out.println("-----------------------------");
        }
    }
    private static void battle() {
        int i=0; //1 muestra el daño bloqueado, 0 no lo muestra
        boolean bucle=true;
        double proteccionArmadura;
        double ataqueRecibido=0;
        while (bucle) {
            for (Personajes contrincantes : listaPersonajes) {
                proteccionArmadura=(ataqueRecibido*contrincantes.getArmadura()/100);

                System.out.println(negrita+"Turno del " + contrincantes.devolverClase()
                        + " " + contrincantes.getNombre()+reset);
                if(i!=0){
                    System.out.println("Su armadura ha bloqueado: "+proteccionArmadura+" de daño");
                }
                System.out.println("Vida: " + (contrincantes.getVida()-ataqueRecibido+proteccionArmadura));
                contrincantes.setVida(contrincantes.getVida()-ataqueRecibido+proteccionArmadura);
                System.out.println("Mana: "+contrincantes.getMana());
                System.out.println("Armadura: "+contrincantes.getArmadura());
                System.out.println("_________________________");

                if (contrincantes.getVida()<=0){
                    System.out.println("---------------");
                    System.out.println(contrincantes.devolverClase()+" "+contrincantes.getNombre()+" ha "+
                            "perdido!");
                    System.out.println("---------------");
                    bucle=false;
                    System.exit(0);
                }

                System.out.println(contrincantes.devolverMenu());
                int eleccion = sc.nextInt();

                    switch (eleccion) {
                        case 1:
                            System.out.println("Ataque del " + contrincantes.devolverClase()
                                    + contrincantes.getNombre() + ": " + contrincantes.ataque());
                            ataqueRecibido=contrincantes.ataque();
                            i=1;
                            break;

                        case 2:
                            if (contrincantes instanceof Guerrero) {
                                ataqueRecibido=0;
                                i=0;
                                contrincantes.setArmor(contrincantes.getArmadura()+20);
                                System.out.println("La armadura de "+contrincantes.getNombre()+" aumentó en 20");
                            } else {
                                if (contrincantes instanceof Arquero) {
                                    ataqueRecibido=0;
                                    i=0;
                                } else {
                                    if (contrincantes instanceof Mago &&contrincantes.getMana()>=50) {
                                        i=1;
                                        ataqueRecibido=contrincantes.ataque()/2;
                                        double vidaActual=contrincantes.getVida();
                                        double vidaSkillSuma=contrincantes.getVida()/2;
                                        contrincantes.setVida(vidaActual+vidaSkillSuma);
                                        System.out.println("Ataque del " + contrincantes.devolverClase()
                                                + contrincantes.getNombre() + ": " + contrincantes.ataque()/2);
                                        System.out.println("Regenera: "+vidaSkillSuma+" puntos de salud");
                                        contrincantes.setMana(contrincantes.getMana()-50);
                                    }else {
                                        System.out.println("Insuficiente maná!");
                                        i=0;
                                    }
                                }
                            }
                            break;
                        case 3:
                            if (contrincantes instanceof Guerrero) {
                                i=0;
                                ataqueRecibido=0;
                                double vidaActual=contrincantes.getVida();
                                double vidaSkillPasar=contrincantes.getVida()*0.30;
                                contrincantes.setVida(vidaActual+vidaSkillPasar);
                                System.out.println("Pasa turno y regenera "+vidaSkillPasar+" puntos de salud");
                            } else {
                                if (contrincantes instanceof Arquero) {
                                    i=0;
                                    ataqueRecibido=0;
                                    double vidaActual=contrincantes.getVida();
                                    double vidaSkillPasar=contrincantes.getVida()*0.40;
                                    contrincantes.setVida(vidaActual+vidaSkillPasar);
                                    System.out.println("Pasa turno y regenera "+vidaSkillPasar+" puntos de salud");
                                } else {
                                    if (contrincantes instanceof Mago) {
                                        i=0;
                                        ataqueRecibido=0;
                                        double vidaActual=contrincantes.getVida();
                                        double vidaSkillPasar=contrincantes.getVida()*0.25;
                                        contrincantes.setVida(vidaActual+vidaSkillPasar);
                                        System.out.println("Pasa turno y regenera "+vidaSkillPasar+" puntos de salud");
                                    }
                                }
                            }
                            break;
                        case 4:
                            System.out.println(pjItems.get(contrincantes));
                            System.out.println("Cerrar inventario?");
                            String s=sc.next();
                            if (s.equals("si")){
                                battle();
                            }else{
                                break;
                            }
                    }
                    System.out.println("--------------------------------");
                    System.out.println("          ");
                }
            }
        }
}

