package model.entities.domain.item;

public class Item {

    private long id;
    private String nome;
    private String description;

    public Item(String nome, String description) {
        this.nome = nome;
        this.description = description;
    }

    public Item(long id, String nome, String description) {
        this.id = id;
        this.nome = nome;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
