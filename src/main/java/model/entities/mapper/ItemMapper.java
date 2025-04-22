package model.entities.mapper;

import model.entities.domain.item.Item;
import model.entities.persistence.item.PersistenceItem;
import model.interfaces.Mapper;

public class ItemMapper implements Mapper<Item, PersistenceItem> {

    @Override
    public Item toDomain(PersistenceItem entity) {
        return new Item(
                entity.getId(),
                entity.getNome(),
                entity.getDescription()
        );
    }

    @Override
    public PersistenceItem toEntity(Item item) {
        return new PersistenceItem(
                item.getId(),
                item.getNome(),
                item.getDescription()
        );
    }
}
