package course.TCP1_1203.preview;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*

TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据。
套接字：包含了IP地址和端口号的网络单位。
socket类 : 客户端套接字（也可以就叫"套接字"）。套接字是两台机器间通信的端点。
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1. 创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号。
        Socket socket = new Socket("127.0.0.1",8888);
        //2. 使用Socket对象中的方法getOutputStream() 获取网络字节输出流对象OutputStream对象
        OutputStream os = socket.getOutputStream();
        //3. 使用OutputStream对象中的方法write，给服务器发送数据
        os.write("你好，服务器".getBytes());
        //4. 使用Socket对象中的getInputStream(), 获取网络字节输入流对象InputStream对象。
        InputStream is = socket.getInputStream();
        //5. 使用InputStream对象中的read()方法，读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        // 6. 释放资源
        socket.close();
    }
}
