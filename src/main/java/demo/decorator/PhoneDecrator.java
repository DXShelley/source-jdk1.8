package demo.decorator;

public abstract  class PhoneDecrator implements  Phone{

    private Phone phone;

    public PhoneDecrator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
