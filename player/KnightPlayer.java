package player;

import javafx.scene.image.Image;

public class KnightPlayer extends NovicePlayer{

    public KnightPlayer(String name, int level, int XLocation, int YLocation, int Map) {
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
        this.strNum = 50 + 12 * getLevel();
        this.intNum = 20 + 5 * getLevel();
        this.dexNum = 20 + 8 * getLevel();
        this.defNum = 40 + 8 * getLevel();
        this.maxHP = 200 + 20 * getLevel();
        this.maxMP = 50 + 5 * getLevel();
        this.lvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        this.lastlvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }

    /*
    public void specialSkill() {
        if (getMP() - 5 * getLevel() > 0) {
            setMP(getMP() - 5 * getLevel());
            //undefine very well
        }
    }*/

    public void setImage(){
        this.playerImageStandByRight = new Image(getClass().getResourceAsStream("../playerPictures/KnightStandByRight.gif"));
        this.playerImageStandByLeft = new Image(getClass().getResourceAsStream("../playerPictures/KnightStandByLeft.gif"));
        this.playerImageRunningByRight = new Image(getClass().getResourceAsStream("../playerPictures/Knight_Running_2.5.gif"));
        this.playerImageRunningByLeft = new Image(getClass().getResourceAsStream("../playerPictures/Knight_Running_2.gif"));
    }
}
