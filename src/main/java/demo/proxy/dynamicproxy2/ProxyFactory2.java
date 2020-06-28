package demo.proxy.dynamicproxy2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
使用流行的Cglib实现动态代理，被代理类不需要实现接口
 */
public class ProxyFactory2  implements MethodInterceptor {

    private  Object target;

    public ProxyFactory2(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        //1. 工具类
        Enhancer en = new Enhancer();
        //2. 设置父类
        en.setSuperclass(target.getClass());
        //3. 设置回调函数
        en.setCallback(this);
        //4. 创建子类（代理对象）
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------开始事务----------");
        Object returnValue = method.invoke(target,objects);
        System.out.println("---------结束事务----------");
        return returnValue;
    }
}
