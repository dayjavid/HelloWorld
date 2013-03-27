package com.nfjs.helloworld.test;

import java.util.List;

import com.nfjs.helloworld.db.DbAdapter;

import android.test.AndroidTestCase;

public class DbAdapterTest extends AndroidTestCase {
    private DbAdapter dba;
    
    public void setUp() {
        dba = new DbAdapter(getContext());
        dba.open();
    }

    public void testInsertAndGetAllNames() {
        dba.insertName("Fred");
        dba.insertName("Barney");
        List<String> names = dba.getAllNames();
        assertTrue(names.contains("Fred"));
        assertTrue(names.contains("Barney"));
        dba.deleteAllNames();
    }

    public void testDeleteName() {
        dba.insertName("Fred");
        assertEquals(1, dba.getAllNames().size());
        
        dba.deleteName("Fred");
        assertEquals(0, dba.getAllNames().size());
    }

}
