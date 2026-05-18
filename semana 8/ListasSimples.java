/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

class Nodo {

    int dato;
    Nodo siguiente;

    Nodo(int dato) {
        this.dato = dato;
    }
}

public class ListasSimples {

    // Agregar nodo
    static Nodo agregar(Nodo cabeza, int dato) {

        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            return nuevo;
        }

        Nodo temp = cabeza;

        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = nuevo;

        return cabeza;
    }

    // Mostrar lista
    static void mostrar(Nodo cabeza) {

        while (cabeza != null) {
            System.out.print(cabeza.dato + " -> ");
            cabeza = cabeza.siguiente;
        }

        System.out.println("null");
    }

    // 1. Invertir lista
    static Nodo invertir(Nodo cabeza) {

        Nodo anterior = null;

        while (cabeza != null) {

            Nodo siguiente = cabeza.siguiente;
            cabeza.siguiente = anterior;
            anterior = cabeza;
            cabeza = siguiente;
        }

        return anterior;
    }

    // 2. Detectar ciclo con Floyd
    static boolean tieneCiclo(Nodo cabeza) {

        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {

            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    // 3. Fusionar listas ordenadas
    static Nodo fusionar(Nodo a, Nodo b) {

        Nodo resultado = new Nodo(0);
        Nodo temp = resultado;

        while (a != null && b != null) {

            if (a.dato < b.dato) {
                temp.siguiente = a;
                a = a.siguiente;
            } else {
                temp.siguiente = b;
                b = b.siguiente;
            }

            temp = temp.siguiente;
        }

        if (a != null) {
            temp.siguiente = a;
        }

        if (b != null) {
            temp.siguiente = b;
        }

        return resultado.siguiente;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =========================
        // LISTA NORMAL
        // =========================

        Nodo lista = null;

        System.out.print("¿Cuántos números deseas agregar?: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese número: ");
            int num = sc.nextInt();

            lista = agregar(lista, num);
        }

        System.out.println("\nLista original:");
        mostrar(lista);

        // Invertir lista
        lista = invertir(lista);

        System.out.println("Lista invertida:");
        mostrar(lista);

        // Detectar ciclo
        System.out.println("¿Tiene ciclo?: " + tieneCiclo(lista));

        // =========================
        // FUSIÓN DE LISTAS
        // =========================

        Nodo lista1 = null;
        Nodo lista2 = null;

        System.out.print("\nCantidad de números para lista 1: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {

            System.out.print("Número lista 1: ");
            lista1 = agregar(lista1, sc.nextInt());
        }

        System.out.print("\nCantidad de números para lista 2: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {

            System.out.print("Número lista 2: ");
            lista2 = agregar(lista2, sc.nextInt());
        }

        Nodo fusionada = fusionar(lista1, lista2);

        System.out.println("\nLista fusionada:");
        mostrar(fusionada);

        sc.close();
    }
}