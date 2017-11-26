package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import javax.swing.tree.AbstractLayoutCache;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Se asigna el id a los controles de la interfaz.
    @FXML
    Button InsertarBtn, BuscarBtn, EliminarBtn, VaciarBtn;
    @FXML
    TextField valorTxt;
    @FXML
    HBox colasHbx;
    @FXML
    Label sizeLbl;

    //Se crea un objeto cola donde se almacenan los elementos.
    Cola cola = new Cola();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Evento clic del botón insertar
        this.InsertarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    cola.insertar(Integer.parseInt(valorTxt.getText()));
                    cola.mostrar();
                    sizeLbl.setText(String.valueOf(cola.getsize()));
                    //Creación de un hBox y asignación de caracteristicas: tamaño, alineación y estilo.
                    HBox hBox = new HBox(10);
                    hBox.setMaxHeight(50);
                    hBox.setAlignment(Pos.CENTER);
                    hBox.setStyle("-fx-background-color: #009688;");
                    /*Creación de un Label y asignación de caracteristicas: valor del mismo,
                    alineación, tamaño del control, color del contenido y su tamaño.*/
                    Label labell = new Label(valorTxt.getText());
                    labell.setAlignment(Pos.CENTER);
                    labell.setPrefSize(50,50);
                    labell.setTextFill(Paint.valueOf("#f5f5f5"));
                    labell.setFont(Font.font(20.0));
                    //Se añade el control label dentro del Hbox creado
                    hBox.getChildren().add(labell);
                    //Se añaden al contenedor padre.
                    colasHbx.getChildren().add(hBox);
                    /*Cuando se inserte un valor, se limpia el control Textfield.*/
                    valorTxt.clear();
                }catch (Exception e){
                    /*La cola sólo se compone de elementos numéricos  (sólo enteros)si el usuario ingresa
                    un valor de algún tipo de dato diferente se muestra un mensaje que solicitará
                    el ingreso de valores numéricos enteros.*/
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso");
                    alert.setHeaderText("Valor no válido");
                    alert.setContentText("Por favor ingrese un valor numérico ( sólo enteros)");
                    alert.showAndWait();
                }
            }
        });
        //Evento clic del botón buscar
        this.BuscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                        /*
                        Se invoca al método buscar, asignado el valor
                        que se ingresa en el Textfield como el
                        valor a buscar. Pero como se obtiene un valor tipo
                        string se convierte a entero, siendo el tipo de
                        dato que requiere el método empleado.
                         */
                        cola.buscar(Integer.parseInt(valorTxt.getText()));

                }catch (Exception e){
                    /*
                    En caso de no ingresar un valor no válido se envía
                    un mensaje de alerta, solicitando ingresar un valor válido.
                     */
                    Alert alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("AVISO");
                    alert.setHeaderText("Valor no válido");
                    alert.setContentText("Ingrese un valor numérico");
                    alert.showAndWait();
                }

            }
        });
        //Evento clic del botón vaciar
        this.VaciarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Se invoca al método vaciar, mostrar y se implementa al objeto cola.
                cola.vaciar();
                cola.mostrar();
                //Se eliminan los objetos dentro del contenedor de la cola.
                colasHbx.getChildren().clear();
                //El tamaño se reinicia.
                sizeLbl.setText("");
            }
        });
        //Evento clic del botón eliminar
        this.EliminarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Se implementa el evento extraer de la clase Cola
                cola.extraer();
                /*Siendo el primer elemento el que sólo se
                elimina de la cola se quita del contenedor
                principal el que se encuentra en la pocisión 0.
                 */
                colasHbx.getChildren().remove(0);
                /*
                Se envía el valor del método que obtiene el tamaño,
                al controlador label.
                 */
                sizeLbl.setText(cola.getsize() + "");
            }
        });


    }


}




