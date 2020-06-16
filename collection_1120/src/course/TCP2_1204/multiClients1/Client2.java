package course.TCP2_1204.multiClients1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        User user = new User("kgc","345");

//        String user = "{name : kgc, pwd:123 }";


        //建立与服务器端的连接
        Socket socket = new Socket("localhost",9999);
        //通过连接创建输出流对象


        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        //发送消息给服务器端

//        outputStream.write(user.getBytes());
        outputStream.flush();
        System.out.println("消息已发送完毕");

        InputStream inputStream =socket.getInputStream();

        byte[] result = new byte[1024];
        int len = inputStream.read(result);
        String ss = new String(result,0,len);
        System.out.println("接收到的结果："+ss);

        objectOutputStream.close();
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
