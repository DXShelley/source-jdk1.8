package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 等凉菜
        Callable ca1=new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return "等凉菜";
            }
        };

        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        //等包子
        Callable ca2=new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return "等包子";
            }
        };


        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
