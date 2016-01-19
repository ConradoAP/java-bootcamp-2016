package com.Conrado.topic1;

import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest
{
    String type = "Conrad's test";
    App text = new App(type);
    @Test
    public void testPrintText()
    {
        assertEquals(type, text.printMessage());
    }

}
