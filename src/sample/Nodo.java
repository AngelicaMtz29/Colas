package sample;

import javafx.scene.Node;

public class Nodo  {
    //Variable que almacena el valor del elemento
    private int valor;
    private Nodo proximo; //puntero hacia el nodo siguiente

    //constructor simple, inicializa sin valor
    public Nodo() {
        this.valor=0;
        this.proximo=null;
    }
    //constructor
    public Nodo(int valor) {
        this.valor=valor;
        this.proximo=null;
    }
    //Método que asigna el valor al elemento de la cola.
    public void setValor(int valor) {
        this.valor=valor;
    }
    //Método que asigna valor al siguiente elemento.
    public void setProx(Nodo siguiente) {
        this.proximo=siguiente;
    }
    //Método que devuelve el valor del elemento
    public int getValor() {
        return this.valor;
    }
    //Método que devuelve el valor del elemento siguiente.
    public Nodo getProximo() {
        return this.proximo;
    }
}
