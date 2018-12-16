package com.edutilos.main;

import com.edutilos.util.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;
import org.tbee.javafx.scene.layout.MigPane;

/**
 * Created by edutilos on 12.12.18.
 */
public class BootstrapExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        addComponents();
        registerEvents();
        primaryStage.setScene(scene);
        primaryStage.setTitle("BootstrapFX Example");
        primaryStage.show();
    }

    private Scene scene;
    private Panel panel;
    private MigPane root;
    private Label lblTitle, lblId, lblName, lblAge, lblWage, lblActive;
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private Button btnOk, btnClear, btnCancel;


    private void addComponents() {
        root = new MigPane(
                "",
                "[]100[]100[]",
                "");
        lblTitle = new Label("Sample Form");
        lblId = new Label("Id: ");
        lblName = new Label("Name: ");
        lblAge = new Label("Age: ");
        lblWage = new Label("Wage: ");
        lblActive = new Label("Active: ");
        fieldId = new TextField();
        fieldName = new TextField();
        fieldAge = new TextField();
        fieldWage = new TextField();
        fieldActive = new TextField();
        btnOk = new Button("OK");
        btnClear = new Button("Clear");
        btnCancel = new Button("Cancel");
        root.add(lblTitle, "span");
        root.add(lblId);
        root.add(fieldId, "span");
        root.add(lblName);
        root.add(fieldName, "span");
        root.add(lblAge);
        root.add(fieldAge, "span");
        root.add(lblWage);
        root.add(fieldWage, "span");
        root.add(lblActive);
        root.add(fieldActive, "span");
        root.add(btnOk);
        root.add(btnClear);
        root.add(btnCancel, "wrap");
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

        panel = new Panel("Example 1");
        panel.getStyleClass().add("panel-primary");
        panel.setBody(root);
        scene = new Scene(panel, 500, 500);
        scene.getStylesheets().add(Constants.BOOTSTRAPFX_CSS);
    }

    private void registerEvents() {

    }
}
