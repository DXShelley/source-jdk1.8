package demo.decorator;

public class CallTest {

    public static void main(String[] args) {
        Phone phoneX = new IPhoneX();
        System.out.println("普通打电话");
        phoneX.call();
        //phoneX = new PhonePressNumber(phoneX);
        System.out.println("打电话前先按电话号码");
        phoneX.call();

        phoneX = new PhoneMusic(phoneX);

        System.out.println("打通后，边打电话边听音乐");
        phoneX.call();

        System.out.println();

        //最终形式 类似java流
        Phone phone = new PhoneMusic(new PhonePressNumber(new IPhoneX()));
        phone.call();

    }
}
