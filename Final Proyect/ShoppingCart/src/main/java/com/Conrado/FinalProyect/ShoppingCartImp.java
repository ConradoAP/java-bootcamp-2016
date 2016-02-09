package com.Conrado.FinalProyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Created by Narigon on 2/5/2016.
 */
public class ShoppingCartImp implements ShoppingCart {

    @Override
    public void loadItems() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select * from items");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String item = rs.getString(2);
                double price = rs.getDouble(3);
                String category = rs.getString(4);
                System.out.println(category + " - " + id + ":" + item + " - $" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findByName(String itemName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select * from items where Item=?");
            ps.setString(1,itemName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String item = rs.getString(2);
                double price = rs.getDouble(3);
                String category = rs.getString(4);
                System.out.println(category + " - " + id + ":" + item + " - $" + price);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void findByCategory(String itemCategory) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select * from items where Category=?");
            ps.setString(1,itemCategory);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String item = rs.getString(2);
                double price = rs.getDouble(3);
                String category = rs.getString(4);
                System.out.println(category + " - " + id + ":" + item + " - $" + price);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showCart(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select * from ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String item = rs.getString(2);
                int quantity = rs.getInt(3);
                System.out.println(id + ":" + item + " - $" + quantity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectItems(String username, int Item_ID, int Quantity) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps1 = connection.prepareStatement("select * from items where Item_ID=?");
            ps1.setInt(1,Item_ID);
            ResultSet items = ps1.executeQuery();
            String itemName = items.getString("Item");
            PreparedStatement ps4 = connection.prepareStatement("select count(Item_ID) from ?  where Item_ID=?");
            ps4.setString(1,username);
            ps4.setInt(2,Item_ID);
            ResultSet exists = ps4.executeQuery();
            int existRow = exists.getInt(1);
            if (existRow == 1) {
                PreparedStatement ps2 = connection.prepareStatement("select * from ? where Item_ID=?");
                ps2.setString(1,username);
                ps2.setInt(2,Item_ID);
                ResultSet userCart = ps2.executeQuery();
                int q = userCart.getInt("Quantity");
                q = q + Quantity;
                PreparedStatement ps3 = connection.prepareStatement("update ? set Quantity=? where Item_ID=?");
                ps3.setString(1,username);
                ps3.setInt(2,q);
                ps3.setInt(3,Item_ID);
                ps3.executeQuery();
            } else {
                PreparedStatement ps3 = connection.prepareStatement("insert into ´?´ (´Item_ID´,´Item´,´Quantity´) values ('?','?','?')");
                ps3.setString(1,username);
                ps3.setInt(2,Item_ID);
                ps3.setString(3,itemName);
                ps3.setInt(4,Quantity);
                ps3.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean cancelSelection(String username, int Item_ID, int Quantity) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps2 = connection.prepareStatement("select * from ? where Item_ID=?");
            ps2.setString(1,username);
            ps2.setInt(2,Item_ID);
            ResultSet userCart = ps2.executeQuery();
            int q = userCart.getInt("Quantity");
            if (q >= Quantity) {
                q = q - Quantity;
                PreparedStatement ps3 = connection.prepareStatement("update ? set Quantity=? where Item_ID=?");
                ps3.setString(1, username);
                ps3.setInt(2, q);
                ps3.setInt(3, Item_ID);
                ps3.executeQuery();
                return true;
            } else {
                System.out.println("Quantity Value is too Big");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void newCart(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("truncate table ?");
            ps.setString(1,username);
            ps.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public double endPurchase(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select u.Item_ID, i.Item_ID, i.Price from ? u, Items i where u.Item_ID=i.Item_ID");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            double total = 0;
            while (rs.next()){
                double add = rs.getDouble("Price");
                total = total + add;
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
