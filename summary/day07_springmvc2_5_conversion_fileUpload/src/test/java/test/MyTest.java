package test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {

    @Test
    public void myTest(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = null;
            try {
                parse = simpleDateFormat.parse("1996-12-28");
                System.out.println(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
    }
}
