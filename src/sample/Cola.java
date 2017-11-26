package sample;
import javafx.scene.control.Alert;


public class Cola {

    private Nodo frente=null;
    public int size=0;

    //constructor simple
    public Cola() {

        this.frente=null;
    }
	/*Método para insertar:
	 * Inserta el valor como frente si es que la cola esta vacía
	  sino lo añade detrás del primero.
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
        size++;
    }
    /*Método para mostrar los elementos de la cola
    primero comprueba si hay elementos, cuando los hay
    recorre cada uno situandolo como el primero y asi sucesivamente.
    Si no encuentra elementos muestra el mensaje.
     */
    public  void mostrar(){
        if(frente!=null){
            Nodo temp=frente;
            while (temp!=null){
                temp=temp.getProximo();
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AVISO");
            alert.setHeaderText("La cola se encuentra vacía");
            alert.show();

        }
    }
    /*Método para extraer
    Verifica que la cola no se encuentre vacía, comparando el valor del
    primer elemento si este es diferente de null tomara el primer valor
    y posicionará al frente al que anteriormente era el segundo valor.
    Además de disminuir el tamaño de la cola, obviamente, y devolver el
    valor que se extrae.
     */

    public  int extraer() {
        if(frente ==null) {
            return 0;
        }else {
            int valorExtraer=frente.getValor();
            frente=frente.getProximo();
            size--;
            return valorExtraer;
        }
    }
    //Método que obtiene el tamaño de la cola.
    public int getsize(){
        return size;
    }
    /*Método de buscar:
    El valor a buscar se obtiene de lo que ingrese el usuario por
    medio de la interfaz. Primero si el valor que se busca es del
    frente se envia un mensaje de la posición. De lo contrario
    recorre cada uno de los elementos hasta encontrar el valor buscado,
    en cada búsqueda que sea falsa, se suma uno a la variabl posicion
    y se obtiene el siguiente elemento el cual pasará a ser temporal.
    En caso de no encontrar el valor buscado se emite un mensaje
    que describe el caso.
     */
    public void buscar(int busqueda) {

        try {
            /*
            Declaración del nodo temporal con el valor
            del primero o frente
             */
            Nodo temp = frente;
            /*La variable posición se utiliza en caso de que el valor
            que se busca no se encuentre en el frente. Inicializa en 1
            por que la posición 0 se devuelve con la primer condición.
             */
            int posicion = 1;


            if (temp.getValor() == busqueda) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje");
                alert.setHeaderText("Encontrado");
                alert.setContentText("Valor en la posición: 0");
                alert.showAndWait();
            } else {
                while (temp != null) {
                    if (temp.getProximo().getValor() == busqueda) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Mensaje");
                        alert.setHeaderText("Encontrado");
                        alert.setContentText("Valor en la posición: " + posicion);
                        alert.showAndWait();
                        break;
                    }
                    posicion++;
                    temp = temp.getProximo();
                }}
        }
        catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje");
            alert.setHeaderText("Error");
            alert.setContentText("El elemento no ha sido encontrado");
            alert.showAndWait();
        }
    }

    /*Método de vaciar la cola.
    En el método extraer se verifica que la cola no se
    encuentre vacía comprobando que exista un primer valor
    por lo tanto que no tenga un valor null, que no
    se halle nada.
    En este método al darle un valor vacío al frente
    este perjudica a los demás elementos, dejando la
    cola vacía. Lo que también devuelve un tamaño de
    la misma igual a 0.
     */
    public void vaciar(){

        frente = null;
        size=0;
    }
}
