package client;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;

import java.util.Scanner;

/**
 * Created by User on 2017/5/4.
 */
public class HelloServiceClient {
    /**
     * 调用 Hello 服务
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(HelloServiceClient.class.getName());

        logger.info("log4j+  hello=+++++++++++++++++++++++++++");

        try {

            // 设置调用的服务地址为本地，端口为 7911
            TTransport transport = new TSocket("172.20.104.82", 8088);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            // 调用服务的 helloVoid 方法
//            client.helloVoid();
            for (int i = 0; i < 10; i++) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入你的姓名：");
                String name = sc.nextLine();
                String resp = client.helloString(name);
                System.out.println(resp);
            }

            transport.close();
        } catch(TTransportException e){
            e.printStackTrace();
        } catch(TException e){
            e.printStackTrace();

        }
   }
}
