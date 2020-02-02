package com.battybuilds.testexamples.transformer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyTransformerTest {

    private final MyTransformer transformer = new MyTransformer();

    @Test
    public void getsIndex() {
        int index = transformer.getIndex("a class=gb1 href=\"http://www.google.com/imghp?hl=en&tab=wi\">Images");
        assertEquals(8, index);
    }

    @Test
    public void getsClassName() {
        String className = transformer.scrapeClass("a class=gb1 href=\"http://www.google.com/imghp?hl=en&tab=wi\">Images");
        assertEquals("gb1", className);
    }

    @Test
    public void getsClassNameFromShortString() {
        String className = transformer.scrapeClass("b class=gb1>Search");
        assertEquals("gb1", className);
    }

    @Test
    public void splitsString() {
        String line = "a class=gb1 href=\"http://www.google.com/imghp?hl=en&tab=wi\">Images";
        String substring = line.substring(8);
        assertEquals("gb1 href=\"http://www.google.com/imghp?hl=en&tab=wi\">Images", substring);
        String className = substring.substring(0, substring.indexOf(" "));
        assertEquals("gb1", className);
    }

    @Test
    public void getsClassNameFromWierdString() {
        String className = transformer.scrapeClass("a href=\"http://www.google.com/history/optout?hl=en\" class=gb4>Web History");
        assertEquals("gb4", className);
    }
}
