package PractiesSkillfactory_5;

public abstract class Transport {
    int fuel;
    int speed;

    Transport(int fuel, int speed) {
        this.fuel = fuel;
        this.speed = speed;
    }
    public abstract boolean canMove(int n);
    public abstract int getFuelLevel();
}
