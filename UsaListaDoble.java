
/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UsaListaDoble {
    public static void main(String[] args) {

        ListaDoble lista = new ListaDoble();
        
        // Insertar nodos
        lista.insertaPrimerNodo("R");
        lista.imprimir();

        lista.insertaPrimerNodo("F");
        lista.imprimir();

        lista.insertaAntesPrimerNodo("H");
        lista.insertaAlFinal("Z");
        System.out.println(lista);

        // Insertar nodo entre nodos
        lista.insertaEntreNodos("T", "R");
        System.out.println(lista);

        // Insertar nodo antes del primer nodo
        lista.insertaAntesPrimerNodo("K");
        System.out.println(lista);

        // Insertar nodo al final
        lista.insertaAlFinal("Ñ");
        System.out.println(lista);

        // Borrar primer nodo
        lista.borrarPrimerNodo();
        System.out.println(lista);

        // Borrar último nodo
        lista.borrarUltimoNodo();
        System.out.println(lista);

        // Borrar nodo específico
        lista.borrarCualquierNodo("H");
        System.out.println(lista);

        // Buscar nodo
        Node nodoBuscado = lista.buscarNodo("Z");
        System.out.println("Nodo encontrado: " + (nodoBuscado != null ? nodoBuscado.name : "No encontrado"));

        // Insertar nodo después de un nodo buscado
        lista.insertarDespuesDeNodo("N", "Z");
        System.out.println(lista);

        // Intercambiar nodos ya creados
        lista.intercambiarNodosExistentes("T", "N");
        System.out.println(lista);

        // Sustituir un nodo por uno nuevo
        lista.sustituirNodo("N", "F");
        System.out.println(lista);
    }
}
