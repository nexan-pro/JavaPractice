package sample.Work;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    public static String m_radius, m_height, m_density;
    public static boolean isVolume, isMass;
    @FXML
    private Label volumeLabel, massLabel;

    public void getSolution(ActionEvent e) {
        double volume = (double)1 / 3 * Math.PI * Math.pow(Double.parseDouble(m_radius), 2) * Double.parseDouble(m_height);
        double mass = volume * Double.parseDouble(m_density);
        if (isVolume && isMass) {
            volumeLabel.setText(Double.toString(volume));
            massLabel.setText(Double.toString(mass));
        }
        else if (isVolume)
            volumeLabel.setText(Double.toString(volume));
        else if (isMass)
            massLabel.setText(Double.toString(mass));
    }

    public void switchMenuScene(ActionEvent e) throws Exception {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/Menu/sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add("/sample/Menu/style.css");
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
