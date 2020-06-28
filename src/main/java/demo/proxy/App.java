package demo.proxy;

import demo.proxy.dynamicproxy1.ProxyFactory;
import demo.proxy.dynamicproxy2.ProxyFactory2;
import demo.proxy.staticproxy.IUserDao;
import demo.proxy.staticproxy.UserDao;
import demo.proxy.staticproxy.UserDaoProxy;

import java.lang.reflect.Proxy;

public class App {

    // 静态代理
   /* public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();

    }*/

    // 使用java自带的reflect实现的动态代理
    /*public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        IUserDao proxyUserDao = (IUserDao) proxyFactory.getProxyInstance();
        proxyUserDao.save();

    }*/

    // 使用主流的Cglib实现动态代理，被代理类不需要实现接口

    public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        IUserDao proxyUserDao = (IUserDao) new ProxyFactory2(userDao).getInstance();
        proxyUserDao.save();
    }

}
