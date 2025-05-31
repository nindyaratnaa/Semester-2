package mains;

import java.util.Scanner;

import models.*;

public class kalkulatorPabrik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Isikan nama: ");
        String nama = input.nextLine();

        System.out.print("Isikan NIM: ");
        String NIM = input.nextLine();

        System.out.print("Isikan radius major: ");
        double major = input.nextDouble();

        System.out.print("Isikan radius minor: ");
        double minor = input.nextDouble();
        torus Torus = new torus(major, minor);
                
        System.out.print("Isikan radius donat tanpa lubang: ");
        double radius = input.nextDouble();
        sphere sphere = new sphere(radius);

        input.close();

        System.out.println("=============================================");
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println(nama);
        System.out.println(NIM);
        System.out.println("=============================================");
        System.out.println("Donat dengan lubang");
        System.out.println("=============================================");
        System.out.println("Isikan Radius   : " + major);
        System.out.println("Isikan radius   : " + minor);
        System.out.println("=============================================");
        Torus.printInfo();
        System.out.println("=============================================");
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        System.out.println("Isikan radius   : " + radius);
        System.out.println("=============================================");
        sphere.printInfo();
        System.out.println("=============================================");
    }
}
