package model.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import model.entities.domain.stats.attackstats.AttackStats;

public enum Status {

    FORCA,
    AGILIDADE,
    INTELIGENCIA,
    CONHECIMENTO,
    CONSTITUICAO;

    private static final List<List<Integer>> statusBase = Arrays.asList(
            // Guerreiro
            List.of(10, 6, 3, 2, 9),
            // Arqueiro
            List.of(2, 10, 6, 8, 4),
            // Ladino
            List.of(4, 11, 6, 6, 3),
            // Alquimista
            List.of(3, 6, 8, 10, 3),
            // Berserk
            List.of(8, 8, 2, 2, 8),
            // Druida
            List.of(4, 6, 6, 10, 5),
            // Duelista
            List.of(5, 8, 5, 6, 6),
            // Ferreiro
            List.of(8, 4, 5, 7, 6),
            // Mago
            List.of(2, 3, 13, 9, 4),
            // Necromante
            List.of(3, 4, 10, 9, 8),
            // Pesadelo
            List.of(6, 10, 1, 3, 8),
            // Tank
            List.of(8, 2, 4, 4, 11)
    );

    public static Map<Status, Integer> getStatusPorClasseId(int idClasse) {
        Map<Status, Integer> statusMap = new EnumMap<>(Status.class);

        if (idClasse >= 0 && idClasse < statusBase.size()) {
            List<Integer> valores = statusBase.get(idClasse);

            for (int i = 0; i < Status.values().length; i++) {
                statusMap.put(Status.values()[i], valores.get(i));
            }
        }

        return statusMap;
    }

}
