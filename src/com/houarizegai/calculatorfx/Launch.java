
package com.houarizegai.calculatorfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application {
    
    public static Stage stage;
    
    @Override
    public void start(Stage stage) {
        
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/com/houarizegai/calculatorfx/Calc.fxml"));
            
        } catch(IOException ioe) {
            System.out.println("Error msg: " + ioe.getMessage());
        }
        
        Scene scene = new Scene(root);
        
        stage.setTitle("CalculatorFx");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);

        Launch.stage = stage;
        stage.show();
    }
    
}
