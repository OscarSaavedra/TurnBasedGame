import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main extends JComponent{
    public static Multimap<String,List<Personajes>>multimapContrinc= ArrayListMultimap.create();

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Juego");
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        JPanel panel = new JPanel();
        panel.setVisible(true);
        ventana.add(panel);


        FlowLayout seleccionPJ1 = new FlowLayout();
        panel.setLayout(seleccionPJ1);
        JButton botonGuer, botonArquero, botonMago;
        botonGuer = new JButton("Guerrero");
        botonArquero = new JButton("Arquero");
        botonMago = new JButton("Mago");
        panel.add(botonGuer);
        panel.add(botonArquero);
        panel.add(botonMago);


        FlowLayout nombre1=new FlowLayout();
        panel.setLayout(nombre1);
        JTextField textfield11 = new JTextField("Introduce tu nombre");
        panel.add(textfield11);


        FlowLayout seleccionPJ2 = new FlowLayout();
        panel.setLayout(seleccionPJ2);
        JButton botonGuer2, botonArquero2, botonMago2;
        botonGuer2 = new JButton("Guerrero");
        botonArquero2 = new JButton("Arquero");
        botonMago2 = new JButton("Mago");
        panel.add(botonGuer2);
        panel.add(botonArquero2);
        panel.add(botonMago2);

        FlowLayout nombre2=new FlowLayout();
        panel.setLayout(nombre2);
        JTextField textfield12 = new JTextField("Introduce tu nombre");
        panel.add(textfield12);



        Scanner sc = new Scanner(System.in);

        List<Personajes> listaPersonajes = new ArrayList<>();


        System.out.println("Cuantos personajes quieres crear? (introduce 2 para 1vs1)");
        int cantidadPJ = sc.nextInt();
        crearPersonajes(sc, listaPersonajes, cantidadPJ);
        textfield11.setName("hola");
        for (Personajes personajes : listaPersonajes) {
            System.out.println("  " + personajes.devolverClase() + " " + personajes.getNombre());
            System.out.println("[HP]: " + personajes.getVida());
            System.out.println("[MP]: " + personajes.getMana());
            System.out.println("[DEF]: " + personajes.getArmadura());
            System.out.println("  ");
        }


        double ataqueRecibido=0;
        double ataqueAcumulado=0;
        for (int i = 0; i < 10; i++) {
            for (Personajes contrincantes : listaPersonajes) {
                int eleccion;

                    System.out.println("Turno del " + contrincantes.devolverClase() + " " + contrincantes.getNombre());
                    ataqueAcumulado=ataqueAcumulado+ataqueRecibido;
                    System.out.println("Vida: " + (contrincantes.getVida()-ataqueAcumulado));
                    System.out.println(contrincantes.devolverMenu());
                    eleccion = sc.nextInt();

                    switch (eleccion) {
                        case 1:
                            System.out.println("Ataque del " + contrincantes.devolverClase() + contrincantes.getNombre() + ": " + contrincantes.ataque());
                            ataqueRecibido=contrincantes.ataque();
                            break;

                        case 2:
                            if (contrincantes.devolverClase().equals("Guerrero")) {
                                contrincantes.armadura += +20;
                            } else {
                                if (contrincantes.devolverClase().equals("Arquero")) {
                                    System.out.println("funciona");
                                } else {
                                    if (contrincantes.devolverClase().equals("Mago")) {
                                        contrincantes.ataque = contrincantes.ataque / 2;
                                        contrincantes.vida = ((contrincantes.vida + (0.5 * contrincantes.vida)));
                                    }
                                }
                            }
                            break;
                        case 3:
                            if (contrincantes.devolverClase().equals("Guerrero")) {
                                contrincantes.vida = contrincantes.vida + 0.30 * contrincantes.vida;
                            } else {
                                if (contrincantes.devolverClase().equals("Arquero")) {
                                    contrincantes.vida = contrincantes.vida + 0.40 * contrincantes.vida;
                                } else {
                                    if (contrincantes.devolverClase().equals("Mago")) {
                                        contrincantes.vida = contrincantes.vida + 0.25 * contrincantes.vida;
                                    }
                                }
                            }
                            break;
                    }
                    System.out.println("--------------------------------");
                    System.out.println("          ");
                }
            }
        }



    private static void crearPersonajes(Scanner sc, List<Personajes> listaPersonajes, int cantidadPJ) {
        double vida,mana;
        int armadura,i;
        String nombre;
        boolean confirmacion = true;
        while (confirmacion) {
            for (i = 1; i <= cantidadPJ; i++) {
                System.out.println("Selecciona la clase del personaje :");
                System.out.println("--------------------");
                System.out.println("[1]Guerrero----[2]Arquero----[3]Mago");
                int seleccion = sc.nextByte();
                if (seleccion == 1) {
                    String nombreclase = "Guerrero";
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
                    Guerrero guerrero = new Guerrero(vida, mana, nombre, armadura, nombreclase);
                    listaPersonajes.add(guerrero);

                } else {
                    if (seleccion == 2) {
                        String devolverclase = "Arquero";
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
                        Arquero arquero = new Arquero(vida, mana, nombre, armadura, devolverclase);
                        listaPersonajes.add(arquero);
                    } else {
                        if (seleccion == 3) {
                            String nombreclase = "Mago";
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
                            Mago mago = new Mago(vida, mana, nombre, armadura, nombreclase);
                            listaPersonajes.add(mago);
                        }
                    }
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
}

