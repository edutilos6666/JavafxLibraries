package com.edutilos.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by edutilos on 12.12.18.
 */
public class BootstrapExample2Controller {
    @FXML
    private Label lblTitle, lblId, lblName, lblAge, lblWage, lblActive;
    @FXML
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    @FXML
    private Button btnOk, btnClear, btnCancel;

    @FXML
    public void initialize() {
        lblTitle.getStyleClass().setAll("label", "label-info");
        lblId.getStyleClass().setAll("label", "label-success");
        lblName.getStyleClass().setAll("label", "label-warning");
        lblAge.getStyleClass().setAll("label", "label-danger");
        lblWage.getStyleClass().setAll("label", "label-info");
        lblActive.getStyleClass().setAll("label", "label-success");
        fieldId.getStyleClass().setAll("bg", "bg-success");
        fieldName.getStyleClass().setAll("bg", "bg-warning");
        fieldAge.getStyleClass().setAll("bg", "bg-danger");
        fieldWage.getStyleClass().setAll("bg", "bg-info");
        fieldActive.getStyleClass().setAll("bg", "bg-success");
        btnOk.getStyleClass().setAll("btn", "btn-primary");
        btnClear.getStyleClass().setAll("btn", "btn-success");
        btnCancel.getStyleClass().setAll("btn", "btn-warning");
    }
}
