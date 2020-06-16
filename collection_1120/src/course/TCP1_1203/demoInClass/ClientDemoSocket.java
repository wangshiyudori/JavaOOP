package course.TCP1_1203.demoInClass;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

//定义客户端
public class ClientDemoSocket {
    public static void main(String[] args) throws IOException {

        String content = "我爱中国。";

        //定义要发送的目标地址和端口号  本机 端口（1-65536）

        Socket socket = new Socket("localhost",9999);
        //获取发送的数据流
         OutputStream outputStream = socket.getOutputStream();
         //往数据流中写入需要发送的数据 byte[]
         outputStream.write(content.getBytes());
         outputStream.flush();
        System.out.println("传送完毕。");
         //关闭资源
         outputStream.close();
         socket.close();
    }
}
