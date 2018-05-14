package com.shopping.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public interface OrderDetailsDao {

    public void add_orderdetail(File odfile) throws FileNotFoundException, IOException, SQLException;
    public void delete_orderdetail(int id) throws SQLException;
    public void update_orderdetail(int id, int quantity, double price,int prod_id,int order_id) throws SQLException;
    public void display_orderdetail() throws SQLException;
    public void display_orderdetailid(int id) throws SQLException;

}
