package demo.decorator;

public class PhoneMusic extends PhoneDecrator {
    public PhoneMusic(Phone phone) {
        super(phone);
    }

    public void musicAfterCall() {
        System.out.println("边打电话边听音乐");
    }

    @Override
    public void call() {

        super.call();
        musicAfterCall();
    }
}
