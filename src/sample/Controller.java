package sample;

import com.sun.javafx.scene.layout.region.Margins;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    Button InsertarBtn, BuscarBtn, EliminarBtn, VaciarBtn,TamañoBtn ;
    @FXML
    TextField ValorTxt;
    @FXML
    HBox ColaHbx;

   
    Cola cola = new Cola();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

      
            this.InsertarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cola.insertar(Integer.parseInt(valorTxt.getText()));
                cola.mostrar();
                Separator separator = new Separator();
                HBox hBox = new HBox();
                Label labell = new Label (valorTxt.getText());
                Separator separador = new Separator();

                hBox.getChildren().add(labell);
                hBox.getChildren().add(separador);
                colasHbx.getChildren().add(hBox);

                separador.setOpacity(0);
                separador.setMaxWidth(60);
                separator.setOpacity(0);
                separador.setMaxWidth(30);

                Color seletedColor = colorPicker.getValue();
                hBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(seletedColor.toString()), CornerRadii.EMPTY, Insets.EMPTY)));

            }
        });

        this.BuscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cola.buscar(Integer.parseInt(valorTxt.getText()));
            }
        });


       

    }

}
