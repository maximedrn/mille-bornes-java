package com.mille_bornes.database.data.helper;

import java.util.Collection;
import java.util.List;


/**
 * An ordered array of database tables.
 * This class is used to store an ordered array of database tables.
 * The tables are sorted by their index.
 * @param <T> the type of the database table.
 */
public class OrderedDatabaseArray<T extends OrderedDatabaseTable<?>> 
    extends DatabaseArray<T> 
{

    public OrderedDatabaseArray() {
        super();
    }

    public OrderedDatabaseArray(final Collection<T> entities) {
        super(entities);
        this.sort();
    }

    /**
     * Removes the entity from the array and updates the indexes of the
     * following entities.
     * @param entity The entity to remove.
     * @return true if the entity was removed, false otherwise.
     */
    public boolean remove(final T entity) {
        final Integer startIndex = entity.getIndex();
        final boolean result = super.remove(entity);
        if (!result) return false;
        for (Integer index = startIndex + 1; index < this.size(); index++) 
            this.get(startIndex).setIndex(startIndex - 1);
        return result;
    }

    public boolean add(final T entity) {
        entity.setIndex(this.size());
        return super.add(entity);
    }

    /**
     * Sorts the array by the index of the database tables.
     */
    private void sort() {
        this.sort((a, b) -> Integer.compare(a.getIndex(), b.getIndex()));
    }

    @Override
    public T get(final int index) {
        this.sort();
        return super.get(index);
    }

    @Override
    public T getFirst() {
        this.sort();
        return super.getFirst();
    }

    @Override
    public T getLast() {
        this.sort();
        return super.getLast();
    }

    @Override
    public String toString() {
        this.sort();
        final List<String> list = this.stream().map(T::toString).toList();
        return String.join("\n", list);
    }
}
