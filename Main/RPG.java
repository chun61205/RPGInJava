package Main;

import javafx.stage.Stage;
import player.NovicePlayer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RPG extends Application{
    public static NovicePlayer player;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("../scene/StartScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

