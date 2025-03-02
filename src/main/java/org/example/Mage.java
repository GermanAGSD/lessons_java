package org.example;


public class Mage {
    private String name;
    private int level;
    private int damage;
    private String type;

    public Mage(String name, int level, int damage, String type) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.type = type.toLowerCase();
    }

    public String getInfo() {
        System.out.println(name + " " + level + " " + damage + " " + type);
        return name + " " + level + " " + damage + " " + type;
    }

    public String fight(Mage mage) {
        if (this.type.equals(mage.type)) {
            // Если магия одинаковая, сравниваем уровень
            if (this.level > mage.level) {
                return this.name;
            } else if (this.level < mage.level) {
                return mage.name;
            }
            // Если уровни одинаковые, сравниваем урон
            if (this.damage > mage.damage) {
                return this.name;
            } else if (this.damage < mage.damage) {
                return mage.name;
            }
            return "draw"; // Если все параметры равны
        }

        // Определяем победителя по стихиям
        if ((this.type.equals("fire") && mage.type.equals("ice")) ||
                (this.type.equals("ice") && mage.type.equals("earth")) ||
                (this.type.equals("earth") && mage.type.equals("fire"))) {
            return this.name;
        } else {
            return mage.name;
        }
    }
}
