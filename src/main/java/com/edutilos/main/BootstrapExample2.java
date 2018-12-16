package com.edutilos.main;

import com.edutilos.util.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;
import org.tbee.javafx.scene.layout.MigPane;

import java.io.IOException;

/**
 * Created by edutilos on 12.12.18.
 */
public class BootstrapExample2 extends Application {
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
    private AnchorPane root;
    private Label lblTitle, lblId, lblName, lblAge, lblWage, lblActive;
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private Button btnOk, btnClear, btnCancel;


    private void addComponents() {
        try {
            root = FXMLLoader.load(getClass().getResource("/com/edutilos/bootstrap-example-2.fxml"));
            panel = new Panel("Example 1");
            panel.getStyleClass().add("panel-primary");
            panel.setBody(root);
            scene = new Scene(panel, 500, 500);
            scene.getStylesheets().add(Constants.BOOTSTRAPFX_CSS);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void registerEvents() {

    }
}
