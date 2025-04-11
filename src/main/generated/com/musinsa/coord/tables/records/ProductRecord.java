/*
 * This file is generated by jOOQ.
 */
package com.musinsa.coord.tables.records;


import com.musinsa.coord.tables.Product;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> implements Record8<Long, Long, Long, String, String, Integer, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.PRODUCT.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.BRAND_ID</code>.
     */
    public void setBrandId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.BRAND_ID</code>.
     */
    public Long getBrandId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.CATEGORY_ID</code>.
     */
    public void setCategoryId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.CATEGORY_ID</code>.
     */
    public Long getCategoryId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.NAME</code>.
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.NAME</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.CODE</code>.
     */
    public void setCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.CODE</code>.
     */
    public String getCode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.PRICE</code>.
     */
    public void setPrice(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.PRICE</code>.
     */
    public Integer getPrice() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.CREATED_AT</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.CREATED_AT</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>PUBLIC.PRODUCT.UPDATED_AT</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>PUBLIC.PRODUCT.UPDATED_AT</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, String, String, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, Long, Long, String, String, Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Product.PRODUCT.ID;
    }

    @Override
    public Field<Long> field2() {
        return Product.PRODUCT.BRAND_ID;
    }

    @Override
    public Field<Long> field3() {
        return Product.PRODUCT.CATEGORY_ID;
    }

    @Override
    public Field<String> field4() {
        return Product.PRODUCT.NAME;
    }

    @Override
    public Field<String> field5() {
        return Product.PRODUCT.CODE;
    }

    @Override
    public Field<Integer> field6() {
        return Product.PRODUCT.PRICE;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Product.PRODUCT.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return Product.PRODUCT.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getBrandId();
    }

    @Override
    public Long component3() {
        return getCategoryId();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String component5() {
        return getCode();
    }

    @Override
    public Integer component6() {
        return getPrice();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component8() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getBrandId();
    }

    @Override
    public Long value3() {
        return getCategoryId();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public String value5() {
        return getCode();
    }

    @Override
    public Integer value6() {
        return getPrice();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value8() {
        return getUpdatedAt();
    }

    @Override
    public ProductRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ProductRecord value2(Long value) {
        setBrandId(value);
        return this;
    }

    @Override
    public ProductRecord value3(Long value) {
        setCategoryId(value);
        return this;
    }

    @Override
    public ProductRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public ProductRecord value5(String value) {
        setCode(value);
        return this;
    }

    @Override
    public ProductRecord value6(Integer value) {
        setPrice(value);
        return this;
    }

    @Override
    public ProductRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ProductRecord value8(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public ProductRecord values(Long value1, Long value2, Long value3, String value4, String value5, Integer value6, LocalDateTime value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(Long id, Long brandId, Long categoryId, String name, String code, Integer price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Product.PRODUCT);

        setId(id);
        setBrandId(brandId);
        setCategoryId(categoryId);
        setName(name);
        setCode(code);
        setPrice(price);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
