package PractiesSkillfactory_3;

public class Teacher extends People {
    String subject;

    Teacher(String name, int age, String profession, String subject) {
        super(name, age, profession);
        this.subject = subject;
    }
    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
    public String getSubject() {
        return subject;
    }
    public String giveALesson(){
        return "The lesson was ended";
    }
}
