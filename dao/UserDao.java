package com.shopping.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */

public interface UserDao {

    public void add_user(File user2) throws FileNotFoundException, IOException, SQLException;
    public void delete_user(int id) throws SQLException;
    public void update_user(int id, String user_name, String first_name, String last_name, String address) throws SQLException;
    public void display_user() throws SQLException;
    public void display_userid(int id) throws SQLException;

}

