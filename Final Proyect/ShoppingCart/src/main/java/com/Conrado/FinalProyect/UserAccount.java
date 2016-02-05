package com.Conrado.FinalProyect;

/**
 * Created by Narigon on 2/5/2016.
 */
public interface UserAccount {

    public String registration(String name, String password) throws Exception;

    public String logIn(String name, String password) throws Exception;

    public String deleteAccount(String name, String password) throws Exception;
}
