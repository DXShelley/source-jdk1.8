package demo.text;

import java.text.*;
import java.util.Date;
import java.util.Locale;

public class FormatTest {

    private final Date date = new Date();

    public void testDateFormat() {

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println(dateFormat.format(date));

        DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        System.out.println(dateFormat1.format(date));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("今天是yyyy-MM-dd E hh:mm:ss，是yyyy年的第DD天，在该月是第dd天");
        System.out.println(simpleDateFormat.format(date));
        System.out.println("helloworld");
    }

    public void testNumberFormat() {

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(12.45));
    }

    public void testDecimalFormat() {
        DecimalFormat format1 = new DecimalFormat("#\u2030");
        System.out.println(format1.format(0.3345));// 输出334‰

        DecimalFormat format2 = new DecimalFormat("##.##");
        System.out.println(format2.format(12.345));// 输出12.35

        DecimalFormat format3 = new DecimalFormat("0000.00");
        System.out.println(format3.format(12.345));// 输出0012.35

        DecimalFormat format4 = new DecimalFormat("#.##%");
        System.out.println(format4.format(12.345));// 输出1234.5%
        format4.format(12.345);
        if (1 == 1) {

        }

        System.out.println("helloworld");

    }

    public void testMessageFormat() {
        /**
         * 这是源码注释中的一个例子 在这个例子中静态方法format第一个参数是字符串类型的，
         * 即模式字符串，第二个参数是个可变参数，实际上就是一个Object类型的数组。
         * 在模式字符串中使用"{}"标识一个FormatElement。"{}"中的ArgumentIndex对应Object数组中响应索引处的值。
         */
        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.", planet, new Date(), event);
        System.out.println(result);
        // 输出：At 20:39:15 on 2015-12-11, there was a disturbance in the Force on planet
        // 7.
    }

    public void testStringFormat() {

        String result1 = String.format("小明今年%d岁,他住在%s,他的月工资有%.2f", 25, "北京市", 6633.435);
        System.out.println(result1);// 输出:小明今年25岁,他住在北京市,他的月工资有6633.44
        /*****************************************************/
        double num = 123.4567899;
        String result2 = String.format("%e", num);
        System.out.println(result2);// 输出：1.234568e+02
    }

}
