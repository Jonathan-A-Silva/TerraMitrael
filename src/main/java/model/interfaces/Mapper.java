package model.interfaces;

public interface Mapper <D, E> {
    D toDomain(E entity);
    E toEntity(D domain);
}