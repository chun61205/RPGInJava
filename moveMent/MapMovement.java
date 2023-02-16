package moveMent;

import Main.RPG;
import item.Key;
import javafx.scene.image.Image;

public class MapMovement {
	Key key = new Key(1);
	static private int[][] MapArray_1 = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,0,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,0,0,0,2,0,0,0,0,0,0,1,1},
			{1,1,0,1,1,0,1,0,1,1,1,0,1,1},
			{1,1,2,0,0,2,1,0,1,2,1,0,1,1},
			{1,1,0,1,1,0,1,0,1,0,1,0,1,1},
			{1,1,2,3,1,2,1,0,0,0,1,0,1,1},
			{1,1,1,1,1,0,1,1,1,1,1,0,1,1},
			{1,1,0,2,0,0,0,0,0,0,0,0,1,1},
			{1,1,0,1,1,0,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,0,0,0,0,0,4,5,1,1},
			{1,1,2,0,0,0,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	static private int[][] MapArray_2 = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,0,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,0,0,0,0,1,2,0,0,0,0,1,1},
			{1,1,0,1,1,0,1,0,1,1,1,0,1,1},
			{1,1,2,0,0,2,0,0,1,2,1,0,1,1},
			{1,1,0,1,1,0,1,0,1,0,1,0,1,1},
			{1,1,0,1,1,2,1,0,0,0,1,0,1,1},
			{1,1,0,2,1,0,1,1,1,1,1,0,1,1},
			{1,1,1,1,1,0,1,0,0,0,0,0,1,1},
			{1,1,0,2,0,0,1,0,1,1,1,1,1,1},
			{1,1,0,1,1,1,1,0,0,0,0,6,0,0},
			{1,1,2,0,0,0,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	private static boolean ChestTriggered = false, Win = false;
	public static void ReSetMap() {
		ChestTriggered = false;
		Win = false;
		RPG.player.setLocation(2, 2);
		MapArray_1[5][9] =MapArray_1[7][5] =MapArray_1[5][5] =MapArray_1[3][5] =MapArray_1[10][3] =MapArray_1[12][2] =MapArray_1[7][2] =MapArray_1[5][2] = 2;
		MapArray_2[9][5] = MapArray_2[7][3] = MapArray_2[5][5] = MapArray_2[2][5] = MapArray_2[3][10] = MapArray_2[3][8] = MapArray_2[2][12] = MapArray_2[2][5] = 2;
	}
	public static boolean GetWin() {
		return Win;
	}
	//Using to return the correct images of Map & Player
	public int Move(int direction) {//1: Don't Move, 0: Move, 5:Change Map, 2:Battle
		int x = RPG.player.getX_Location();
		int y = RPG.player.getY_Location();
		int[][]map;
		map = RPG.player.getMapLocation() == 1 ? MapArray_1 : MapArray_2;
		switch(direction) {//0:UP, 1:DOWN, 2:LEFT, 3:RIGHT
		case 0:
			if(map[x][y-1] == 2) {
				if(RPG.player.getMapLocation() == 1)
					MapArray_1[x][y-1] = 0;
				else 
					MapArray_2[x][y-1] = 0;
				return 2;
			}else if (map[x][y-1] == 3) {
				if(!ChestTriggered) {
					ChestTriggered = true;
					/*GET CHEST FUNCTION*/
					System.out.println("KEY!");
					key.setNum(1);
				}
			}else if (map[x][y-1] == 6) {
				Win = true;
				return 2;
			}else if (map[x][y-1] == 5) {
				if(key.getNum() != 1|| !ChestTriggered)
					{System.out.println("Don't Have Key "+key.getNum());
				return 1;}
				else {
					key.use("Map");
					return 5;
				} 
			}return map[x][y-1];
		case 1:
			if(map[x][y+1] == 2) {
				if(RPG.player.getMapLocation() == 1)
					MapArray_1[x][y+1] = 0;
				else 
					MapArray_2[x][y+1] = 0;
				return 2;
			}else if (map[x][y+1] == 3) {
				if(!ChestTriggered) {
					ChestTriggered = true;
					/*GET CHEST FUNCTION*/
					System.out.println("KEY!");
					key.setNum(1);
				}
			}else if (map[x][y+1] == 6) {
				Win = true;
				return 2;
			}else if (map[x][y+1] == 5) {
				if(key.getNum() != 1|| !ChestTriggered)
				{System.out.println("Don't Have Key"+key .getNum());
			return 1;}
			else {
				key.use("Map");
				return 5;
			} 
			}return map[x][y+1];
		case 2:
			if(map[x-1][y] == 2) {
				if(RPG.player.getMapLocation() == 1)
					MapArray_1[x-1][y] = 0;
				else 
					MapArray_2[x-1][y] = 0;
				return 2;
			}else if (map[x-1][y] == 3) {
				if(!ChestTriggered) {
					ChestTriggered = true;
					/*GET CHEST FUNCTION*/
					System.out.println("KEY!");
					key.setNum(1);
				}
			}else if (map[x-1][y] == 6) {
				Win = true;
				return 2;
			}else if (map[x-1][y] == 5) {
				if(key.getNum() != 1 || !ChestTriggered)
				{System.out.println("Don't Have Key "+key.getNum());
			return 1;}
			else {
				key.use("Map");
				return 5;
			} 
			}return map[x-1][y];
		case 3:
			if(map[x+1][y] == 2) {
				if(RPG.player.getMapLocation() == 1)
					MapArray_1[x+1][y] = 0;
				else 
					MapArray_2[x+1][y] = 0;
				return 2;
			}else if (map[x+1][y] == 3) {
				if(!ChestTriggered) {
					ChestTriggered = true;
					/*GET CHEST FUNCTION*/
					System.out.println("KEY!");
					key.setNum(1);
				}
			}else if (map[x+1][y] == 6) {
				Win = true;
				return 2;
			}else if (map[x+1][y] == 5) {
				if(key.getNum() != 1|| !ChestTriggered)
				{System.out.println("Don't Have Key = "+key.getNum());
				
			return 1;}
				
			else {
				key.use("Map");
				return 5;
			} 
			}return map[x+1][y];
		default:
			return 9;
		}
	}
	//
	public Image newMapFragment(int i, int j) {
		//use i, j, Player Location to figure out what image should it be;
		int ab_i = RPG.player.getX_Location() - 2 + i;
		int ab_j = RPG.player.getY_Location() - 2 + j;
		if(ab_i<=14 && ab_i >= 0 && ab_j <= 14 && ab_j >= 0) {
			System.out.println("i = "+ab_i+", j = "+ab_j);
			return wholeMap(ab_i, ab_j);
		}
		return new Image(getClass().getResourceAsStream("../mapElementsPicture/Wall-1.png"));
	}
	//
	public Image wholeMap(int i, int j) {
		int[][] Map_Array = RPG.player.getMapLocation() == 1 ? MapArray_1 : MapArray_2;
		switch(Map_Array[i][j]) {
		case 0:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/Floor_1.png"));
		case 1:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/Wall-1.png"));
		case 2:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/Monster_Block.png"));
		case 3:
			if(!ChestTriggered) 
				return new Image(getClass().getResourceAsStream("../mapElementsPicture/Chest_1.png"));
			else
				return new Image(getClass().getResourceAsStream("../mapElementsPicture/Chest_3.png"));
		case 4:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/Floor_bf_door.png"));
		case 5:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/Door.gif"));
		case 6:
			return new Image(getClass().getResourceAsStream("../mapElementsPicture/BossBlock.png"));
		default:
			return new Image(getClass().getResourceAsStream("../playerPictures/NoviceStandByLeft.gif"));
		}
		
	}
}
