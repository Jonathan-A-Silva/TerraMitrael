package model.enums;

import java.util.List;

public enum EntityClass {

    GUERREIRO("Guerreiro", "Teste"),
    ARQUEIRO("Arqueiro", "Teste"),
    LADINO("Ladino", "Teste"),
    ALQUIMISTA("Alquimista", "Teste"),
    BERSERK("Berserk", "Teste"),
    DRUIDA("Druida", "Teste"),
    DUELISTA("Duelista", "Teste"),
    FERREIRO("Ferreiro", "Teste"),
    MAGO("Mago", "Teste"),
    NECROMANTE("Necromante", "Teste"),
    PESADELO("Pesadelo", "Teste"),
    TANK("Tank", "Teste");

    private final String nome;
    private final String descricao;

    EntityClass(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static EntityClass getClassesPorID(int id) {
        List<EntityClass> classes = List.of(EntityClass.values());
        EntityClass classe;

        try {
            classe = classes.get(id);
        } catch (Exception exception) {
            classe = null;
        }

        return classe;
    }

    public static int getId (EntityClass classe){
        int id = -1;
        List<EntityClass> classes = List.of(EntityClass.values());

        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).equals(classe)){
                id = i;
                break;
            }
        }

        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

}
