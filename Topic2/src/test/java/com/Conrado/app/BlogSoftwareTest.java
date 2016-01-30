package com.Conrado.app;

import org.junit.Assert.*;

/**
 * Created by Narigon on 1/27/2016.
 */
public class BlogSoftwareTest {

    BlogSoftware blog = new BlogSoftware();

    @Test
    public void PostingNewEntry(){
        blog.post("First");
        Entry test = blog.list.get(1);
        assertEquals("First",test.text);
    }

    @Test
    public void deletingEntry(){
        blog.delete(0);
        Entry test2 = blog.list.get(1);
        assertNull(test2);
    }

    @Test
    public void whenUseShowYouGetTenLastEntries(){
        blog.post("One");
        blog.post("Two");
        blog.post("Three");
        blog.post("Four");
        blog.post("Five");
        blog.post("Six");
        blog.post("Seven");
        blog.post("Eight");
        blog.post("Nine");
        blog.post("Ten");
        blog.post("Eleven");
        Entry test3 = blog.list.get(10);
        assertEquals("Two",test3.text);
    }
}
