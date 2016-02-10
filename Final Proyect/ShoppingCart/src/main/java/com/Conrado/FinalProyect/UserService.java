package com.Conrado.FinalProyect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.EnableAutoConfiguration;

/**
 * Created by Narigon on 2/5/2016.
 */
@RestController
@EnableAutoConfiguration
public class UserService {

    UserAccount userAccount;
    ShoppingCart shoppingCart;
    boolean LogIn;
    String username;

    public UserService(){
        LogIn = false;
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public void register(@RequestParam(value="username")String username, @RequestParam(value="password")String password){
        String check = userAccount.registration(username, password);
        System.out.println(check);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public void logIn(@RequestParam(value="username")String username, @RequestParam(value="password")String password){
        String check = userAccount.logIn(username, password);
        System.out.println(check);
        if (check.equals("Log In Success")){
            LogIn = true;
            this.username = username;
        }
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    public void deleteAccount(@RequestParam(value="username")String username, @RequestParam(value="password")String password){
        String check = userAccount.deleteAccount(username, password);
        System.out.println(check);
    }

    @RequestMapping(value="/cart", method=RequestMethod.GET)
    public void getCart(){
        shoppingCart.loadItems();
    }

    @RequestMapping(value="/cart", method=RequestMethod.DELETE)
    public void dropCart(){
        if (LogIn) {
            shoppingCart.newCart(username);
        }
    }

    @RequestMapping(value="/cart/findbyname")
    public void findByName(@RequestParam(value="item") String ItemName){
        shoppingCart.findByName(ItemName);
    }

    @RequestMapping(value="/cart/findbycategory")
    public void findByCategory(@RequestParam(value="category")String category){
        shoppingCart.findByCategory(category);
    }

    @RequestMapping(value="/usercart/items", method=RequestMethod.GET)
    public void getUserCart(){
        if (LogIn) {
            shoppingCart.showCart(username);
        }
    }

    @RequestMapping(value="/usercart/items", method=RequestMethod.PUT)
    public void addItem(@RequestParam(value="item_id")int ItemID, @RequestParam(value="quantity")int Quantity){
        if (LogIn) {
            shoppingCart.selectItems(username, ItemID, Quantity);
        }
    }

    @RequestMapping(value="/usercart/items", method=RequestMethod.DELETE)
    public void dropItem(@RequestParam(value="item_id")int ItemID, @RequestParam(value="quantity")int Quantity){
        if (LogIn) {
            shoppingCart.cancelSelection(username, ItemID, Quantity);
        }
    }

    @RequestMapping(value="/usercart/buy")
    public double endPurchase(){
        if (LogIn) {
            return shoppingCart.endPurchase(username);
        } else {
            return 0;
        }
    }
}
