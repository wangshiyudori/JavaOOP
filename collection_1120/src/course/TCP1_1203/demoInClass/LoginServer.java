package course.TCP1_1203.demoInClass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args)  {
        System.out.println("服务器启动！");

        try {
            //接收客户端请求
            //创建一个ServerSocket
            ServerSocket serverSocket = new ServerSocket(8888);
            //使用accept监听并接收到此ServerSocket的连接
            Socket socket = serverSocket.accept();
            //获得输入流，获得用户的请求
            InputStream is =  socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ( (info = br.readLine())!=null ){
                System.out.println("客户端信息："+info);
            }

            //给客户端回应信息
            String reply = "登录成功！";
            byte[] replys = reply.getBytes();
            OutputStream os = socket.getOutputStream();
            os.write(replys);

            //释放相应资源
            os.close();
            br.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
