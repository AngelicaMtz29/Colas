package sample;

import javafx.scene.control.Label;

public class Cola {
    private Nodo frente=null;
    //constructor simple
    public Cola() {

        this.frente=null;
    }
	/*
	 * inserta el valor como frente si es que la cola esta vacía
	  sino lo añade detrás del frente
	 */

    public  void insertar(int valor) {
        Nodo nuevo=new Nodo(valor);
        if(frente==null) {
            frente=nuevo;

        }else {
            Nodo temp=frente;
            while(temp.getProximo()!=null) {
                temp=temp.getProximo();
            }
            temp.setProx(nuevo);
        }
    }
    //Método para mostrar los elementos de la cola
    public  void mostrar(){
        if(frente!=null){
          Nodo temp=frente;
          System.out.println("Los valores de la cola son: ");
          while (temp!=null){
              System.out.println(temp.getValor());
              temp=temp.getProximo();
          }
        }else{
            System.out.println("La cola esta vacía");
        }
    }
    //Método para extraer el elemento del frente
    public  int extraer() {
        if(frente ==null) {
            return 0;
        }else {
            int valorExtraer=frente.getValor();
            frente=frente.getProximo();
            return valorExtraer;
        }
    }

    public void vaciar(){

        frente = null;

    }



}
