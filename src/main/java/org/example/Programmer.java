package org.example;

public class Programmer {
    private String name;
    private String company;
    private String position;

    // Уровни позиции программиста
    private static final String[] positions = {"intern", "junior", "middle", "senior", "lead"};
    private int positionIndex; // Индекс текущей позиции в массиве positions

    public Programmer(String name, String company) {
        this.name = name;
        this.company = company;
        this.positionIndex = 0; // Начинаем с intern
        this.position = positions[positionIndex];
    }

    public String getPosition() {
        return position;
    }

    public void work() {
        if (positionIndex < positions.length - 1) {
            positionIndex++; // Переход на следующий уровень
            position = positions[positionIndex];
        } else {
            System.out.println(name + " уже достиг позиции " + position);
        }
    }


}
