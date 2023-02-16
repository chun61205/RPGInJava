package item;

import javafx.scene.image.Image;

public class Key extends Item{
    public Key(int num){
        super(num);
        setImage(new Image(getClass().getResourceAsStream("../itemPictures/Key.png")));
        setName("Key");
        setUsable("Map");
    }

    @Override
    public void use(String usable){
        for(int i = 0; i < this.getUsableIndex(); i++)
        {
            if(this.getUsable()[i].equals(usable)){
                this.setNum(this.getNum() - 1);
                break;
            }
        }
        
    }
}
