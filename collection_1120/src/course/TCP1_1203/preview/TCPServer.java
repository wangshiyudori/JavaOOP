package course.TCP1_1203.preview;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP通信的服务器端： 接收客户端的请求，读取客户端发送的数据，给客户端回写数据。
ServerSocket 类： 表示服务器端的类。

服务器端必须明确 是哪个客户端请求的服务器。  所以可以使用 accept() 方法获取到请求的客户端对象Socket.
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1. 创建服务器ServerSocket对象，并和系统要指定的端口号。
        ServerSocket server = new ServerSocket(8888);
        //2. 使用ServerSocket对象中的方法accept()，获取到请求的客户端对象Socket。
        Socket socket = server.accept();
        //3. 使用Socket对象中的方法getInputStream(),获取网络字节输入流对象InputDream对象。
        InputStream is = socket.getInputStream();
        //4. 使用InputStream对象中的方法 read(), 读取客户端发送的数据。
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        //把字节转换成字符串输出，读的对象是bytes，从0开始读，读的个数是len。
        System.out.println(new String(bytes,0,len));
        //5. 使用Socket对象中的方法getOutputStream(),获取网络字节输出流OutputStream对象。
        OutputStream os = socket.getOutputStream();
        //6. 使用OutputStream对象中的方法write，给客户端回写数据。
        os.write("收到，谢谢！".getBytes());
        //7. 释放资源（Socket, ServerSocket）。
        socket.close();
        server.close();



    }
}
