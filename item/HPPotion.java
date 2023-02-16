package item;

import Main.RPG;

import javafx.scene.image.Image;

public class HPPotion extends Item{
    public HPPotion(int num){
        super(num);
        setImage(new Image(getClass().getResourceAsStream("../itemPictures/HPPotion.png")));
        setName("HP Potion");
        setUsable("Map", "Battle");
    }

    @Override
    public void use(String usable){
        for(int i = 0; i < this.getUsableIndex(); i++)
        {
            if(this.getUsable()[i].equals(usable)){
                this.setNum(this.getNum() - 1);
                RPG.player.setHP(RPG.player.getHP() + 100);
                break;
            }
        }
    }
}
