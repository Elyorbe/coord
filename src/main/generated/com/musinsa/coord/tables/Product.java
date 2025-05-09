/*
 * This file is generated by jOOQ.
 */
package com.musinsa.coord.tables;


import com.musinsa.coord.Indexes;
import com.musinsa.coord.Keys;
import com.musinsa.coord.Public;
import com.musinsa.coord.tables.records.ProductRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Product extends TableImpl<ProductRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.PRODUCT</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductRecord> getRecordType() {
        return ProductRecord.class;
    }

    /**
     * The column <code>PUBLIC.PRODUCT.ID</code>.
     */
    public final TableField<ProductRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.BRAND_ID</code>.
     */
    public final TableField<ProductRecord, Long> BRAND_ID = createField(DSL.name("BRAND_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.CATEGORY_ID</code>.
     */
    public final TableField<ProductRecord, Long> CATEGORY_ID = createField(DSL.name("CATEGORY_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.NAME</code>.
     */
    public final TableField<ProductRecord, String> NAME = createField(DSL.name("NAME"), SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.CODE</code>.
     */
    public final TableField<ProductRecord, String> CODE = createField(DSL.name("CODE"), SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.PRICE</code>.
     */
    public final TableField<ProductRecord, Integer> PRICE = createField(DSL.name("PRICE"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.CREATED_AT</code>.
     */
    public final TableField<ProductRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT.UPDATED_AT</code>.
     */
    public final TableField<ProductRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private Product(Name alias, Table<ProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private Product(Name alias, Table<ProductRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.PRODUCT</code> table reference
     */
    public Product(String alias) {
        this(DSL.name(alias), PRODUCT);
    }

    /**
     * Create an aliased <code>PUBLIC.PRODUCT</code> table reference
     */
    public Product(Name alias) {
        this(alias, PRODUCT);
    }

    /**
     * Create a <code>PUBLIC.PRODUCT</code> table reference
     */
    public Product() {
        this(DSL.name("PRODUCT"), null);
    }

    public <O extends Record> Product(Table<O> child, ForeignKey<O, ProductRecord> key) {
        super(child, key, PRODUCT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_PRODUCT_BRAND_ID, Indexes.IDX_PRODUCT_CATEGORY_ID);
    }

    @Override
    public Identity<ProductRecord, Long> getIdentity() {
        return (Identity<ProductRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProductRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_1;
    }

    @Override
    public List<UniqueKey<ProductRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.UQ_BRAND_CATEGORY);
    }

    @Override
    public List<ForeignKey<ProductRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_BRAND, Keys.FK_CATEGORY);
    }

    private transient Brand _brand;
    private transient Category _category;

    /**
     * Get the implicit join path to the <code>PUBLIC.BRAND</code> table.
     */
    public Brand brand() {
        if (_brand == null)
            _brand = new Brand(this, Keys.FK_BRAND);

        return _brand;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.CATEGORY</code> table.
     */
    public Category category() {
        if (_category == null)
            _category = new Category(this, Keys.FK_CATEGORY);

        return _category;
    }

    @Override
    public Product as(String alias) {
        return new Product(DSL.name(alias), this);
    }

    @Override
    public Product as(Name alias) {
        return new Product(alias, this);
    }

    @Override
    public Product as(Table<?> alias) {
        return new Product(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(String name) {
        return new Product(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Name name) {
        return new Product(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Table<?> name) {
        return new Product(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, String, String, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
