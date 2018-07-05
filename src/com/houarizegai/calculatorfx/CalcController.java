package com.houarizegai.calculatorfx;

import com.houarizegai.calculatorfx.calculatorengine.CalculatorEngine;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
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
    private Label lblExpression, lblHistoryExpression;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDrageable();
    }

    private void makeStageDrageable() {
        parent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });

        parent.setOnMouseDragged(e -> {
            Launch.stage.setX(e.getScreenX() - xOffset);
            Launch.stage.setY(e.getScreenY() - yOffset);
            Launch.stage.setOpacity(0.7f);
        });

        parent.setOnDragDone(e -> {
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
    private void numberClicked(ActionEvent e) {
        String number = ((JFXButton) e.getSource()).getText();

        if (lblExpression.getText().length() == 1 && lblExpression.getText().equals("0")) {
            lblExpression.setText(number);
            return;
        }

        if (lblExpression.getText().length() < 10) {
            lblExpression.setText(lblExpression.getText() + number);
        }
    }

    @FXML
    private void btnPoint() {
        if (lblExpression.getText().length() < 9) {
            String lastTxt = ""; // This string contains last txt after operator
            for(int i = lblExpression.getText().length() - 1; i >= 0; i--) {
                if("+-*/".contains(lblExpression.getText().substring(i, i + 1))) {
                    break;
                } else {
                   lastTxt = lblExpression.getText().substring(i, i + 1) + lastTxt;
                }
            }
            
            if(lastTxt.length() == 0)
                lblExpression.setText(lblExpression.getText() + "0.");
            else if(!lastTxt.contains("."))
                lblExpression.setText(lblExpression.getText() + ".");
            
        }
    }

    @FXML
    private void operationClicked(ActionEvent e) {
        if (lblExpression.getText().length() < 9) {
            
            String opt = ((JFXButton) e.getSource()).getText();
            if (lblExpression.getText().matches(".*[0-9]")) {
                lblExpression.setText(lblExpression.getText() + opt);
            }
        }

    }

    @FXML
    private void btnEqual() {
        lblHistoryExpression.setText(lblExpression.getText() + " =");
        lblExpression.setText(CalculatorEngine.getCalc(lblExpression.getText()));
    }

    @FXML
    private void btnAC() {
        lblExpression.setText("0");
        lblHistoryExpression.setText("");
    }

    @FXML
    private void btnBack() {
        if (lblExpression.getText().length() == 1) {
            lblExpression.setText("0");
        } else {
            lblExpression.setText(lblExpression.getText().substring(0, lblExpression.getText().length() - 1));
        }
    }

    /* End Button Action */
}
