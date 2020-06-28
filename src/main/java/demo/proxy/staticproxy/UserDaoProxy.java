package demo.proxy.staticproxy;

public class UserDaoProxy {

    private IUserDao userDao;

    public UserDaoProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    public  void save(){
        System.out.println("-------开始事务-------");
        userDao.save();
        System.out.println("-------结束事务-------");
    }
}
