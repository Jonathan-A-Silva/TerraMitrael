package model.entities.domain.enemy;

import java.util.Map;

import model.entities.domain.entity.Entity;
import model.enums.Class;
import modelo.enums.Status;

public class Enemy extends Entity {

    public Enemy(String name, float life, float stamina, float mana, Class entityClass, Map<Status, Float> statusMap) {
        super(name, life, stamina, mana, entityClass, statusMap);
    }


}
