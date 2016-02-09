package com.Conrado.FinalProyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Created by Narigon on 2/3/2016.
 */
public class UserAccountImp implements UserAccount {

    @Override
    public String registration(String name, String password) {
        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/shopping_cart?" + "user=ConradoAP&password=Kenny0309");
        PreparedStatement ps = connection.prepareStatement("select count(a.Username) from accounts a where a.Username=?");
            ps.setString(1,name);
            ResultSet result = ps.executeQuery();
            int count = result.getInt(1);
            if (count == 0) {
                PreparedStatement ps1 = connection.prepareStatement("insert into accounts values (default, ?, ?)");
                ps1.setString(1,name);
                ps1.setString(2,password);
                return "Registration Success";
                PreparedStatement ps2 = connection.prepareStatement("create table ? (Item_ID int,Item varchar(20), Quantity int)");
                ps2.setString(1,name);
                ps2.executeQuery();
            } else {
                return "Username Already Exists";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception Error";
        }
    }

    @Override
    public String logIn(String name, String password) {
        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/accounts?" + "user=ConradoAP&password=Kenny0309");
        PreparedStatement ps = connection.prepareStatement("select count(a.Username) from accounts a where a.Username=?");
        ps.setString(1,name);
        ResultSet result = ps.executeQuery();
        int count = result.getInt(1);
        if (count == 1){
            PreparedStatement ps3 = connection.prepareStatement("select a.Password from accounts a where a.Username=?");
            ps3.setString(1,name);
            ResultSet user = ps3.executeQuery();
            String pass = user.getString("Password");
            if (pass.equals(password)) {
                return "Log In Success";
            } else {
                return "Wrong Password";
            }
        } else {
            return "Account Doesn't Exists";
        }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception Error";
        }
    }

    @Override
    public String deleteAccount(String name, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/accounts?" + "user=ConradoAP&password=Kenny0309");
            PreparedStatement ps = connection.prepareStatement("select count(a.Username) from accounts a where a.Username=?");
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            int count = result.getInt(1);
            if (count == 1) {
                PreparedStatement ps3 = connection.prepareStatement("select a.Password from accounts a where a.Username=?");
                ps3.setString(1, name);
                ResultSet user = ps3.executeQuery();
                String pass = user.getString("Password");
                if (pass.equals(password)) {
                    PreparedStatement ps4 = connection.prepareStatement("delete from accounts a where a.Username=?");
                    ps4.setString(1, name);
                    ps4.executeQuery();
                    return "Account Deleted";
                    PreparedStatement ps5 = connection.prepareStatement("drop table ?");
                    ps5.setString(1,name);
                } else {
                    return "Wrong Password";
                }
            } else {
                return "Account Doesn't Exists";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception Error";
        }
    }
}
