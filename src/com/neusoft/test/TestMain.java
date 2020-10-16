package com.neusoft.test;

import com.neusoft.util.DBUtils;
import org.junit.Test;

import java.sql.SQLException;

public class TestMain {

    @Test
    public void testConn(){
        try {
            System.out.println(DBUtils.getConn());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
