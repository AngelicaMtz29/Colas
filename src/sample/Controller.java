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
    TextField valorTxt;
    @FXML
    HBox ColaHbx;

   
    Cola cola = new Cola();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


       

    }

}
