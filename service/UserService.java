package com.shopping.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public interface UserService{

public void add_user(File user11)  throws FileNotFoundException,IOException,SQLException;
public void delete_user(int id) throws SQLException;
public void update_user(int id,String username,String firstname,String lastname,String address)throws SQLException;

    void dispaly_userid(int id) throws SQLException;

    void display_user() throws SQLException;
 public void display_userid(int id) throws SQLException;


}



