package model.entities.domain.items;

public class Item {

    private long id;
    private String name;
    private String description;
    private int quantity;
    private int max_quantity;
    private double weight;

    public Item(String name, String description, int quantity, int max_quantity, double weight) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.max_quantity = max_quantity;
        this.weight = weight;
    }

    public Item(long id, String name, String description, int quantity, int max_quantity, double weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.max_quantity = max_quantity;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMax_quantity() {
        return max_quantity;
    }

    public void setMax_quantity(int max_quantity) {
        this.max_quantity = max_quantity;
    }

    public double getWeight() {
        return quantity * weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
