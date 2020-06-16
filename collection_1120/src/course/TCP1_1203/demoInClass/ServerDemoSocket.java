package course.TCP1_1203.demoInClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//定义服务器
public class ServerDemoSocket {
    public static void main(String[] args) throws IOException {

       //定义 监听端口号
        ServerSocket serverSocket = new ServerSocket(9999);
        //调用监听方法
        Socket client =null;
        client =  serverSocket.accept();
        //拿到客户端的流对象
        InputStream inputStream = client.getInputStream();
        //将客户端的内容读取到数组中

        byte[] content = new byte[1024];
        int len = inputStream.read(content);
        //输出
        System.out.println("接收到的消息："+new String(content,0,len));
        //关闭资源
        client.close();
        inputStream.close();
        serverSocket.close();
    }
}
