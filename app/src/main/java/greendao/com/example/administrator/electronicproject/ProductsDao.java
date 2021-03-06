package com.example.administrator.electronicproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PRODUCTS".
*/
public class ProductsDao extends AbstractDao<Products, Long> {

    public static final String TABLENAME = "PRODUCTS";

    /**
     * Properties of entity Products.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ProductName = new Property(1, String.class, "productName", false, "PRODUCT_NAME");
        public final static Property ProductTitle = new Property(2, String.class, "productTitle", false, "PRODUCT_TITLE");
        public final static Property ProductImgUrl = new Property(3, String.class, "productImgUrl", false, "PRODUCT_IMG_URL");
        public final static Property ProductPrice = new Property(4, String.class, "productPrice", false, "PRODUCT_PRICE");
        public final static Property ProductId = new Property(5, String.class, "productId", false, "PRODUCT_ID");
    }


    public ProductsDao(DaoConfig config) {
        super(config);
    }
    
    public ProductsDao(DaoConfig config, ProductdbDaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PRODUCTS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PRODUCT_NAME\" TEXT," + // 1: productName
                "\"PRODUCT_TITLE\" TEXT," + // 2: productTitle
                "\"PRODUCT_IMG_URL\" TEXT," + // 3: productImgUrl
                "\"PRODUCT_PRICE\" TEXT," + // 4: productPrice
                "\"PRODUCT_ID\" TEXT);"); // 5: productId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PRODUCTS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Products entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String productName = entity.getProductName();
        if (productName != null) {
            stmt.bindString(2, productName);
        }
 
        String productTitle = entity.getProductTitle();
        if (productTitle != null) {
            stmt.bindString(3, productTitle);
        }
 
        String productImgUrl = entity.getProductImgUrl();
        if (productImgUrl != null) {
            stmt.bindString(4, productImgUrl);
        }
 
        String productPrice = entity.getProductPrice();
        if (productPrice != null) {
            stmt.bindString(5, productPrice);
        }
 
        String productId = entity.getProductId();
        if (productId != null) {
            stmt.bindString(6, productId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Products entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String productName = entity.getProductName();
        if (productName != null) {
            stmt.bindString(2, productName);
        }
 
        String productTitle = entity.getProductTitle();
        if (productTitle != null) {
            stmt.bindString(3, productTitle);
        }
 
        String productImgUrl = entity.getProductImgUrl();
        if (productImgUrl != null) {
            stmt.bindString(4, productImgUrl);
        }
 
        String productPrice = entity.getProductPrice();
        if (productPrice != null) {
            stmt.bindString(5, productPrice);
        }
 
        String productId = entity.getProductId();
        if (productId != null) {
            stmt.bindString(6, productId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Products readEntity(Cursor cursor, int offset) {
        Products entity = new Products( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // productName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // productTitle
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // productImgUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // productPrice
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // productId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Products entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setProductName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setProductTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setProductImgUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setProductPrice(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProductId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Products entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Products entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Products entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
