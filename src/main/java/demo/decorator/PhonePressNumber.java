package demo.decorator;

public class PhonePressNumber extends PhoneDecrator {
    public PhonePressNumber(Phone phone) {
        super(phone);
    }

    public void pressNumberBeforeCall(){
        System.out.println("先按电话号码");
    }

    @Override
    public void call() {

        pressNumberBeforeCall();
        super.call();
    }
}
