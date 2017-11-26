package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Se obtiene la interfaz para mostrar en la ventana.
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Titulo y tamaño de la ventana  que se muestra.
        primaryStage.setTitle("Proyecto Colas");
        primaryStage.setScene(new Scene(root, 1060, 520));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
