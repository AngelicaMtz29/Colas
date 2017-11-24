package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    Button InsertarBtn, BuscarBtn, EliminarBtn, VaciarBtn ;
    @FXML
    TextField valorTxt;
    @FXML
    HBox colasHbx;

    @FXML
    Label sizeLbl;


    Cola cola = new Cola();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.InsertarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                cola.insertar(Integer.parseInt(valorTxt.getText()));
                cola.mostrar();
                sizeLbl.setText(String.valueOf(cola.getsize()));

                HBox hBox = new HBox(8);
                hBox.setMaxHeight(40);
                hBox.setMaxWidth(40);
                hBox.setAlignment(Pos.CENTER);
                hBox.setStyle("-fx-background-color: #FDD835;");

                Label labell = new Label (valorTxt.getText());
                //labell.setPrefSize(20,20);
                

                Separator separador = new Separator();
                separador.setOrientation(Orientation.VERTICAL);
                separador.setMaxHeight(20);
                separador.setStyle("-fx-background-color: #8499FF");


                hBox.getChildren().add(labell);
                hBox.getChildren().add(separador);

                colasHbx.getChildren().add(hBox);




                valorTxt.clear();
            }
        });

        this.BuscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cola.buscar(Integer.parseInt(valorTxt.getText()));
            }
        });
         this.VaciarBtn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 cola.vaciar();
                 cola.mostrar();
                 colasHbx.getChildren().clear();
                 sizeLbl.setText("");
             }
         });

        this.EliminarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cola.extraer();
                colasHbx.getChildren().remove(0);
                sizeLbl.setText(cola.getsize()+"");
            }
        });

    }

}
