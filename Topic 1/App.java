package com.Conrado.topic1;

public class App
{
    String line;
    public App (String type)
    {
        line = type;
    }
    public String printMessage (){
        System.out.println (line);
        return line;
    }
}
