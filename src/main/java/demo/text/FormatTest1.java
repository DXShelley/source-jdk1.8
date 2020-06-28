package demo.text;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class FormatTest1 {

    public void testDateFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println(dateFormat.format(LocalDate.now()));

        DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.CHINA);
        System.out.println(dateFormat1.format(LocalDateTime.now()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("今天是yyyy-MM-dd E hh:mm:ss，是yyyy年的第DD天，在该月是第dd天");
        System.out.println(simpleDateFormat.format(LocalDateTime.now()));


    }

    public void testNumberFormat() {

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.format(12.45);
    }


}
