package player;

import item.*;
import javafx.scene.image.Image;

public class NovicePlayer{

    //Some value related to the level
    protected int level;
	protected int strNum;
    protected int intNum;
    protected int dexNum;
    protected int defNum;
	protected int maxHP;
	protected int maxMP;
	protected int lvupExp;
	protected int lastlvupExp;

    //Some value related to the player
	private String playerName;
	private int hp;
	private int mp;
	private int exp;
    private Item[] item = new Item[6];
    private int itemIndex = 0;
    private int xLocation = 2;
    private int yLocation = 2;
    private int MapLocation = 1;

    //Pictures of the player
    protected Image playerImageStandByRight = new Image(getClass().getResourceAsStream("../playerPictures/NoviceStandByRight.gif"));
    protected Image playerImageStandByLeft = new Image(getClass().getResourceAsStream("../playerPictures/NoviceStandByLeft.gif"));
    protected Image playerImageRunningByLeft = new Image(getClass().getResourceAsStream("../playerPictures/Newbie_Running_1.gif"));
    protected Image playerImageRunningByRight = new Image(getClass().getResourceAsStream("../playerPictures/Newbie_Running_1.gif"));
	//private int money;
    /*
	private Item* backpack[6] = {NULL}; 
	private WeaponItem* weapon;
	private ArmorItem* armor;
    */

	public final int backpackSlotLimit = 6;
    
    public NovicePlayer(String name, int level) {
        setLevel(level);
	    setName(name);
        setHP(getMaxHP());
        setMP(getMaxMP());
        setExp(lastlvupExp);
        setImage();
        setInitItem();
        //setMoney(0);
        setLocation(2, 2);
        setMapLocation(1);
    }

    

    /*
    copy constructor but I remeber that java can copy directly using "="
    public NovicePlayer( NovicePlayer n){
        backpack_weight_limit = 100;
        backpack_slot_limit = 6;
        setLevel(n.getLevel());
	    setName(n.getName());
	    setHP(n.getHP());
	    setMP(n.getMP());
	    setExp(n.getExp());
	    setMoney(n.getMoney());
    }
    */

    public String getName(){
        return this.playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public int getHP(){
        return this.hp;
    }
    
    public void setHP(int hp) {
        if (hp <= 0) { 
            this.hp = 0; 
        } else if (hp >= getMaxHP()) {
            this.hp = getMaxHP(); 
        } else { 
            this.hp = hp; 
        }
    }

    public int getMP(){
        return this.mp;
    }
    
    public void setMP(int mp) {
        if (mp <= 0) { 
            this.mp = 0; 
        }
        else if (mp > getMaxHP()) { 
            this.mp = getMaxMP(); 
        }
        else { 
            this.mp = mp; 
        }
    }

    public final int getExp(){
        return this.exp;
    }
    /*
    public int getMoney(){
        return money;
    }

    public void setMoney(int m) {
        money = (0 <= m) ? m : 0;
    }*/
    
    public void setExp(int exp) {
        this.exp = exp;
        while(this.exp >= this.lvupExp){
            setLevel(this.level + 1);
        }
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
        this.strNum = 50 + 5 * level;
        this.intNum = 50 + 5 * level;
        this.dexNum = 20 + 5 * level;
        this.defNum = 20 + 5 * level;
        this.maxHP = 250 + 10 * level;
        this.maxMP = 40 + 5 * level;
        this.lvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel() + 1)/Math.log(2)));
        this.lastlvupExp = (int) Math.ceil(Math.pow(10, Math.log(getLevel())/Math.log(2)));
    }
    
    public void setLocation(int x, int y) {
    	this.xLocation = x;
    	this.yLocation = y;
    }
    
    public void setMapLocation(int Map) {
    	this.MapLocation = Map;
    }
    
    public int getMapLocation() {
    	return this.MapLocation;
    }
    
    public int getX_Location() {
    	return this.xLocation;
    }
    
    public int getY_Location() {
    	return this.yLocation;
    }

    public int getStrNum(){
        return this.strNum;
    }

    public int getIntNum(){
        return this.intNum;
    }

    public int getDexNum(){
        return this.dexNum;
    }
    
    public int getDefNum(){
        return this.defNum;
    }
    
    public int getMaxHP(){
        return maxHP;
    }
    
    public int getMaxMP(){
        return maxMP;
    }

    public int getLvupExp(){
        return lvupExp;
    }

    public void setImage(){
        playerImageStandByRight = new Image(getClass().getResourceAsStream("../playerPictures/NoviceStandByRight.gif"));
        playerImageStandByLeft = new Image(getClass().getResourceAsStream("../playerPictures/NoviceStandByLeft.gif"));
    }

    public Image getplayerImageStandByRight(){
        return this.playerImageStandByRight;
    }

    public Image getplayerImageStandByLeft(){
        return this.playerImageStandByLeft;
    }
    
    public Image getplayerImageRunningByRight(){
        return this.playerImageRunningByRight;
    }

    public Image getplayerImageRunningByLeft(){
        return this.playerImageRunningByLeft;
    }

    private void setInitItem(){
        this.item[itemIndex] = new HPPotion(10);
        this.itemIndex++;
        this.item[itemIndex] = new MPPotion(10);
        this.itemIndex++;
    }

    public Item[] getItem(){
        return this.item;
    }

    public int getItemIndex(){
        return this.itemIndex;
    }

    /*
    public abstract void specialSkill();
    */
    /*
    public final WeaponItem getweapon(){
        return weapon;
    }

    public final ArmorItem getarmor(){
	    return armor;
    }

    public bool equipWeapon(WeaponItem w) {
	    if (w.level_required  >=  getLevel()) {
		    weapon = w;
		    return 1;
	    }
	    else { return 0; }
    }

    public bool equipArmor(ArmorItem a) {
	    if (a.level_required >= getLevel()) {
		    armor = a;
		    return 1;
	    }
	    else { return 0; }
    }

    publci void useConsumable(ConsumableItem c) {
	    c.use(this);
    }

    public bool putItem(Item it) {
	    for (int i = 0; i < backpack_slot_limit; i++) {
		
		    if (backpack[i] == NULL) {
			    if ((it.weight) <= (backpack_weight_limit - backpack_weight)) {
				    backpack[i] = it;
				    backpack_weight += it.weight;
				    return 1;
			    }
			    else { return 0; }
		    }

		    else { return 0; }
	    }
    }

    public tem takeItem(int n) {
	    Item i = NULL;

	    if (backpack[n] != NULL) {
		    i = backpack[n];
		    backpack[n] = NULL;
		    backpack_weight -= i.weight;
	    }
	return i;
    }   

    */
}


/*save and load in c++
string NovicePlayer::serialize() {
	string s = getName();
	for (int i = 0; i < 5; i++) {
		s += "$";
		switch (i)
		{
		case 0:
			s += to_string(getLevel());
			break;
		case 1:
			s += to_string(getHP());
			break;
		case 2:
			s += to_string(getMP());
			break;
		case 3:
			s += to_string(getExp());
			break;
		case 4:
			s += to_string(getMoney());
			break;
		default:
			break;
		}
	}
	return s;
}

NovicePlayer* NovicePlayer::unserialize(string s) {
	
	static NovicePlayer n;
	for (int i = 0; i < 6; i++) {

		int a = s.find("$");
		string si = s.substr(0, a);
	
		switch (i)
		{
		case 0:
			n.setName(si);
			break;
		case 1:
			n.setLevel(stoi(si));
			break;
		case 2:
			n.setHP(stoi(si));
			break;
		case 3:
			n.setMP(stoi(si));
			break;
		case 4:
			n.setExp(stoi(si));
			break;
		case 5:
			n.setMoney(stoi(si));
			break;
		default:
			break;
		};
		s.erase(0, (si.length() + 1));
	}

	return &n;
}
*/