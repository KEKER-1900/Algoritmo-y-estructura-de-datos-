public class ListaSimple {

    Nodo cabeza;

    // Agregar nodo
    public void agregar(int dato) {

        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo temp = cabeza;

        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {

        Nodo temp = cabeza;

        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }

        System.out.println("null");
    }

    // Invertir lista
    public void invertir() {

        Nodo anterior = null;
        Nodo actual = cabeza;

        while (actual != null) {

            Nodo siguiente = actual.siguiente;

            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // Detectar ciclo
    public boolean tieneCiclo() {

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

    // =========================
    // FUSIONAR LISTAS
    // =========================

    public static ListaSimple fusionar(ListaSimple lista1, ListaSimple lista2) {

        ListaSimple fusionada = new ListaSimple();

        Nodo a = lista1.cabeza;
        Nodo b = lista2.cabeza;

        while (a != null && b != null) {

            if (a.dato < b.dato) {

                fusionada.agregar(a.dato);
                a = a.siguiente;

            } else {

                fusionada.agregar(b.dato);
                b = b.siguiente;
            }
        }

        while (a != null) {

            fusionada.agregar(a.dato);
            a = a.siguiente;
        }

        while (b != null) {

            fusionada.agregar(b.dato);
            b = b.siguiente;
        }

        return fusionada;
    }
}