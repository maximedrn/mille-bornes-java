package com.mille_bornes.database.data.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Used to structure an array received by Hibernate from the database. 
 * This makes it possible to customize comparison actions between array 
 * elements (comparison between IDs) instead of an instance comparison that 
 * necessarily results in a false value: Hibernate creates new instances for 
 * each open session.
 * @param <T> the type of the database table.
 */
public class DatabaseArray<T extends DatabaseTable<?>> extends ArrayList<T> {

    /**
     * The entity manager is used to manage the persistence context of the 
     * database. It is used to persist, merge, remove, and find entities.
     */
    @PersistenceContext
    private EntityManager entityManager;

    public DatabaseArray() {
        super();
    }

    public DatabaseArray(final Collection<T> entities) {
        super(entities);
    }

    /**
     * Checks if the array contains the object. The comparison is made
     * between the IDs of the objects: "id" refers to the primary key of the
     * table.
     * 
     * @param object The object to check (should be of type T).
     * @return true if the object is in the array, false otherwise.
     */
    @Override
    public boolean contains(final Object object) {
        if (!(object instanceof DatabaseTable<?>)) return false;
        final DatabaseTable<?> objectTable = (DatabaseTable<?>) object;
        for (final T databaseTable : this)
            if (objectTable.getId().equals(databaseTable.getId())) return true;
        return false;
    }

    /**
     * Checks if the array contains all the objects in the collection. The
     * comparison is made between the IDs of the objects: "id" refers to the
     * primary key of the table.
     * 
     * @param collection The collection of objects to check 
     *        (should be of type T).
     * @return true if all the objects are in the array, false otherwise.
     */
    @Override
    public boolean containsAll(final Collection<?> collection) {
        for (final Object object : collection)
            if (!this.contains(object)) return false;
        return true;
    }
}
