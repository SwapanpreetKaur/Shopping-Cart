package com.shopping.dao;
import com.shopping.utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public class UserDaoImp implements UserDao

{
    Connection con = DBConnection.getConnection();

    public void add_user(File user2) throws FileNotFoundException, IOException, SQLException {

        String insert_query= "insert into users (user_name, first_name, last_name, address) values (?,?,?,?)";

        File userread = user2;
        FileReader fr = new FileReader(userread);
        BufferedReader br = new BufferedReader(fr);

        String read;
        int i=0;
        String[] str = new String[3];

        while ((read = br.readLine()) != null) {
            str[i]=read;
            i++;
        }

        for (String s:str) {
            String[] s2 = s.split(",");

            PreparedStatement stmt = con.prepareStatement(insert_query);
            stmt.setString(1, s2[0]);
            stmt.setString(2, s2[1]);
            stmt.setString(3, s2[2]);
            stmt.setString(4, s2[3]);
            stmt.executeUpdate();
            stmt.close();

        }
        System.out.println(" User details added  successfully");
        System.out.println();
    }

    @Override
    public void delete_user(int id) throws SQLException {

        String deleteqry = "delete from users where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted user " +id+ " from user successfully");
        System.out.println();
        ps.close();

    }

    public void update_user(int id, String username, String firstname, String lastname, String address) throws SQLException {

        String updateqry = "update users set user_name=?, first_name=?, last_name=?, address=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setString(1,username);
        ps.setString(2,firstname);
        ps.setString(3,lastname);
        ps.setString(4,address);
        ps.setInt(5,id);
        ps.executeUpdate();

        System.out.println("Updated user " +id+ " successfull");
        System.out.println();
        ps.close();

    }

    public void display_user() throws SQLException{

        Statement stmt = null;
        String dispqry = "select * from users";
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry);

        System.out.println("Display all the user table");

        while (result.next()) {
            int id = result.getInt(1);
            String username = result.getString(2);
            String firstname = result.getString(3);
            String lastname = result.getString(4);
            String address = result.getString(5);

            System.out.println();
            System.out.println("User Id: " +id+ "\tUser Name: " +username+ "\tFirst Name: fn" +firstname+ "\tLast Name: " +lastname+ "\tAddress: " +address);

        }
        result.close();
        stmt.close();
    }

    public void display_userid(int id) throws SQLException {

        Statement stmt = null;
        String dispqry1 = "select * from users where id =" +id;
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry1);

        System.out.println();
        System.out.println("Displaying user details of userid " +id);

        while (result.next()) {
            int id_1 = result.getInt(1);
            String u_n = result.getString(2);
            String f_n= result.getString(3);
            String l_n = result.getString(4);
            String add1 = result.getString(5);

            System.out.println();
            System.out.println("User Id: " +id_1+ "\tUser Name: " +u_n+ "\tFirst Name: " +f_n+ "\tLast Name: " +l_n+ "\tAddress: " +add1);

        }
        result.close();
        stmt.close();
    }
}

