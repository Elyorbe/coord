/*
 * This file is generated by jOOQ.
 */
package com.musinsa.coord.tables;


import com.musinsa.coord.Indexes;
import com.musinsa.coord.Keys;
import com.musinsa.coord.Public;
import com.musinsa.coord.tables.records.ProductVariantRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
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
public class ProductVariant extends TableImpl<ProductVariantRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.PRODUCT_VARIANT</code>
     */
    public static final ProductVariant PRODUCT_VARIANT = new ProductVariant();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductVariantRecord> getRecordType() {
        return ProductVariantRecord.class;
    }

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.ID</code>.
     */
    public final TableField<ProductVariantRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.PRODUCT_ID</code>.
     */
    public final TableField<ProductVariantRecord, Long> PRODUCT_ID = createField(DSL.name("PRODUCT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.COLOR</code>.
     */
    public final TableField<ProductVariantRecord, String> COLOR = createField(DSL.name("COLOR"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.SIZE</code>.
     */
    public final TableField<ProductVariantRecord, String> SIZE = createField(DSL.name("SIZE"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.CREATED_AT</code>.
     */
    public final TableField<ProductVariantRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>PUBLIC.PRODUCT_VARIANT.UPDATED_AT</code>.
     */
    public final TableField<ProductVariantRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private ProductVariant(Name alias, Table<ProductVariantRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProductVariant(Name alias, Table<ProductVariantRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.PRODUCT_VARIANT</code> table reference
     */
    public ProductVariant(String alias) {
        this(DSL.name(alias), PRODUCT_VARIANT);
    }

    /**
     * Create an aliased <code>PUBLIC.PRODUCT_VARIANT</code> table reference
     */
    public ProductVariant(Name alias) {
        this(alias, PRODUCT_VARIANT);
    }

    /**
     * Create a <code>PUBLIC.PRODUCT_VARIANT</code> table reference
     */
    public ProductVariant() {
        this(DSL.name("PRODUCT_VARIANT"), null);
    }

    public <O extends Record> ProductVariant(Table<O> child, ForeignKey<O, ProductVariantRecord> key) {
        super(child, key, PRODUCT_VARIANT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_VARIANT_PRODUCT_ID);
    }

    @Override
    public Identity<ProductVariantRecord, Long> getIdentity() {
        return (Identity<ProductVariantRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProductVariantRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_D;
    }

    @Override
    public List<ForeignKey<ProductVariantRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_PRODUCT);
    }

    private transient Product _product;

    /**
     * Get the implicit join path to the <code>PUBLIC.PRODUCT</code> table.
     */
    public Product product() {
        if (_product == null)
            _product = new Product(this, Keys.FK_PRODUCT);

        return _product;
    }

    @Override
    public ProductVariant as(String alias) {
        return new ProductVariant(DSL.name(alias), this);
    }

    @Override
    public ProductVariant as(Name alias) {
        return new ProductVariant(alias, this);
    }

    @Override
    public ProductVariant as(Table<?> alias) {
        return new ProductVariant(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductVariant rename(String name) {
        return new ProductVariant(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductVariant rename(Name name) {
        return new ProductVariant(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductVariant rename(Table<?> name) {
        return new ProductVariant(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super Long, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super Long, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
