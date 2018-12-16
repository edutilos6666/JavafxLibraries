package com.edutilos.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import lombok.Data;

/**
 * Created by edutilos on 14.12.18.
 */
@Data
public class Worker extends RecursiveTreeObject<Worker> {
    private ObjectProperty<Integer> id = new SimpleObjectProperty<>();
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Integer> age = new SimpleObjectProperty<>();
    private ObjectProperty<Double> wage = new SimpleObjectProperty<>();
    private ObjectProperty<Boolean> active = new SimpleObjectProperty<>();

    public Worker(int id, String name, int age, double wage, boolean active) {
        this.id.set(id);
        this.name.set(name);
        this.age.set(age);
        this.wage.set(wage);
        this.active.set(active);
    }

    public Worker(String name, int age, double wage, boolean active) {
        this.name.set(name);
        this.age.set(age);
        this.wage.set(wage);
        this.active.set(active);
    }

    public Worker() {
    }
}
