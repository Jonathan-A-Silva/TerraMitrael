package model.enums;

import java.util.List;

public enum Race {
    HUMAN("Humano", "Teste");


    private final String nome;
    private final String descricao;

    Race(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static Race getClassesPorID(int id) {
        List<Race> races = List.of(Race.values());
        Race race;

        try {
            race = races.get(id);
        } catch (Exception exception) {
            race = null;
        }

        return race;
    }

    public static int getId (Race race){
        int id = -1;
        List<Race> races = List.of(Race.values());

        for (int i = 0; i < races.size(); i++) {
            if (races.get(i).equals(race)){
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
