package com.example.rubrow;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private WebView webView;
    private WebEngine engine;
    private WebHistory history;

    @FXML
    private TextField textField;

    @FXML
    public Button buttonGo;
    @FXML
    public Button buttonReload;
    @FXML
    public Button buttonBack;
    @FXML
    public Button buttonNext;
    @FXML
    public Button buttonHistory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = webView.getEngine();
        String homePage = "www.google.com";
        textField.setText(homePage);
        loadPage();
    }

    public void loadPage() {
        engine.load("https://" + textField.getText());
    }

    public void reloadPage() {
        engine.reload();
    }

    public void zoomIn() {}

    public void zoomOut() {}

    public void displayHistory() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for(WebHistory.Entry entry: entries) {
            System.out.println(entry);
        }
    }

    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
    public void next() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }
}