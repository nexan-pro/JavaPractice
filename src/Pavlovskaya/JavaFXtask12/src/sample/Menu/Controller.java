package sample.Menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    @FXML
    private void exit(ActionEvent e){
        Platform.exit();
    }
    public void switchInputScene(ActionEvent e) throws IOException {
        Parent inputViewParent = FXMLLoader.load(getClass().getResource("/sample/Input/sample.fxml"));
        Scene inputViewScene = new Scene(inputViewParent);
        inputViewScene.getStylesheets().add("/sample/Input/style.css");
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(inputViewScene);
        window.show();
    }

    public void switchWorkScene(ActionEvent e) throws IOException {
        Parent workViewParent = FXMLLoader.load(getClass().getResource("/sample/Work/sample.fxml"));
        Scene workViewScene = new Scene(workViewParent);
        workViewScene.getStylesheets().add("/sample/Work/style.css");
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(workViewScene);
        window.show();
    }
}

/**
 * Formula for volume V = 1/3 * Math.PI * r^2 * H
 * Formula for mass m = V * p(density)
 */