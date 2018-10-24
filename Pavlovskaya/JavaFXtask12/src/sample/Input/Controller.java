package sample.Input;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    public void isChange() {
        Radius.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = Radius.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9' )) {
                        // if it's not number then just setText to previous one
                        Radius.setText(Radius.getText().substring(0,Radius.getText().length()-1));
                    }
                }
            }
        });

        Height.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = Height.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9' )) {
                        // if it's not number then just setText to previous one
                        Height.setText(Height.getText().substring(0,Height.getText().length()-1));
                    }
                }
            }
        });

        Density.lengthProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = Density.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9' )) {
                        // if it's not number then just setText to previous one
                        Density.setText(Density.getText().substring(0,Density.getText().length()-1));
                    }
                }
            }
        });
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
        else if (Mass.isSelected()) {
            sample.Work.Controller.isMass = true;
            sample.Work.Controller.isVolume = false;
        }
    }
}
