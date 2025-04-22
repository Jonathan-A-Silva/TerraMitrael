package model.enums;

public enum Class {

    Guerreiro(0),
    Arqueiro(1),
    Ladino(2),
    Alquimista(3),
    Berserk(4),
    Druida(5),
    Duelista(6),
    Ferreiro(7),
    Mago(8),
    Necromante(9),
    Pesadelo(10),
    Tank(11);

    private final int id;

    Class(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Class getClassesPorID(int id) {
        for (Class thisClass : Class.values()) {
            if (thisClass.getId() == id) {
                return thisClass;
            }
        }
        return null;
    }

}
