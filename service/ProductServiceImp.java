package com.shopping.service;
//import com.shopping.domain.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.shopping.dao.ProductDao;
import com.shopping.dao.ProductDaoImp;



/**
 * Created by swapanpreetkaur on 2/3/17.
 */

public class ProductServiceImp implements ProductService

{

    static ProductDao pd;
    static

    {
        pd = new ProductDaoImp();
    }

    static
    {
        if(pd==null)
        {
            pd=new ProductDaoImp();
        }

        System.out.println("calling Product ");
    }

    @Override
    public void add_product(File pfile) throws FileNotFoundException, IOException, SQLException {
        pd.add_product(pfile);
    }


    @Override
    public void delete_product(int id) throws SQLException {
        pd.delete_product(id);
    }

    @Override
    public void update_product(int id, String name, String code, double price, int stock) throws SQLException {
        pd.update_product(id,name,code,price,stock);
    }

    @Override
    public void dispaly_product_id(int id) throws SQLException {
        pd.display_productid(id);
    }




    @Override
    public void display_product ()throws SQLException{
        pd.display_product();
    }




}
