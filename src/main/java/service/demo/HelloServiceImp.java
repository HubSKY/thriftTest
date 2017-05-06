package service.demo;

import org.apache.thrift.TException;

/**
 * Created by User on 2017/5/4.
 */
public class HelloServiceImp implements Hello.Iface{
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }
    @Override
    public int helloInt(int para) throws TException {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para;
    }
    @Override
    public String helloNull() throws TException {
        return null;
    }
    @Override
    public String helloString(String para) throws TException {
        System.out.println("入参：" + para);
        return "hello  " + para;
    }
    @Override
    public void helloVoid() throws TException {
        System.out.println("Hello World");
    }
}
