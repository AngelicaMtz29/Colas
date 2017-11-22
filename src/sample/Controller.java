package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
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
                hBox.setPrefSize(20,20);
                Label labell = new Label (valorTxt.getText());
                Separator separador = new Separator();
                separador.setOrientation(Orientation.VERTICAL);
                hBox.getChildren().add(labell);
                hBox.getChildren().add(separador);
                hBox.setAlignment(Pos.CENTER);
                hBox.setStyle("-fx-background-color: #4FC3F7;");
                colasHbx.getChildren().add(hBox);

                separador.setOpacity(0);
                separador.setMaxWidth(60);

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
                 sizeLbl.setText(cola.getsize()+"");
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
