package sample;

import javafx.scene.Node;

public class Nodo  {
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
    public void setValor(int valor) {
        this.valor=valor;
    }
    public void setProx(Nodo siguiente) {
        this.proximo=siguiente;
    }
    public int getValor() {
        return this.valor;
    }
    public Nodo getProximo() {
        return this.proximo;
    }
}
