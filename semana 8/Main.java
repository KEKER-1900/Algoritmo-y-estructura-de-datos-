/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author keler
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =========================
        // LISTA NORMAL
        // =========================

        ListaSimple lista = new ListaSimple();

        System.out.print("¿Cuántos números deseas agregar?: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese número: ");
            lista.agregar(sc.nextInt());
        }

        System.out.println("\nLista original:");
        lista.mostrar();

        // Invertir lista
        lista.invertir();

        System.out.println("\nLista invertida:");
        lista.mostrar();

        // Detectar ciclo
        System.out.println("\n¿Tiene ciclo?: " + lista.tieneCiclo());

        // =========================
        // FUSIÓN DE LISTAS
        // =========================

        ListaSimple lista1 = new ListaSimple();
        ListaSimple lista2 = new ListaSimple();

        System.out.print("\nCantidad de números para lista 1: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {

            System.out.print("Número lista 1: ");
            lista1.agregar(sc.nextInt());
        }

        System.out.print("\nCantidad de números para lista 2: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {

            System.out.print("Número lista 2: ");
            lista2.agregar(sc.nextInt());
        }

        ListaSimple fusionada = ListaSimple.fusionar(lista1, lista2);

        System.out.println("\nLista fusionada:");
        fusionada.mostrar();

        sc.close();
    }
}