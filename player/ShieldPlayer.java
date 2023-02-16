package player;

import javafx.scene.image.Image;

public class ShieldPlayer extends NovicePlayer{

    public ShieldPlayer(String name, int level, int XLocation, int YLocation, int Map) {
        super(name, level);
        setLevel();
        setHP(getMaxHP());
        setMP(getMaxMP());
        setExp(this.lastlvupExp);
        setImage();
        setLocation(XLocation, YLocation);
        setMapLocation(Map);
    }
    
    
    public void setLevel() {
        this.level = this.getLevel();
        this.strNum = 40 + 8 * getLevel();
        this.intNum = 20 + 5 * getLevel();
        this.dexNum = 20 + 4 * getLevel();
        this.defNum = 50 + 12 * getLevel();
        this.maxHP = 250 + 20 * getLevel();
        this.maxMP = 50 + 5 * getLevel();
        this.lvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        this.lastlvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }
    
    /*
    public void specialSkill() {
        if (getMP() - 5 * getLevelNum() > 0) {
            setHP(getHP() + 10 * getLevelNum());
            setMP(getMP() - 5 * getLevelNum());
            //well define
        }
    }*/

    public void setImage(){
        this.playerImageStandByRight = new Image(getClass().getResourceAsStream("../playerPictures/ShieldStandByRight.gif"));
        this.playerImageStandByLeft = new Image(getClass().getResourceAsStream("../playerPictures/ShieldStandByLeft.gif"));
        this.playerImageRunningByRight = new Image(getClass().getResourceAsStream("../playerPictures/Shield_Running_2.5.gif"));
        this.playerImageRunningByLeft = new Image(getClass().getResourceAsStream("../playerPictures/Shield_Running_2.gif"));
    }

}
