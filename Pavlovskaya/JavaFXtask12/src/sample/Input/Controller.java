package sample.Input;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField Radius, Height, Density;
    @FXML
    private CheckBox Volume, Mass;
    public void switchMenuScene(ActionEvent e) throws Exception {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/Menu/sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        tableViewScene.getStylesheets().add("/sample/Menu/style.css");
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void save(ActionEvent e) {
        sample.Work.Controller.m_radius = Radius.getText();
        sample.Work.Controller.m_height = Height.getText();
        sample.Work.Controller.m_density = Density.getText();
        if (Volume.isSelected() && Mass.isSelected()) {
            sample.Work.Controller.isMass = true;
            sample.Work.Controller.isVolume = true;
        } else if (Volume.isSelected()) {
            sample.Work.Controller.isVolume = true;
            sample.Work.Controller.isMass = false;
        }
        else {
            sample.Work.Controller.isMass = true;
            sample.Work.Controller.isVolume = false;
        }

    }
}
