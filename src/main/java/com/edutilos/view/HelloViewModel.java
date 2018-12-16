package com.edutilos.view;

import com.edutilos.service.GreetingService;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloViewModel implements ViewModel {
    private StringProperty name = new SimpleStringProperty();

    private ReadOnlyStringWrapper message = new ReadOnlyStringWrapper();

    @Autowired
    private GreetingService greetingService;

    public void initialize() {
        name.addListener((observable, oldValue, newValue) -> {
            if(newValue == null ||newValue.trim().isEmpty()) {
                message.set("");
            }else {
                message.set(greetingService.greet(newValue));
            }
        });
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ReadOnlyStringProperty messageProperty() {
        return message.getReadOnlyProperty();
    }
}