package model.enums;

import java.util.List;

import model.enums.body.Body;

public enum Race {
    HUMAN("Humano", "teste", Body.HUMANOID),
    ELF("Elfo", "Teste", Body.HUMANOID),
    ORK("Ork", "teste", Body.HUMANOID);

    private final String name;
    private final String description;
    private final Body body;

    Race(String name, String description, Body body) {
        this.name = name;
        this.description = description;
        this.body = body;
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Body getBody() {
        return body;
    }

}
