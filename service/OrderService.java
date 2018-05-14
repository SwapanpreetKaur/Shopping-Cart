package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public interface OrderService {

    public void add_order(File user11)  throws FileNotFoundException,IOException,SQLException;
    public void delete_order(int id) throws SQLException;
    public void update_order(int id, Double amount, String date,int userId)throws SQLException;
    void dispaly_order(int id) throws SQLException;

    public void display_orderid(int id) throws SQLException;

}
