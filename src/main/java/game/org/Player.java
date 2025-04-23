package game.org;

import java.util.ArrayList;
import java.util.List;

public class Player extends Humans {

    public Player(String name) {
        super(name);
    }

    // Внутренний класс Backpack
    class Backpack {
        private List<String> items;

        // Конструктор
        public Backpack() {
            this.items = new ArrayList<>();
        }

        // Метод для добавления предмета в рюкзак
        public void take(String item) {
            items.add(item);
        }

        // Метод для получения всех предметов
        public List<String> getItems() {
            return items;
        }

        // Метод для извлечения одного предмета
        public String removeItem() {
            if (items.isEmpty()) {
                return "Рюкзак пуст!";
            }
            return items.remove(items.size() - 1);
        }
    }
}
