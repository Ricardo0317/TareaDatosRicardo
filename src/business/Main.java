package business;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/presentation/GUICourse.fxml"));            
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setTitle("Gestión de Cursos");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}