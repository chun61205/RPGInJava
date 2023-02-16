package monster;

import javafx.scene.image.Image;

public class DragonMonster extends BaseMonster{

    public DragonMonster(){
        super(120, 100, 175, 250, 100);
        setHP(250);
        setMP(100);
        setImage(new Image(getClass().getResourceAsStream("../monsterPictures/DragonLeft.png")), new Image(getClass().getResourceAsStream("../monsterPictures/DragonRight.png")));
    }

}
