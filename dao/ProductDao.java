package com.shopping.dao;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by swapanpreetkaur on 2/3/17.
 */

public interface ProductDao {

    public void add_product(File pfile) throws FileNotFoundException, IOException, SQLException;
    public void delete_product(int id) throws SQLException;
    public void update_product(int id, String name, String code, double price,int stock) throws SQLException;
    public void display_product() throws SQLException;
    public void display_productid(int id) throws SQLException;

}
