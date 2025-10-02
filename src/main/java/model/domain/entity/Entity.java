package model.domain.entity;

import model.domain.stats.CombatStatus;
import model.domain.stats.EntityStatus;
import model.enums.EntityClass;
import model.enums.Race;

public class Entity {

    private Long id;

    private String name;

    private Race race;

    private EntityClass entityClass;

    private EntityStatus entityStatus;

    private CombatStatus combatStatus;

    private double weight;

}
