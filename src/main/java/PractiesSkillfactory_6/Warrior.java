package PractiesSkillfactory_6;

public class Warrior extends Player{
    String armor;

    Warrior(int hp, int level, String type, String weapon, String armor){
        super(hp, level, type, weapon);
        this.armor = armor;
    }

    @Override
    public String getFullInfo() {
        return "hp: " + hp + " level: " + level + " type: " + type + " weapon: " + weapon + " armor: " + armor;
    }

    @Override
    public void levelUp() {
        level++;

    }

    @Override
    public boolean doDamage() {
        return true;
    }
}
