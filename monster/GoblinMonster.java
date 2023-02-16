package monster;

import javafx.scene.image.Image;

public class GoblinMonster extends BaseMonster{

    public GoblinMonster() {
        super(60, 40, 30, 100, 50);
	    setHP(100);
	    setMP(50);
        setImage(new Image(getClass().getResourceAsStream("../monsterPictures/GoblinStandByLeft.gif")), new Image(getClass().getResourceAsStream("../monsterPictures/GoblinStandByRight.gif")));
    }

}
