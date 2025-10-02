package model.domain;

import java.util.Arrays;

import model.domain.items.Item;

public class Inventory {
    private Item[] slots;
    private double maxWeight;

    public Inventory(int slotCount, double maxWeight) {
        this.slots = new Item[slotCount];
        this.maxWeight = maxWeight;
    }

    public boolean addItem(Item item) {
        double newWeight = getCurrentWeight() + item.getWeight();

        if (newWeight > maxWeight) return false;

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                slots[i] = item;
                return true;
            }
        }

        return false;
    }

    public boolean removeItem(int slotIndex) {
        if (slotIndex >= 0 && slotIndex < slots.length && slots[slotIndex] != null) {
            slots[slotIndex] = null;
            return true;
        }
        return false;
    }

    public void moveItem(int fromSlot, int toSlot) {
        if (isValidSlot(fromSlot) && isValidSlot(toSlot)) {
            Item temp = slots[toSlot];
            slots[toSlot] = slots[fromSlot];
            slots[fromSlot] = temp;
        }
    }

    private boolean isValidSlot(int index) {
        return index >= 0 && index < slots.length;
    }

    public double getCurrentWeight() {
        double weight = 0;
        for (Item slot : slots) {
            if (slot != null) weight += slot.getWeight();
        }
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public Item[] getItems() {
        return Arrays.copyOf(slots, slots.length);
    }

    public Item getItemOnSlot(int slotIndex) {
        if (isValidSlot(slotIndex)) {
            return slots[slotIndex];
        }
        return null;
    }

}
