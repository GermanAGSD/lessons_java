package PractiesSkillfactory_3;

abstract public class People {
    String name;
    int age;
    String profession;

    People(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public abstract String getProfession();
    public abstract String getName();
    public abstract int getAge();
}
