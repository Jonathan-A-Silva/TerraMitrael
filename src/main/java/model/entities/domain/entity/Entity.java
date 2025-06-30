package model.entities.domain.entity;

import java.util.HashMap;
import java.util.Map;

import model.enums.Class;
import model.enums.Race;
import model.enums.Status;

public class Entity {

    private Long id;

    private String name;



    private Class entityClass;

    private Race race;

    private Map<Status, Float> status = new HashMap<>();


}
