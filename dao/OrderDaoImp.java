package com.shopping.dao;

import com.shopping.utils.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Created by swapanpreetkaur on 2/3/17.
 */

public  class OrderDaoImp implements orderDao
    {

        Connection con = DBConnection.getConnection();




    public void add_order(File odfile) throws FileNotFoundException, IOException,SQLException {

        String insert_query= "insert into orders1(order_id ,amount,date, userid) values (?,?,?,?)";

        File orderread = odfile;
        FileReader fr = new FileReader(orderread);
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
        System.out.println(" Orders added  successfully");
        System.out.println();
    }

    @Override
    public void delete_order(int id) throws SQLException {

        String deletequery = "delete from orders1 where id = ?";

        PreparedStatement ps = con.prepareStatement(deletequery);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted orders1 " +id+ " from orders successfully");
        System.out.println();
        ps.close();

    }

        @Override
        public void update_order(int id, Double amount, String date, int userId) throws SQLException {

        }

        public void update_user(int id, String date,Double amount ,int userId) throws SQLException {

        String updateqry = "update orders1 set order_id=?, amount=?, date=?, userid=? where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setInt(1,id);
        ps.setString(2,date);
        ps.setDouble(3,amount);
        ps.setInt(4,userId);
        ps.executeUpdate();

        System.out.println("Updated order " +id+ " successfull");
        System.out.println();
        ps.close();

    }

    public void display_order() throws SQLException{

        Statement stmt = null;
        String dispqry = "select * from orders1";
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry);

        System.out.println("Display all the Order table");

        while (result.next()) {
            int id = result.getInt(1);
            Double amount= result.getDouble(2);
            String date  = result.getString(3);
            int  userId = result.getInt(4);

            System.out.println();
            System.out.println("order Id: " +id+ "\t Amount: " +amount+ "\tDate: fn" + date + "\tUser_Id: " +userId);

        }
        result.close();
        stmt.close();
    }

    public void display_orderid(int id) throws SQLException {

        Statement stmt = null;
        String dispqry1 = "select * from orders1 where id =" +id;
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry1);

        System.out.println();
        System.out.println("Displaying order " +id);

        while (result.next()) {
            int id_= result.getInt(1);
            Double amount= result.getDouble(2);
            String date= result.getString(3);
            int userId = result.getInt(4);

            System.out.println();
            System.out.println("Order Id: " +id+ "\t Amount: " + amount+ "\t date: " +date+ "\t userId: " +userId);

        }
        result.close();
        stmt.close();
    }
}



