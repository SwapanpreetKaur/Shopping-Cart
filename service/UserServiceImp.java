package com.shopping.service;
import com.shopping.dao.UserDao;
import com.shopping.dao.UserDaoImp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;



/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public class UserServiceImp implements UserService {

    static UserDao userDao;
    static {
        userDao= new UserDaoImp();
    }

    static
    {
        if(userDao==null)
        {
            userDao=new UserDaoImp();
        }

        System.out.println("calling user dao");
    }

    @Override
    public void add_user(File user1) throws FileNotFoundException, IOException, SQLException {
        userDao.add_user(user1);
    }


    @Override
    public void delete_user(int id) throws SQLException {
        userDao.delete_user(id);
    }

    @Override
    public void update_user(int id, String username, String firstname, String lastname, String address) throws SQLException {
        userDao.update_user(id,username,firstname,lastname,address);
    }

    @Override
    public void dispaly_userid(int id) throws SQLException {

        userDao.display_userid(id);

    }


    @Override
    public void display_user ()throws SQLException{
        userDao.display_user();
    }

    @Override
    public void display_userid(int id) throws SQLException {

    }


}
