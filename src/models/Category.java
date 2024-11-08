package models;

public class Category {
    private int id; // Унікальний ідентифікатор категорії
    private String name; // Назва категорії

    // Конструктор класу
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттери
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Сеттери
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Категорія{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                '}';
    }
}
