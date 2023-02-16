package scene;

import java.io.IOException;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;
import javafx.util.Duration;
import Main.RPG;
import moveMent.MapMovement;
import player.NovicePlayer;

public class MapScene
{
	//Otuslettia:
	//Left to go:
	//1. Map design for the second Map
	//2. Q:How to call Boss?
	//3. Q:How to get key?
	//4. More kind of Floor
	//5. Chest Animation
	//6. If the Animation and picture go well?
	
	MapMovement move_ment = new MapMovement();
	private boolean walking = false;
	private int status = -1;
	private boolean opening = true;
	
	@FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    AnchorPane BigPane;
    @FXML
	private ImageView PlayerImage;
    @FXML
    private Pane OpeningPane, Map_Pane;
    @FXML
    private Button BattleButton, START_B, WB, AB, SB, DB, Win_B;
    @FXML
    private ImageView Image_onPane;
    @FXML
    private ImageView[][] MapImages = new ImageView[7][5];
	/*MapImages = {{new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView()},
				{new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView()},
				{new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView()},
				{new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView()},
				{new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView(),new ImageView()},
			}*/
	@FXML
    void BattleButton_click(ActionEvent event) //throws IOException
    {
		//BattleButton invisible
		try{
            //RPG.player = new NovicePlayer(namingTextField.getText(), 1);
            try{
                root = FXMLLoader.load(getClass().getResource("BattleScene.fxml"));
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
		//
		if(!MapMovement.GetWin()) {
			BattleButton.setVisible(false);
			BattleButton.setDisable(true);
			DontMove(0);
		}else {
			Win_B.setVisible(true);
			Win_B.setDisable(false);
			Win_B.toFront();
		}
    }
	//call battle
	private void callBattle() {
		//BattleButten visible;
		BattleButton.setVisible(true);
		BattleButton.setDisable(false);
		BattleButton.toFront();
	}
	//SetMap(Initialize)
	private void Map_Initial() {
		//When changing Map
		//1. Reset Player image
		//2. Reset Player Location
		//3. Reset Player MapLocation
		//RPG.player.setLocation(2, 2);
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 5; j++) {
				MapImages[i][j] = new ImageView();
				MapImages[i][j].setPreserveRatio(true);
				MapImages[i][j].setSmooth(true);
				MapImages[i][j].relocate(-175+150*i+100, -225+150*j+75);
				MapImages[i][j].setFitWidth(150);
				MapImages[i][j].setVisible(true);
				MapImages[i][j].setImage(move_ment.newMapFragment(i, j));
				Map_Pane.getChildren().addAll(MapImages[i][j]);
			}
		}
		if(MapMovement.GetWin()) {
			Win_B.setVisible(true);
			Win_B.setDisable(false);
			Win_B.toFront();	
		}else
			this.Player_initial();
	}
	@FXML
	void WinButton(ActionEvent event) {
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
	//Set PlayerImage(Initialize)
	private void Player_initial() {
		PlayerImage.setVisible(true);
		PlayerImage.toFront();
		PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());
	}
	//wasd controller
	@FXML
	void keyPressed(KeyEvent key) {
		System.out.println("Press!");
		if(MapMovement.GetWin()) {
			Win_B.setVisible(true);
			Win_B.setDisable(false);
			Win_B.toFront();
		}
		int direction = 0;
		if(opening) {
			this.Map_Initial();
			System.out.println("Press@@!");
			//Image_onPane.setImage(new Image(getClass().getResourceAsStream("../mapElementsPicture/Welcome.png")));
			BattleButton.setVisible(false);
			BattleButton.setDisable(true);
			OpeningPane.setVisible(false);
			WB.setVisible(true);
			AB.setVisible(true);
			SB.setVisible(true);
			DB.setVisible(true);
			START_B.setVisible(false);
			START_B.setDisable(true);
			opening = !opening;
		}else if(!walking) {
			System.out.println("Useing");
			switch(key.getCode()) {
			case W:
				System.out.println("W");
				walking = true;
				PlayerImage.setImage(RPG.player.getplayerImageRunningByLeft());
				direction = 0;
				status = move_ment.Move(0);
	    		break;
			case A:
				System.out.println("A");
				walking = true;
				PlayerImage.setImage(RPG.player.getplayerImageRunningByLeft());
				direction = 2;
				status = move_ment.Move(2);
				break;
			case S:
				System.out.println("S");
				walking = true;
				PlayerImage.setImage(RPG.player.getplayerImageRunningByRight());
				direction = 1;
				status = move_ment.Move(1);
				break;
			case D:
				System.out.println("D");
				walking = true;
				PlayerImage.setImage(RPG.player.getplayerImageRunningByRight());
				direction = 3;
				status = move_ment.Move(3);
				break;
			default:
				System.out.println("N");
				status = -1;
				break;
			}
			System.out.println("Direction = "+direction);
			System.out.println("Status = "+status);
			switch(status) {
			case 0://Move
				MoveMap(direction);
				break;
			case 1://Don't Move
				DontMove(direction);
				break;
			case 2://Battle
				callBattle();
				break;
			case 3://Chest
				MoveMap(direction);
				break;
			case 4://Floor bf Door
				MoveMap(direction);
				break;
			case 5://Change Map
				RPG.player.setMapLocation(2);
				RPG.player.setLocation(2, 2);
				Map_Initial();
				walking = !walking;
				break;
			case 6://Change Map
				callBattle();
				Map_Initial();
				walking = !walking;
				break;
			default :
				break;
			}
		}
	}
	/*
	@FXML
    void keyPressed(KeyEvent event) {
		System.out.println("!!");
    }
    */
	//if cannot move, switch back to Stand gif
	public void DontMove(int direction) {
		walking = false;
		switch(direction) {
			case 0:PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());break;
			case 1:PlayerImage.setImage(RPG.player.getplayerImageStandByRight());break;
			case 2:PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());break;
			case 3:PlayerImage.setImage(RPG.player.getplayerImageStandByRight());break;
		}
	}
	//the Animation to move Map image views
	public void MoveMap(int direction) {//0:UP, 1:DOWN, 2:LEFT, 3:RIGHT
		//Path path = new Path();
		switch(direction) {
		case 0:
			RPG.player.setLocation(RPG.player.getX_Location(), RPG.player.getY_Location()-1); break;
		case 1:
			RPG.player.setLocation(RPG.player.getX_Location(), RPG.player.getY_Location()+1); break;
		case 2:
			RPG.player.setLocation(RPG.player.getX_Location()-1, RPG.player.getY_Location()); break;
		case 3:
			RPG.player.setLocation(RPG.player.getX_Location()+1, RPG.player.getY_Location()); break;
		}
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 5; j++) {
				//path.getElements().add(new MoveTo(-175+150*i+100, -225+150*j+75));
				/*
				switch(direction) {
				case 0:
					path.getElements().add(new VLineTo(-150)); break;
				case 1:
					path.getElements().add(new VLineTo(150)); break;
				case 2:
					path.getElements().add(new HLineTo(-150));break;
				case 3:
					path.getElements().add(new HLineTo(150));break;
				}*/
				/*
				PathTransition Pt = new PathTransition();
				Pt.setNode(MapImages[i][j]);
				Pt.setDuration(Duration.seconds(0.5));
				Pt.setPath(path);
				Pt.setAutoReverse(false);
				Pt.setCycleCount(1);
				final int fi = i, fj = j;
				Pt.setOnFinished(e -> {
					
					switch(direction) {
					case 0:
						PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());
						MapImages[fi][fj].yProperty().add(150); break;
					case 1:
						PlayerImage.setImage(RPG.player.getplayerImageStandByRight());
						MapImages[fi][fj].yProperty().add(-150); break;
					case 2:
						PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());
						MapImages[fi][fj].xProperty().add(150); break;
					case 3:
						PlayerImage.setImage(RPG.player.getplayerImageStandByRight());
						MapImages[fi][fj].xProperty().add(-150); break;
					}
					walking = false;
					MapImages[fi][fj].relocate(-175+150*fi+100, -225+150*fj+75);
					System.out.println("ReSort");
				});
				Pt.play();
				*/
				TranslateTransition tl = new TranslateTransition();
				tl.setNode(MapImages[i][j]);
				tl.setDuration(Duration.millis(500));
				switch(direction) {
				case 0:
					PlayerImage.setImage(RPG.player.getplayerImageRunningByLeft());
					tl.setByY(150); break;
				case 1:
					PlayerImage.setImage(RPG.player.getplayerImageRunningByRight());
					tl.setByY(-150); break;
				case 2:
					PlayerImage.setImage(RPG.player.getplayerImageRunningByLeft());
					tl.setByX(150); break;
				case 3:
					PlayerImage.setImage(RPG.player.getplayerImageRunningByRight());
					tl.setByX(-150); break;
				}
				
				final int fi= i, fj = j;
				tl.setOnFinished(e -> {
					TranslateTransition t2 = new TranslateTransition();
					t2.setNode(MapImages[fi][fj]);
					t2.setDuration(Duration.millis(1));
					switch(direction) {
					case 0:
						PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());
						t2.setByY(-150); break;
					case 1:
						PlayerImage.setImage(RPG.player.getplayerImageStandByRight());
						t2.setByY(150); break;
					case 2:
						PlayerImage.setImage(RPG.player.getplayerImageStandByLeft());
						t2.setByX(-150); break;
					case 3:
						PlayerImage.setImage(RPG.player.getplayerImageStandByRight());
						t2.setByX(150); break;
					}
					//System.out.printf("fi = "+ fi+ "fj = "+fj);
					//MapImages[fi][fj].setLayoutX(-175+150*fi+100);
					//MapImages[fi][fj].setLayoutY(-225+150*fj+75);
					//MapImages[fi][fj].relocate(-175+150*fi+100, -225+150*fj+75);
					t2.play();
					if(fi <= 14 && fj <=14 && fi >=0 && fj >= 0)	{
						System.out.printf("fi = "+ fi+ "fj = "+fj+"\n");
							MapImages[fi][fj].setImage(move_ment.newMapFragment(fi, fj));
						}
				});
				tl.play();
				walking = false;
				DontMove(direction);
				//MapImages[i][j].relocate(-175+150*i+100, -225+150*j+75);
				//path.getElements().add(new MoveTo(-175+150*i+100, -225+150*j+75));
			}
		}
		System.out.println("Location:"+RPG.player.getX_Location()+", "+RPG.player.getY_Location());
	}

}
