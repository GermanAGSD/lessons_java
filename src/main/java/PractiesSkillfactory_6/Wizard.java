package PractiesSkillfactory_6;

public class Wizard extends Player{
    int manaLevel;
    String element;

    Wizard(int hp, int level, String type, String weapon, int manaLevel, String element) {
        super(hp, level, type, weapon);
        this.manaLevel = manaLevel;
        this.element = element;
    }


    @Override
    public String getFullInfo() {
        return "HP: " + hp + " level: " + level + " type: " + type + " weapon: " + weapon + " mana level: " + manaLevel + " element: " + element;
    }

    @Override
    public void levelUp() {
        this.level++;
    }

    @Override
    public boolean doDamage() {
        if(manaLevel >= 10){
            manaLevel -= 10;
            return true;
        }else{
            return false;
        }
    }

}
