package com.shopping.service;

import com.shopping.dao.OrderDetailsDao;
import com.shopping.dao.OrderDetailsImpDao;
import com.shopping.dao.UserDaoImp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public class OrderDetailServiceImp implements OrderDetailService

{

    static OrderDetailsDao od2;
    static {
        od2 = new OrderDetailsImpDao();
    }

    static {
        if (od2 == null)
        {
            od2 = new OrderDetailsImpDao();
        }
        System.out.println("calling user dao");
    }


                @Override
                public void update_orderdetail(int id, int quantity, double price, int prod_id, int order_id) throws SQLException {
                    od2.update_orderdetail(id, quantity, price, prod_id, order_id);
                }

                @Override
                public void display_orderdetailid(int id) throws SQLException {
                    od2.display_orderdetailid(id);

                }

                @Override
                public void display_orderdetail() throws SQLException {
                    od2.display_orderdetail();

                }


    @Override
    public void add_orderdetail(File odfile) throws FileNotFoundException, IOException, SQLException {
        od2.add_orderdetail(odfile);
    }

    @Override
    public void delete_orderdetail(int id) throws SQLException {
        od2.delete_orderdetail(id);
    }


}