
/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDoble {

    private Node topForward;
    private Node topBackward;

    public boolean insertaPrimerNodo(String dato) {
        if (topForward == null) {
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;
            topBackward = topForward;
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        System.out.print("[X]");

        for (Node temp = topForward; temp != null; temp = temp.next) {
            System.out.print(" ← [ " + temp.name + " ] → ");
        }

        System.out.print("[X]\n");
    }

    public String toString() {
        StringBuilder cadAux = new StringBuilder("[X]");

        for (Node temp = topForward; temp != null; temp = temp.next) {
            cadAux.append(" ← [ ").append(temp.name).append(" ] → ");
        }

        cadAux.append("[X]");

        return cadAux.toString();
    }

    public void insertaAntesPrimerNodo(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = topForward;
        topForward.previous = temp;
        topForward = temp;
    }

    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;
        temp.previous = topBackward;
        topBackward.next = temp;
        topBackward = temp;
    }

    public boolean insertaEntreNodos(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = topForward;

        while (temp2 != null && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        if (temp2 != null) {
            temp.next = temp2.next;
            temp2.next = temp;
            temp.previous = temp2;
            temp.next.previous = temp;
            return true;
        } else {
            return false;
        }
    }

    public void borrarPrimerNodo() {
        topForward = topForward.next;
        if (topForward != null) {
            topForward.previous.next = null;
            topForward.previous = null;
        }
    }

    public void borrarUltimoNodo() {
        topBackward = topBackward.previous;
        if (topBackward != null) {
            topBackward.next.previous = null;
            topBackward.next = null;
        }
    }

    public boolean borrarCualquierNodo(String buscado) {
        Node temp = topForward;

        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.previous.previous = null;
                temp.next.previous.next = null;
                temp.next.previous = temp;
            }
            return true;
        } else {
            return false;
        }
    }

    public Node buscarNodo(String buscado) {
        Node temp = topForward;

        while (temp != null && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean insertarDespuesDeNodo(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = topForward;

        while (temp2 != null && !temp2.name.equals(buscado)) {
            temp2 = temp2.next;
        }

        if (temp2 != null) {
            temp.next = temp2.next;
            temp2.next = temp;
            if (temp.next != null) {
                temp.next.previous = temp;
            } else {
                topBackward = temp;
            }
            temp.previous = temp2;
            return true;
        } else {
            return false;
        }
    }

    public boolean intercambiarNodosExistentes(String nombreNodo1, String nombreNodo2) {
        Node nodo1 = buscarNodo(nombreNodo1);
        Node nodo2 = buscarNodo(nombreNodo2);

        if (nodo1 != null && nodo2 != null && nodo1 != nodo2) {
            // Actualizar referencias de nodos vecinos de nodo1
            actualizarReferenciasNodosVecinos(nodo1, nodo2);

            // Actualizar referencias de nodos vecinos de nodo2
            actualizarReferenciasNodosVecinos(nodo2, nodo1);

            // Intercambiar referencias de nodo1 y nodo2
            intercambiarReferenciasNodos(nodo1, nodo2);

            return true;
        } else {
            return false;
        }
    }

    private void actualizarReferenciasNodosVecinos(Node nodo, Node nuevoVecino) {
        if (nodo.previous != null) {
            nodo.previous.next = nuevoVecino;
        } else {
            topForward = nuevoVecino;
        }

        if (nodo.next != null) {
            nodo.next.previous = nuevoVecino;
        } else {
            topBackward = nuevoVecino;
        }
    }

    private void intercambiarReferenciasNodos(Node nodo1, Node nodo2) {
        Node tempPrevious = nodo1.previous;
        Node tempNext = nodo1.next;

        nodo1.previous = nodo2.previous;
        nodo1.next = nodo2.next;

        nodo2.previous = tempPrevious;
        nodo2.next = tempNext;
    }

    public void sustituirNodo(String nodoAntiguo, String nuevoNombre) {
        Node nodoExistente = buscarNodo(nodoAntiguo);

        if (nodoExistente != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNombre;
            actualizarReferenciasNodosVecinos(nodoExistente, nuevoNodo);
            copiarReferenciasNodos(nodoExistente, nuevoNodo);
            nodoExistente = null;
        }
    }

    private void copiarReferenciasNodos(Node nodoExistente, Node nuevoNodo) {
        nuevoNodo.previous = nodoExistente.previous;
        nuevoNodo.next = nodoExistente.next;
    }
}


