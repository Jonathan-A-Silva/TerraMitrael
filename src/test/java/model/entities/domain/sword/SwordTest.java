package model.entities.domain.sword;

import model.entities.domain.items.Material;
import model.entities.domain.items.Sword;
import model.entities.domain.items.Weapon;
import model.enums.Materials.Metals;
import model.enums.Materials.Woods;
import model.enums.SwordType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SwordTest {

    @Test
    void Sword() {
        Material copper = new Material(Metals.COPPER, 1);
        Material pine = new Material(Woods.Pine, 1);

        Sword sword = new Sword(SwordType.CLAYMORE, copper, copper, pine);

        Weapon test = sword;
        System.out.println("Name: " + test.getName());
        System.out.println("Description:" + test.getDescription());
        System.out.println("Damage: " + test.getAttackStats().getDamage());
        System.out.println("Speed: " + test.getAttackStats().getSpeed());
        System.out.println("Critical Chance: " + test.getAttackStats().getCriticalChance());
        System.out.println("Critical Damage: " + test.getAttackStats().getCriticalDamage());
        System.out.println("DamageTypes: " + test.getDamageType());
        System.out.println("Durability: " + test.getDurability());
        assertTrue(test.getAttackStats().getDamage() > 0);

    }

}