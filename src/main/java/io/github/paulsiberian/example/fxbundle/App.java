/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.example.fxbundle;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {

    private static Property<Locale> locale;
    private static Scene scene;

    private static Parent loadFXML(String fxml) throws IOException {
        var bundle = ResourceBundle.getBundle(App.class.getPackageName() + '.' + fxml, getLocale());
        var fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"), bundle);
        return fxmlLoader.load();
    }

    public final static Locale RU = new Locale("ru");
    public final static Locale EN = new Locale("en");

    @Override
    public void start(Stage stage) throws IOException {
        locale = new SimpleObjectProperty<>(RU);
        scene = new Scene(loadFXML("primary"));
        stage.setMinWidth(scene.getRoot().minWidth(0));
        stage.setMinHeight(scene.getRoot().minHeight(0));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }

    public static Locale getLocale() {
        return locale.getValue();
    }

    public static Property<Locale> localeProperty() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        App.locale.setValue(locale);
    }
}