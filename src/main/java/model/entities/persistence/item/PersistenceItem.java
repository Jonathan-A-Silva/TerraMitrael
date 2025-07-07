package model.entities.persistence.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persistence_item")
public class PersistenceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 128)
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "max_quantity", nullable = false)
    private int max_quantity;

    @Column(name = "weight", nullable = false)
    private double weight;


    public PersistenceItem() {
    }

    public PersistenceItem(String name, String description, int quantity, int max_quantity, double weight) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.max_quantity = max_quantity;
        this.weight = weight;
    }

    public PersistenceItem(long id, String name, String description, int quantity, int max_quantity, double weight) {
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
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
