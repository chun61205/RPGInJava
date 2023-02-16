package scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import moveMent.MapMovement;
import player.NovicePlayer;
import javafx.scene.Node;

import Main.RPG;

public class NamingScene {

    @FXML
    private TextField namingTextField;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void submitNamingBotton(ActionEvent event) throws IOException
    {
    	/*
    	//RPG.player = new NovicePlayer(namingTextField.getText(), 1);
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MapScene.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    	*/
        
        try{
            RPG.player = new NovicePlayer(namingTextField.getText(), 1);
            try{
            	MapMovement.ReSetMap();
                root = FXMLLoader.load(getClass().getResource("MapScene.fxml"));
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    /*
    @FXML
    public void submitNamingBotton(ActionEvent event) throws IOException
    {
        try{
            RPG.player = new NovicePlayer(namingTextField.getText());
            try{
                root = FXMLLoader.load(getClass().getResource("/scenes/BattleScene.fxml"));
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/
}
