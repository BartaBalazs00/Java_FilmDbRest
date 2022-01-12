package hu.petrik.filmdb;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Controller {

    //hozzaad controllerből áthelyezve
    protected void alert(String uzenet) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setContentText(uzenet);
        alert.getButtonTypes().add(ButtonType.OK);
        alert.show();
    }

    //main controllerből áthelyezve
    protected void hibaKiir(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(e.getClass().toString());
        alert.setContentText(e.getMessage());
        Timer alertTimer = new Timer();
        alertTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> alert.show());
            }
        }, 500);
    }
}
