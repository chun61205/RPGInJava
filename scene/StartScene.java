package scene;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class StartScene {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void newGameButton(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("NamingScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void exitButtom(ActionEvent event) throws IOException
    {
        Platform.exit();
    }
}
