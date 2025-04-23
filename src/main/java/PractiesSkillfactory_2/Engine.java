package PractiesSkillfactory_2;

public class Engine {
    boolean isWorking = false;
    int horsepower;

    Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    public String startStopEngine(){
        if(this.isWorking){
            this.isWorking = false;
            return "engine was stopped";
        }else {
            isWorking = true;
            return "engine was started";
        }
    }
}
