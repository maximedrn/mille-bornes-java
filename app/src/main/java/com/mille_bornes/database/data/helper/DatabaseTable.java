package com.mille_bornes.database.data.helper;

import com.mille_bornes.utils.RandomUtil;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


/**
 * Defines the basic structure of a database table.
 * Each row in the table has a unique ID.
 * @param <T> the type of the database table.
 */
@MappedSuperclass
public abstract class DatabaseTable<T> {

    /**
     * The unique ID of the row. Use the {@link RandomUtil} class to generate
     * the unique ID, preferred over the GenerationType.UUID strategy.
     */
    @Id
    private String id = RandomUtil.uuid();

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + "]";
    }
}
