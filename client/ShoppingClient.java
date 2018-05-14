package com.shopping.clent;

import com.shopping.service.OrderServiceImp;
import com.shopping.service.ProductService;
import com.shopping.service.ProductServiceImp;
import com.shopping.service.UserService;
import com.shopping.service.UserServiceImp;
import com.shopping.service.OrderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by swapanpreetkaur on 2/3/17.
 */
public class ShoppingClient {

    static UserService userService;
    static ProductService productService;
    static OrderService orderService;

    static {
        userService = new UserServiceImp();
        productService=new ProductServiceImp();
        orderService=new OrderServiceImp();

    }


    public static void main(String[] args) throws IOException, SQLException {



        int user_id, user_id2;
        String username, username1, username2, username3;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ShoppingClient s1 = new ShoppingClient();
        File user = new File("/Users/swapanpreetkaur/projects/appdirect/shoppingcart/src/com/shopping/file/filledata");
        s1.userService.add_user(user);


        System.out.println("###########################     USER DETAILS  #############################");

        System.out.println("enter user id to delete");
        user_id = Integer.parseInt(br.readLine());
        //System.out.println();
        s1.userService.delete_user(user_id);

        System.out.println("enter user id to update");
        user_id2 = Integer.parseInt(br.readLine());
        //System.out.println();

        System.out.println("enter the username");
        username = br.readLine();
       // System.out.println();

        System.out.println("enter the firstname");
        username1 = br.readLine();
        //System.out.println();

        System.out.println("enter the lastname");
        username2 = br.readLine();
        System.out.println();

        System.out.println("enter the adrress");
        username3 = br.readLine();

        s1.userService.update_user(user_id2, username,username1,username2,username3);


        System.out.println("###########################     PRODUCT  DETAILS  #############################");


        int prod_id, prod_id2,stock;
        String name, code;
        Double price;

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        ShoppingClient s2 = new ShoppingClient();
        File product = new File("/Users/swapanpreetkaur/projects/appdirect/shoppingcart/src/com/shopping/orderfile/filedata2");
        s2.productService.add_product(product);




        System.out.println("enter product id to delete");
        prod_id = Integer.parseInt(br.readLine());
        System.out.println();
        s2.productService.delete_product(prod_id);

        System.out.println("enter product id to update");
        prod_id2 = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("enter the name");
        name= br.readLine();
        System.out.println();

        System.out.println("enter the code");
        code = br.readLine();
        System.out.println();

        System.out.println("enter the price");
        price=Double.parseDouble(br.readLine());
        System.out.println();

        System.out.println("enter the stock");
        stock = Integer.parseInt(br.readLine());



        s1.productService.update_product(prod_id2,name,code,price,stock);


       /* for (int i=0;i< productlist.size());i++)
        {
            System.out.println(" product list" +productlist.get(i).getid(0 + "name" + productlist.get(i).grtname() +));
        }
*/

        System.out.println("###########################    ORDER DETAILS  #############################");


        int order_id,userId;
        String date;
        Double amount;

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        ShoppingClient sc2 = new ShoppingClient();
        File odfile = new File("/Users/swapanpreetkaur/projects/appdirect/shoppingcart/src/com/shopping/order2file/ofile2");
        s1.orderService.add_order(odfile);



        System.out.println("enter order id to delete");
        order_id = Integer.parseInt(br.readLine());
        //System.out.println();
        sc2.orderService.delete_order(user_id);


        //System.out.println();

        System.out.println("enter the date");
        date = br.readLine();
        // System.out.println();

        System.out.println("enter the userid");
        userId = Integer.parseInt(br.readLine());
        //System.out.println();

        System.out.println("enter the amount");
        amount = Double.parseDouble(br.readLine());

        sc2.orderService.update_order(order_id,amount,date,userId);







    }}


