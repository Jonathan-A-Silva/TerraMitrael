package model.enums;

import java.util.List;

public enum Race {
    HUMAN("Humano", "Os humanos são a raça mais adaptável e ambiciosa do mundo conhecido. Em meio a reinos ancestrais, castelos flutuantes e cidades movidas a cristais mágicos, eles se destacam por sua criatividade, curiosidade e capacidade de evolução constante. Embora não possuam as vidas longas dos elfos nem a força bruta dos orcs, os humanos compensam com engenhosidade e um espírito incansável de descoberta."),
    ELF("Elfo", "Antigos como as florestas e refinados como o cristal, os elfos são uma raça marcada pela elegância, sabedoria e conexão profunda com a magia primordial. No entanto, com o avanço da tecnologia, muitos se dividiram entre a preservação do passado e a adaptação ao futuro. Em um mundo onde torres arcanas competem com máquinas de guerra a vapor, os elfos enfrentam o desafio de manter sua identidade em meio ao progresso."),
    ORK("Ork", "teste");



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

    public static int getId(Race race) {
        int id = -1;
        List<Race> races = List.of(Race.values());

        for (int i = 0; i < races.size(); i++) {
            if (races.get(i).equals(race)) {
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
