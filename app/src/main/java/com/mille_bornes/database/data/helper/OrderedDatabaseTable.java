package com.mille_bornes.database.data.helper;

import com.mille_bornes.constants.Exceptions;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


/**
 * Defines the basic structure of a database table with an index.
 * Each row in the table has a unique ID and an index.
 * @param <T> the type of the database table.
 */
@MappedSuperclass
public abstract class OrderedDatabaseTable<T> extends DatabaseTable<T> {

    /**
     * Note: must be named "key_index" to avoid conflicts with the
     * reserved keyword "index" in SQL.
     */
    @Column(name = "key_index", nullable = true)
    protected Integer index;

    public OrderedDatabaseTable() {}

    /**
     * Constructor for database tables with an index.
     * @param index The index of the database table (must be positive).
     */
    public OrderedDatabaseTable(final Integer index) {
        assert index >= 0 : Exceptions.INDEX_MUST_BE_POSITIVE;
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(final Integer index) {
        assert index >= 0 : Exceptions.INDEX_MUST_BE_POSITIVE;
        this.index = index;
    }

    public void removeIndex() {
        this.index = null;
    }

    @Override
    public String toString() {
        return super.toString() + "[index=" + this.index + "]";
    }
}
