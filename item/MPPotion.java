package item;

import Main.RPG;

import javafx.scene.image.Image;

public class MPPotion extends Item{
    public MPPotion(int num){
        super(num);
        setImage(new Image(getClass().getResourceAsStream("../itemPictures/MPPotion.png")));
        setName("MP Potion");
        setUsable("Map", "Battle");
    }

    @Override
    public void use(String usable){
        for(int i = 0; i < this.getUsableIndex(); i++)
        {
            if(this.getUsable()[i].equals(usable)){
                this.setNum(this.getNum() - 1);
                RPG.player.setMP(RPG.player.getMP() + 100);
                break;
            }
        }
    }
}
