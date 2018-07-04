
package com.houarizegai.calculatorfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalcController implements Initializable {

    @FXML
    private Pane parent;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    @FXML
    private Label lblResult;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
    }    
    
    private void makeStageDrageable() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Launch.stage.setX(event.getScreenX() - xOffset);
                Launch.stage.setY(event.getScreenY() - yOffset);
                Launch.stage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Launch.stage.setOpacity(1.0f);
        });

    }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    /* Start Button Action */
    
    @FXML
    private void btnPoint() {
        if(lblResult.getText().length() < 10) {
            if(!lblResult.getText().contains("."))
                lblResult.setText(lblResult.getText() + ".");
        }
    }
    @FXML
    private void btn0() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "0");
    }
    @FXML
    private void btn1() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "1");
    }
    @FXML
    private void btn2() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "2");
        
    }
    @FXML
    private void btn3() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "3");
        
    }
    @FXML
    private void btn4() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "4");
        
    }
    @FXML
    private void btn5() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "5");
        
    }
    @FXML
    private void btn6() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "6");
        
    }
    @FXML
    private void btn7() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "7");
        
    }
    @FXML
    private void btn8() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "8");
        
    }
    @FXML
    private void btn9() {
        if(lblResult.getText().length() < 10)
            lblResult.setText(lblResult.getText() + "9");
        
    }
    
    @FXML
    private void btnDiv() {
        
    }
    @FXML
    private void btnMul() {
        
    }
    @FXML
    private void btnSub() {
        
    }
    @FXML
    private void btnAdd() {
        
    }
    @FXML
    private void btnEqual() {
        
    }
    
    @FXML
    private void btnAC() {
        lblResult.setText("0");
    }
    @FXML
    private void btnPositive() {
        if(lblResult.getText().charAt(0) != '-')
            lblResult.setText("-" + lblResult.getText());
    }
    @FXML
    private void btnMod() {
        
    }
    
    /* End Button Action */
    
}
