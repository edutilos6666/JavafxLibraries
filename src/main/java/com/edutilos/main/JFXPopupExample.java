package com.edutilos.main;

import com.edutilos.model.Worker;
import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler.RipplerMask;
import com.jfoenix.controls.JFXRippler.RipplerPos;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.svg.SVGGlyph;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Function;

public class JFXPopupExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        JFXHamburger show = new JFXHamburger();
        show.setPadding(new Insets(20, 20, 20, 20));
        JFXRippler rippler = new JFXRippler(show, RipplerMask.CIRCLE, RipplerPos.BACK);

        JFXListView<Label> list = new JFXListView<>();
        for (int i = 1; i < 5; i++) {
            list.getItems().add(new Label("Item " + i));
        }

        AnchorPane container = new AnchorPane();
        container.getChildren().add(rippler);
        AnchorPane.setLeftAnchor(rippler, 200.0);
        AnchorPane.setTopAnchor(rippler, 210.0);

        VBox main = new VBox();
        main.getChildren().addAll(container, generateTVWorker());

        JFXPopup popup = new JFXPopup(list);
        rippler.setOnMouseClicked(e -> popup.show(rippler, PopupVPosition.TOP, PopupHPosition.LEFT));

//        scene.getStylesheets().add(JFXPopupExample.class.getResource("/css/jfoenix-components.css").toExternalForm());


        JFXDecorator decorator = new JFXDecorator(primaryStage, main);
        decorator.setCustomMaximize(true);
        decorator.setGraphic(new SVGGlyph(""));
        final Scene scene = new Scene(decorator, 800, 800);

        primaryStage.setTitle("JFoenix Demo");
//        primaryStage.setTitle("JFX Popup Demo");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    private JFXTreeTableView<Worker> generateTVWorker() {
        JFXTreeTableView<Worker> tvWorkers = new JFXTreeTableView<>();
        //add columns
        JFXTreeTableColumn<Worker, Integer> colId = new JFXTreeTableColumn<>("Id");
//        setupCellValueFactory(colId, Worker::getId);
        JFXTreeTableColumn<Worker, String> colName = new JFXTreeTableColumn<>("Name");
//        setupCellValueFactory(colName, Worker::getName);
        JFXTreeTableColumn<Worker, Integer> colAge = new JFXTreeTableColumn<>("Age");
//        setupCellValueFactory(colAge, Worker::getAge);
        JFXTreeTableColumn<Worker, Double> colWage = new JFXTreeTableColumn<>("Wage");
//        setupCellValueFactory(colWage, Worker::getWage);
        JFXTreeTableColumn<Worker, Boolean> colActive = new JFXTreeTableColumn<>("Active");
//        setupCellValueFactory(colActive, Worker::getActive);
        tvWorkers.getColumns().addAll(colId, colName, colAge, colWage, colActive);
        addDummyWorkersToTreeTableView(tvWorkers);
        return tvWorkers;
    }

    private <T> void setupCellValueFactory(JFXTreeTableColumn<Worker,T> col, Function<Worker, ObservableValue<T>> mapper)  {
        col.setCellValueFactory((TreeTableColumn.CellDataFeatures<Worker,T> param)-> {
            if(col.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return col.getComputedValue(param);
            }
        });
    }

    private void addDummyWorkersToTreeTableView(JFXTreeTableView<Worker> tvWorkers) {
        ObservableList<Worker> dummyWorkers = FXCollections.observableArrayList(
          new Worker(1, "foo", 10, 100.0, true),
                new Worker(2, "bar", 20, 200.0, false),
                new Worker(3, "bim", 30, 300.0, true),
                new Worker(4, "pako", 40, 400.0, false)
        );
        tvWorkers.setRoot(new RecursiveTreeItem<Worker>(dummyWorkers, RecursiveTreeObject::getChildren));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
