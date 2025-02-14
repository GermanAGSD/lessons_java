package org.example;

// Dog
public class ClassVlozeny {
    private String name = "";
    private Foot foot = new Foot();
    private int id = -1;

    {
        name = "";
        foot = new Foot();
        Stat.counter++;
        id = ++Stat.id;
        System.out.println("Создан экземпляр класса foot");
    }
    ClassVlozeny() {}

    ClassVlozeny(String name){
        this.name = name;
    }

    void run(){
        foot.run();
    }

    public class Foot{
        void run(){
            System.out.println("Собака: " + ClassVlozeny.this.name + " бежит...");
        }
    }

    static class Stat{
        public static int counter = 0;
        public static int id = 0;
    }
}
