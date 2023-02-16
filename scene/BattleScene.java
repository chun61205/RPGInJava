package scene;

import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import transition.ProgressBarTransition;

import Main.RPG;

import battle.*;

public class BattleScene implements Initializable {

    @FXML
    private ImageView playerBattleImageView;
    @FXML
    private ImageView monsterBattleImageView1;
    @FXML
    private ImageView monsterBattleImageView2;

    @FXML
    private Label playerBattleName;
    @FXML
    private Label monsterBattleName1;
    @FXML
    private Label monsterBattleName2;

    @FXML
    private Label playerLevelLabel;

    @FXML
    private Label dialogue;

    @FXML
    private Button attackButton;
    @FXML
    private Button magicButton;
    @FXML
    private Button itemButton;
    @FXML 
    private Button retrieveButton;
    @FXML
    private Button monsterButton1;
    @FXML
    private Button monsterButton2;
    @FXML
    private Button returnButton;

    @FXML
    private ProgressBar playerHPBar;
    @FXML
    private ProgressBar playerMPBar;
    @FXML
    private ProgressBar monsterHPBar1;
    @FXML
    private ProgressBar monsterHPBar2;

    @FXML
    private Label hpLabel;
    @FXML
    private Label mpLabel;
    @FXML
    private Label hpValueLabel;
    @FXML
    private Label mpValueLabel;
    @FXML
    private Label strLabel;
    @FXML
    private Label intLabel;
    @FXML
    private Label defLabel;
    @FXML
    private Label dexLabel;

    @FXML
    private Label winLoseLabel;

    @FXML
    private Pane itemPane;

    @FXML
    private ImageView itemImageView1;
    @FXML
    private ImageView itemImageView2;
    @FXML
    private ImageView itemImageView3;
    @FXML
    private ImageView itemImageView4;
    @FXML
    private ImageView itemImageView5;
    @FXML
    private ImageView itemImageView6;

    @FXML
    private Label itemLabel1;
    @FXML
    private Label itemLabel2;
    @FXML
    private Label itemLabel3;
    @FXML
    private Label itemLabel4;
    @FXML
    private Label itemLabel5;
    @FXML
    private Label itemLabel6;


    private Stage stage;
    private Scene scene;
    private Parent root;

    Battle battle = new Battle();

    private double moveX1;
    private double moveY1;
    private double moveX2;
    private double moveY2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        moveX1 = (monsterBattleImageView1.getLayoutX() - playerBattleImageView.getLayoutX())-30;
        moveY1 = (monsterBattleImageView1.getLayoutY() - playerBattleImageView.getLayoutY());
        moveX2 = (monsterBattleImageView2.getLayoutX() - playerBattleImageView.getLayoutX())-30;
        moveY2 = (monsterBattleImageView2.getLayoutY() - playerBattleImageView.getLayoutY());

        //Player Initialization
        playerBattleImageView.setImage(RPG.player.getplayerImageStandByRight());
        playerBattleName.setText(RPG.player.getName());
        playerLevelLabel.setText("LV: " + RPG.player.getLevel());
        
        //Monster1 Initialization
        monsterBattleImageView1.setVisible(true);
        monsterBattleImageView1.setImage(battle.getMonster1().getImage("Left"));
        monsterBattleName1.setVisible(true);
        monsterBattleName1.setText("Monster1");
        monsterHPBar1.setVisible(true);
        monsterHPBar1.setProgress(battle.getMonster1().getHP() / battle.getMonster1().getMaxHP());

        //Monster2 Initialization
        monsterBattleImageView2.setVisible(true);
        monsterBattleImageView2.setImage(battle.getMonster2().getImage("Left"));
        monsterBattleName2.setVisible(true);
        monsterBattleName2.setText("Monster2");
        monsterHPBar2.setVisible(true);
        monsterHPBar2.setProgress(battle.getMonster2().getHP() / battle.getMonster2().getMaxHP());

        winLoseLabel.setVisible(false);
        
        //Dialogue
        showDialogue();

    }

    private void showDialogue()
    {
        dialogue.setVisible(true);
        dialogue.setText("Two monsters showed up!!");
    }

    @FXML
    public void closeDialogue(MouseEvent event)
    {
        dialogue.setVisible(false);

        //Show Control Terminal
        attackButton.setVisible(true);
        magicButton.setVisible(true);
        itemButton.setVisible(true);
        retrieveButton.setVisible(true);

        playerHPBar.setVisible(true);
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        playerMPBar.setVisible(true);
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());

        hpLabel.setVisible(true);
        mpLabel.setVisible(true);

        hpValueLabel.setVisible(true);
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        mpValueLabel.setVisible(true);
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        strLabel.setVisible(true);
        strLabel.setText("str: "+ Integer.toString(RPG.player.getStrNum()));
        intLabel.setVisible(true);
        intLabel.setText("int: "+ Integer.toString(RPG.player.getIntNum()));
        dexLabel.setVisible(true);
        dexLabel.setText("dex: "+ Integer.toString(RPG.player.getDexNum()));
        defLabel.setVisible(true);
        defLabel.setText("def: "+ Integer.toString(RPG.player.getDefNum()));

        monsterButton1.setDisable(false);
        monsterButton2.setDisable(false);
    }

    @FXML
    public void attackButtonAction(ActionEvent event){
        attackButton.setVisible(false);
        magicButton.setVisible(false);
        itemButton.setVisible(false);
        retrieveButton.setVisible(false);

        monsterButton1.setVisible(true);
        monsterButton2.setVisible(true);
        returnButton.setVisible(true);

        
    }

    @FXML
    public void monsterButton1Action() throws InterruptedException {
        monsterButton1.setVisible(false);
        monsterButton2.setVisible(false);
        returnButton.setVisible(false);

        //Forward
        TranslateTransition movePlayerBattleImageView1 = new TranslateTransition(Duration.millis(2000), playerBattleImageView);
        movePlayerBattleImageView1.setByX(moveX1);
        movePlayerBattleImageView1.setByY(moveY1);

        //Set monster's bar
        ProgressBarTransition setMonsterBar = new ProgressBarTransition(Duration.seconds(1.5), monsterHPBar1, battle.getMonster1());
        setMonsterBar.setOnFinished(event ->{
            if(battle.getMonster1().getHP() == 0){
                monsterBattleImageView1.setVisible(false);
                monsterBattleName1.setVisible(false);
                monsterHPBar1.setVisible(false);
            }
        });
        
        //Backward
        TranslateTransition movePlayerBattleImageView2 = new TranslateTransition(Duration.millis(2000), playerBattleImageView);
        movePlayerBattleImageView2.setByX(-moveX1);
        movePlayerBattleImageView2.setByY(-moveY1);

        //Monster1 attack
        //Forward
        TranslateTransition moveMonster1BattleImageView1 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView1);
        moveMonster1BattleImageView1.setByX(-moveX1);
        moveMonster1BattleImageView1.setByY(-moveY1);

        //Set player's bar
        ProgressBarTransition setPlayerBar = new ProgressBarTransition(Duration.seconds(1.5), playerHPBar, RPG.player);
        
        //Backward
        TranslateTransition moveMonster1BattleImageView2 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView1);
        moveMonster1BattleImageView2.setByX(moveX1);
        moveMonster1BattleImageView2.setByY(moveY1);

        //Monster2 attack
        TranslateTransition moveMonster2BattleImageView1 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView2);
        moveMonster2BattleImageView1.setByX(-moveX2);
        moveMonster2BattleImageView1.setByY(-moveY2);

        TranslateTransition moveMonster2BattleImageView2 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView2);
        moveMonster2BattleImageView2.setByX(moveX2);
        moveMonster2BattleImageView2.setByY(moveY2);

        moveMonster2BattleImageView2.setOnFinished(event -> {
            monsterBattleImageView2.setImage(battle.getMonster2().getImage("Left"));
            if(RPG.player.getHP() == 0){
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                attackButton.setVisible(true);
                magicButton.setVisible(true);
                itemButton.setVisible(true);
                retrieveButton.setVisible(true);
            }
        });

        moveMonster2BattleImageView1.setOnFinished(event -> {
            monsterBattleImageView2.setImage(battle.getMonster2().getImage("Right"));
            setPlayerBar.setStartValue(RPG.player.getHP());
            battle.attackMonster(battle.getMonster2(), RPG.player);
            hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
            setPlayerBar.setNewValue(RPG.player.getHP());
            setPlayerBar.play();
            moveMonster2BattleImageView2.play();
        });

        moveMonster1BattleImageView2.setOnFinished(event -> {
            monsterBattleImageView1.setImage(battle.getMonster1().getImage("Left"));
            if(RPG.player.getHP() == 0){
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
            else if(battle.getMonster2().getHP() != 0)
                moveMonster2BattleImageView1.play();
            else{
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        moveMonster1BattleImageView1.setOnFinished(event -> {
            monsterBattleImageView1.setImage(battle.getMonster1().getImage("Right"));
            setPlayerBar.setStartValue(RPG.player.getHP());
            battle.attackMonster(battle.getMonster1(), RPG.player);
            hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
            setPlayerBar.setNewValue(RPG.player.getHP());
            setPlayerBar.play();
            moveMonster1BattleImageView2.play();
        });


        movePlayerBattleImageView2.setOnFinished(event -> {
            playerBattleImageView.setImage(RPG.player.getplayerImageStandByRight());
            if(battle.getMonster1().getHP() != 0)
                moveMonster1BattleImageView1.play();
            else if(battle.getMonster2().getHP() != 0)
                moveMonster2BattleImageView1.play();
            else{
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        movePlayerBattleImageView1.setOnFinished(event -> {
            playerBattleImageView.setImage(RPG.player.getplayerImageStandByLeft());
            setMonsterBar.setStartValue(battle.getMonster1().getHP());
            battle.attackPlayer(RPG.player, battle.getMonster1());
            setMonsterBar.setNewValue(battle.getMonster1().getHP());
            if(battle.getMonster1().getHP() == 0)
                monsterButton1.setDisable(true);
            setMonsterBar.play();
            movePlayerBattleImageView2.play();
        });

        movePlayerBattleImageView1.play();
    }
    
    @FXML
    public void monsterButton2Action() {
        monsterButton1.setVisible(false);
        monsterButton2.setVisible(false);
        returnButton.setVisible(false);

        //Forward
        TranslateTransition movePlayerBattleImageView1 = new TranslateTransition(Duration.millis(2000), playerBattleImageView);
        movePlayerBattleImageView1.setByX(moveX2);
        movePlayerBattleImageView1.setByY(moveY2);

        //Set monster's bar
        ProgressBarTransition setMonsterBar = new ProgressBarTransition(Duration.seconds(1.5), monsterHPBar2, battle.getMonster2());
        setMonsterBar.setOnFinished(event ->{
            if(battle.getMonster2().getHP() == 0){
                monsterBattleImageView2.setVisible(false);
                monsterBattleName2.setVisible(false);
                monsterHPBar2.setVisible(false);
            }
        });
        
        //Backward
        TranslateTransition movePlayerBattleImageView2 = new TranslateTransition(Duration.millis(2000), playerBattleImageView);
        movePlayerBattleImageView2.setByX(-moveX2);
        movePlayerBattleImageView2.setByY(-moveY2);

        //Monster1 attack
        //Forward
        TranslateTransition moveMonster1BattleImageView1 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView1);
        moveMonster1BattleImageView1.setByX(-moveX1);
        moveMonster1BattleImageView1.setByY(-moveY1);

        //Set player's bar
        ProgressBarTransition setPlayerBar = new ProgressBarTransition(Duration.seconds(1.5), playerHPBar, RPG.player);
        
        //Backward
        TranslateTransition moveMonster1BattleImageView2 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView1);
        moveMonster1BattleImageView2.setByX(moveX1);
        moveMonster1BattleImageView2.setByY(moveY1);

        //Monster2 attack
        TranslateTransition moveMonster2BattleImageView1 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView2);
        moveMonster2BattleImageView1.setByX(-moveX2);
        moveMonster2BattleImageView1.setByY(-moveY2);

        TranslateTransition moveMonster2BattleImageView2 = new TranslateTransition(Duration.millis(2000), monsterBattleImageView2);
        moveMonster2BattleImageView2.setByX(moveX2);
        moveMonster2BattleImageView2.setByY(moveY2);

        moveMonster2BattleImageView2.setOnFinished(event -> {
            monsterBattleImageView2.setImage(battle.getMonster2().getImage("Left"));
            
            if(RPG.player.getHP() == 0){
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                attackButton.setVisible(true);
                magicButton.setVisible(true);
                itemButton.setVisible(true);
                retrieveButton.setVisible(true);
            }
        });

        moveMonster2BattleImageView1.setOnFinished(event -> {
            monsterBattleImageView2.setImage(battle.getMonster2().getImage("Right"));
            setPlayerBar.setStartValue(RPG.player.getHP());
            battle.attackMonster(battle.getMonster2(), RPG.player);
            hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
            setPlayerBar.setNewValue(RPG.player.getHP());
            setPlayerBar.play();
            moveMonster2BattleImageView2.play();
        });

        moveMonster1BattleImageView2.setOnFinished(event -> {
            monsterBattleImageView1.setImage(battle.getMonster1().getImage("Left"));
            if(RPG.player.getHP() == 0){
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
            else if(battle.getMonster2().getHP() != 0)
                moveMonster2BattleImageView1.play();
            else if(battle.getMonster1().getHP() != 0){
                attackButton.setVisible(true);
                magicButton.setVisible(true);
                itemButton.setVisible(true);
                retrieveButton.setVisible(true);
            }
            else{
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        moveMonster1BattleImageView1.setOnFinished(event -> {
            monsterBattleImageView1.setImage(battle.getMonster1().getImage("Right"));
            setPlayerBar.setStartValue(RPG.player.getHP());
            battle.attackMonster(battle.getMonster1(), RPG.player);
            hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
            setPlayerBar.setNewValue(RPG.player.getHP());
            setPlayerBar.play();
            moveMonster1BattleImageView2.play();
        });


        movePlayerBattleImageView2.setOnFinished(event -> {
            playerBattleImageView.setImage(RPG.player.getplayerImageStandByRight());
            if(battle.getMonster1().getHP() != 0)
                moveMonster1BattleImageView1.play();
            else if(battle.getMonster2().getHP() != 0)
                moveMonster2BattleImageView1.play();
            else{
                try {
                    stopBattle();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        movePlayerBattleImageView1.setOnFinished(event -> {
            playerBattleImageView.setImage(RPG.player.getplayerImageStandByLeft());
            setMonsterBar.setStartValue(battle.getMonster2().getHP());
            battle.attackPlayer(RPG.player, battle.getMonster2());
            setMonsterBar.setNewValue(battle.getMonster2().getHP());
            if(battle.getMonster2().getHP() == 0)
                monsterButton2.setDisable(true);
            setMonsterBar.play();
            movePlayerBattleImageView2.play();
        });

        movePlayerBattleImageView1.play();
    }

    @FXML
    public void returnAction(ActionEvent event) {
        monsterButton1.setVisible(false);
        monsterButton2.setVisible(false);
        returnButton.setVisible(false);

        attackButton.setVisible(true);
        magicButton.setVisible(true);
        itemButton.setVisible(true);
        retrieveButton.setVisible(true);
    }

    public void stopBattle() throws IOException {
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
        pauseTransition.setOnFinished(event -> {
            winLoseLabel.setVisible(true);
            if(RPG.player.getHP() == 0) {
                winLoseLabel.setText("Game Over!! QQ");
            } else {
                int startLevel = RPG.player.getLevel();
                battle.gainExp(RPG.player, battle.getMonster1().getExp(), battle.getMonster2().getExp());
                int endLevel = RPG.player.getLevel();
                winLoseLabel.setText("You Win!! LV: " + startLevel + "->" + endLevel);
            }
        });
        pauseTransition.play();
    }

    public void stopBattleAction(MouseEvent event) {
        if(RPG.player.getHP() == 0) {
            try {
                root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();   
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if(RPG.player.getLevel() >= 5 && String.valueOf(RPG.player.getClass()).compareTo("class player.NovicePlayer") == 0){
                try {
                    root = FXMLLoader.load(getClass().getResource("TransferScene.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();   
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
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
    }

    public void itemButtonAction(){
        attackButton.setDisable(true);
        magicButton.setDisable(true);
        itemButton.setDisable(true);
        retrieveButton.setDisable(true);

        itemPane.setVisible(true);

        ImageView[] itemImageViewArray = new ImageView[6];
        itemImageViewArray[0] = itemImageView1;
        itemImageViewArray[1] = itemImageView2;
        itemImageViewArray[2] = itemImageView3;
        itemImageViewArray[3] = itemImageView4;
        itemImageViewArray[4] = itemImageView5;
        itemImageViewArray[5] = itemImageView6;

        Label[] itemLabelArray = new Label[6];
        itemLabelArray[0] =itemLabel1;
        itemLabelArray[1] =itemLabel2;
        itemLabelArray[2] =itemLabel3;
        itemLabelArray[3] =itemLabel4;
        itemLabelArray[4] =itemLabel5;
        itemLabelArray[5] =itemLabel6;

        for(int i = 0; i < 6; i++){
            itemImageViewArray[i].setVisible(false);
            itemLabelArray[i].setVisible(false);
        }

        for(int i = 0; i < RPG.player.getItemIndex(); i++){
            itemImageViewArray[i].setVisible(true);
            itemLabelArray[i].setVisible(true);
            itemImageViewArray[i].setImage(RPG.player.getItem()[i].getImage());
            itemLabelArray[i].setText(RPG.player.getItem()[i].getName() + " * " + RPG.player.getItem()[i].getNum());
        }
    }

    @FXML
    public void itemAction1(MouseEvent event){
        //use
        RPG.player.getItem()[0].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }
    @FXML
    public void itemAction2(MouseEvent event){
        //use
        RPG.player.getItem()[1].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));
        
        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }
    @FXML
    public void itemAction3(MouseEvent event){
        //use
        RPG.player.getItem()[2].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }
    @FXML
    public void itemAction4(MouseEvent event){
        //use
        RPG.player.getItem()[3].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }
    @FXML
    public void itemAction5(MouseEvent event){
        //use
        RPG.player.getItem()[4].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }
    @FXML
    public void itemAction6(MouseEvent event){
        //use
        RPG.player.getItem()[5].use("Battle");
        playerHPBar.setProgress((double)RPG.player.getHP() / RPG.player.getMaxHP());
        hpValueLabel.setText(Integer.toString(RPG.player.getHP()) + "/" + Integer.toString(RPG.player.getMaxHP()));
        playerMPBar.setProgress((double)RPG.player.getMP() / RPG.player.getMaxMP());
        mpValueLabel.setText(Integer.toString(RPG.player.getMP()) + "/" + Integer.toString(RPG.player.getMaxMP()));

        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }

    public void itemReturnButtonAction(){
        itemPane.setVisible(false);

        attackButton.setDisable(false);
        //magicButton.setDisable(false);
        itemButton.setDisable(false);
        retrieveButton.setDisable(false);
    }

    public void retrieveButtonAction(ActionEvent event){
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
