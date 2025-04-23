package game.org;

public class Humans extends Entity implements Fighter{

    public Humans(String name) {
        super(name + " the Man");
    }

    @Override
    public void attack(Entity m){
        m.damage(1);
    }

}
