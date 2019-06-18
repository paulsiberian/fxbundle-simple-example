/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.example.fxbundle;

import javafx.fxml.FXML;

import java.io.IOException;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void switchLocale() throws IOException {
        var locale = App.getLocale();
        if (App.EN.equals(locale)) {
            App.setLocale(App.RU);
        } else if (App.RU.equals(locale)) {
            App.setLocale(App.EN);
        }
        App.setRoot("secondary");
    }
}