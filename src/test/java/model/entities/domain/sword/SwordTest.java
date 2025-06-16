package model.entities.domain.sword;

import model.entities.domain.material.Material;
import model.entities.domain.weapon.Weapon;
import model.enums.Materials.Metals;
import model.enums.SwordType;
import model.enums.Materials.Woods;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SwordTest {

    @Test
    void Sword() {

        Material iron = new Material(Metals.IRON);
        Material pine = new Material(Woods.Pine);

        Sword sword = new Sword(SwordType.CLAYMORE, iron, iron, pine);

        Weapon test = sword;
        System.out.println("Name: " + test.getName());
        System.out.println("Description:" + test.getDescription());
        System.out.println("Damage: " + test.getAttack_damage());
        System.out.println("Speed: " + test.getAttack_speed());
        System.out.println("Critical Chance: " + test.getCritical_chance());
        System.out.println("Critical Damage: " + test.getCritical_damage());
        System.out.println("DamageTypes: " + test.getDamageType());
        assertTrue(test.getAttack_damage() > 0);

    }

}