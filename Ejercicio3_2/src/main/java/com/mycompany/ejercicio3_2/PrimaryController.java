package com.mycompany.ejercicio3_2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML
    private Button btnIniciar;
    @FXML
    private ProgressBar prgLiebre;
    @FXML
    private Label lblLiebre;
    @FXML
    private ProgressBar prgTortuga;
    @FXML
    private Label lblTortuga;

    @FXML
    private void btnIniciar_click() {
        prgLiebre.setProgress(0.0);
        prgTortuga.setProgress(0.0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 50; i++) {
                        final double pos = i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                prgLiebre.setProgress(pos);
                                lblLiebre.setText("La Liebre: ¡Está corriendo!");
                            }
                        });
                        Thread.sleep(40);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblLiebre.setText("La Liebre: ¡Se durmió!");
                        }
                    });
                    Thread.sleep(4500);

                    for (int i = 51; i <= 100; i++) {
                        final double pos = i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                prgLiebre.setProgress(pos);
                                lblLiebre.setText("La Liebre: ¡Despertó!");
                            }
                        });
                        Thread.sleep(60);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblLiebre.setText("La Liebre: Llegó a la meta");
                        }
                    });
                } catch (InterruptedException ex) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 100; i++) {
                        final double pos = i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                prgTortuga.setProgress(pos);
                                lblTortuga.setText("La Tortuga: ¡Está corriendo!");
                            }
                        });
                        Thread.sleep(80);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblTortuga.setText("La Tortuga: ¡Ganó!");
                        }
                    });
                } catch (InterruptedException ex) {
                }
            }
        });

        t1.start();
        t2.start();
    }
}