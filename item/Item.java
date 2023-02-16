package item;

import javafx.scene.image.Image;

public class Item {
    private Image image;
    private String name;
    private int num;
    private String[] usableList = new String[10];
    private int usableIndex = 0;

    public Item(int num){
        this.num = num;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsable(String... usables){
        for(String usable : usables){
            this.usableList[this.usableIndex] = usable;
            this.usableIndex++;
        }
    }

    public String[] getUsable(){
        return usableList;
    }

    public int getUsableIndex(){
        return usableIndex;
    }

    public int getNum(){
        return this.num;
    }

    public Image getImage(){
        return this.image;
    }

    public String getName(){
        return this.name;
    }

    public void use(String usable){
    }
}
