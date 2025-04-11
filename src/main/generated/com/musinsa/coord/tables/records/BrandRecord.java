/*
 * This file is generated by jOOQ.
 */
package com.musinsa.coord.tables.records;


import com.musinsa.coord.tables.Brand;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BrandRecord extends UpdatableRecordImpl<BrandRecord> implements Record4<Long, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.BRAND.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.BRAND.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.BRAND.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.BRAND.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.BRAND.CREATED_AT</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.BRAND.CREATED_AT</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>PUBLIC.BRAND.UPDATED_AT</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.BRAND.UPDATED_AT</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Brand.BRAND.ID;
    }

    @Override
    public Field<String> field2() {
        return Brand.BRAND.NAME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Brand.BRAND.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Brand.BRAND.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component4() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value4() {
        return getUpdatedAt();
    }

    @Override
    public BrandRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BrandRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BrandRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public BrandRecord value4(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public BrandRecord values(Long value1, String value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BrandRecord
     */
    public BrandRecord() {
        super(Brand.BRAND);
    }

    /**
     * Create a detached, initialised BrandRecord
     */
    public BrandRecord(Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Brand.BRAND);

        setId(id);
        setName(name);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
