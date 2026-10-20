package com.mycompany.ejercicio3_1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtContador;

    @FXML
    private Button btnContar;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button btnEsperar;

    private int contadorClics = 0;

    @FXML
    private void initialize() {
        txtContador.setText("0");
        txtContador.setEditable(false);
        progressBar.setProgress(0.0);
    }

    @FXML
    private void manejarContar() {
        contadorClics++;
        txtContador.setText(String.valueOf(contadorClics));
    }

    @FXML
    private void manejarEsperar() {
        btnEsperar.setDisable(true);
        progressBar.setProgress(0.0);

        new Thread(() -> {
            int tiempoTotalMs = 10000; // equivale a 10 segundos
            int pasos = 100;
            int tiempoPasoMs = tiempoTotalMs / pasos;

            for (int i = 1; i <= pasos; i++) {
                try {
                    Thread.sleep(tiempoPasoMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final double progreso = (double) i / pasos;
                Platform.runLater(() -> progressBar.setProgress(progreso));
            }

            Platform.runLater(() -> btnEsperar.setDisable(false));
        }).start();
    }
}