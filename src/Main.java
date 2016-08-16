import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Characters.Arquero;
import Characters.Guerrero;
import Characters.Mago;
import Characters.Personajes;
import ItemsPackage.*;
import MathEngine.Battle;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

public class Main{
    private static final String reset = "\u001B[0m";
    private static final String red= "\u001B[31m";
    private static final String blue = "\u001B[34m";
    private static final String green = "\u001B[32m";
    private static final String negrita = "\033[0;1m";
    private static final Multimap<Personajes,List<Item>> pjItems =ArrayListMultimap.create();
    private static final List<Personajes> listaPersonajes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        crearPersonajes(sc);
        bloqueAñadirItems(sc);
        resumen();
        battle(sc);
    }

    private static void crearPersonajes(Scanner sc) {
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
                            mana = sc.nextDouble();}while (mana<1||mana>175-vida);
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
    private static void bloqueAñadirItems(Scanner sc) {
        int contPJ=0;//para diferenciar el personaje cero del siguiente
        for (Personajes personajes:listaPersonajes ) {
            System.out.println(personajes.devolverClase()+" "+personajes.getNombre()+" elige uno de estos dos items");
            System.out.println("1-Espada1,escudo2");
            System.out.println("2-Escudo1,espada2");
            int eleccion=sc.nextInt();
            switch (eleccion){
                case 1:
                    if (contPJ==0){
                        Sword sword1= SwordItems.createSword1();
                        Shield shield2= ShieldItems.createShield2();
                        List<Item>items=AddItemToPlayer.createItemList(sword1,shield2);
                        pjItems.put(personajes,items);
                        contPJ++;
                        break;
                    }else{
                        Sword sword1=SwordItems.createSword1();
                        Shield shield2=ShieldItems.createShield2();
                        List<Item>items=AddItemToPlayer.createItemList(sword1,shield2);
                        pjItems.put(personajes,items);
                        break;
                    }
                case 2:
                    if (contPJ==0){
                        Sword sword2=SwordItems.createSword2();
                        Shield shield1=ShieldItems.createShield1();
                        List<Item>item=AddItemToPlayer.createItemList(sword2,shield1);
                        pjItems.put(personajes,item);
                        contPJ++;
                        break;
                    }else{
                        Sword sword2=SwordItems.createSword2();
                        Shield shield1=ShieldItems.createShield1();
                        List<Item>item=AddItemToPlayer.createItemList(sword2,shield1);
                        pjItems.put(personajes,item);
                        break;
                    }
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
    private static void battle(Scanner sc) {
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
                                battle(sc);
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

