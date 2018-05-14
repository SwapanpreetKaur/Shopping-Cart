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

public class OrderDetailsImpDao implements OrderDetailsDao

{

    static orderDao od4;
    static ProductDao pd4;
    static OrderDetailsDao od5;
    static
    {

        od4=new OrderDaoImp();
        pd4=new ProductDaoImp();
        od5=new OrderDetailsImpDao();
    }



    Connection con = DBConnection.getConnection();

    public void add_orderdetail(File odfile2) throws FileNotFoundException, IOException, SQLException {

        String insert_query= "insert into orderdetails1 (id, quantity, amount, product_id,order_id) values (?,?,?,?,?)";

        File userread = odfile2;
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
        System.out.println(" Order details added  successfully");
        System.out.println();
    }

    @Override
    public void delete_orderdetail(int id) throws SQLException {

        String deleteqry = "delete from orderdetails1 where id = ?";

        PreparedStatement ps = con.prepareStatement(deleteqry);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println();
        System.out.println("Deleted orderdetails " +id+ " from orderdetail successfully");
        System.out.println();
        ps.close();

    }

    public void update_orderdetail(int id, int quantity, double price, int prod_id, int order_id) throws SQLException {

        String updateqry = "update orderdetails1 set id=?, quantity=?, amount=?, product_id=? , order_id where id = ?";

        PreparedStatement ps = con.prepareStatement(updateqry);
        ps.setInt(1,id);
        ps.setInt(2,quantity);
        ps.setDouble(3,price);
        ps.setInt(4,prod_id);
        ps.setInt(5,order_id);

        ps.executeUpdate();

        System.out.println("Updated orderdetails " +id+ " successfull");
        System.out.println();
        ps.close();

    }

    public void display_orderdetail() throws SQLException{

        Statement stmt = null;
        String dispqry = "select * from ordertails1";
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry);

        System.out.println("Display all the orderdetails table");

        while (result.next()) {
            int id = result.getInt(1);
            int quantity = result.getInt(2);
            Double amount= result.getDouble(3);
            int  product_id = result.getInt(4);
            int order_id = result.getInt(5);

            System.out.println();
            System.out.println("orderdetail Id: " +id+ "\tquantity: " +quantity+ "\tAmount: fn" +amount+ "\tProduct_id: " +product_id+ "\tOder_id: " +order_id);

        }
        result.close();
        stmt.close();
    }

    public void display_orderdetailid(int id) throws SQLException {

        Statement stmt = null;
        String dispqry1 = "select * from orderdetails1 where id =" +id;
        stmt = con.createStatement();
        ResultSet result = stmt.executeQuery(dispqry1);

        System.out.println();
        System.out.println("Displaying order details of orderid " +id);

        while (result.next()) {
            int id_1 = result.getInt(1);
            int quantity = result.getInt(2);
            String amount= result.getString(3);
            int product_id= result.getInt(4);
            int order_id = result.getInt(5);

            System.out.println();
            System.out.println("Order Id: " +id_1+ "\tquantity : " +quantity+ "\tamount: " +amount+ "\tProduct id: " +product_id+ "\tOrder id: " +order_id);

        }
        result.close();
        stmt.close();
    }
}



