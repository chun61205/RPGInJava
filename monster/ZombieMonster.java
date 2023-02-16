package monster;

import javafx.scene.image.Image;

public class ZombieMonster extends BaseMonster{

    public ZombieMonster(){
        super(50, 65, 65, 150, 30);
        setHP(150);
        setMP(30);
        setImage(new Image(getClass().getResourceAsStream("../monsterPictures/ZombieLeft.png")), new Image(getClass().getResourceAsStream("../monsterPictures/ZombieRight.png")));
    }
}
