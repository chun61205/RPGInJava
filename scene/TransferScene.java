package scene;

import java.io.IOException;

import Main.RPG;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import player.*;

public class TransferScene {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void KnightAction(ActionEvent event) throws IOException{
        RPG.player = new KnightPlayer(RPG.player.getName(), RPG.player.getLevel(), RPG.player.getX_Location(), RPG.player.getY_Location(), RPG.player.getMapLocation());
        try {
            root = FXMLLoader.load(getClass().getResource("MapScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void MagicialAction(ActionEvent event) {
        RPG.player = new MagicianPlayer(RPG.player.getName(), RPG.player.getLevel(), RPG.player.getX_Location(), RPG.player.getY_Location(), RPG.player.getMapLocation());
        try {
            root = FXMLLoader.load(getClass().getResource("MapScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void ShieldAction(ActionEvent event) {
        RPG.player = new ShieldPlayer(RPG.player.getName(), RPG.player.getLevel(), RPG.player.getX_Location(), RPG.player.getY_Location(), RPG.player.getMapLocation());
        try {
            root = FXMLLoader.load(getClass().getResource("MapScene.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
