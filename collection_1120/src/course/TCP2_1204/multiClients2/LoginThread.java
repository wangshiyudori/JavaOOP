package course.TCP2_1204.multiClients2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/*
实现了3个客户端向1个服务器发送数据。
线程类：接收客户请求，给予客户一个响应。
线程构造方法中去绑定客户的Socket（套接字：用于描述IP地址和接口）
 */
public class LoginThread extends Thread{
    private Socket socket;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获得输入流，获得用户请求
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine())!=null){
                System.out.println("客户端发来的信息："+info);
            }

            //获得客户端的IP地址
            InetAddress ia = socket.getInetAddress();
            String ip = ia.getHostAddress();
            System.out.println("相应客户端的IP："+ip);

            //给客户端一个响应
            String reply = "登录成功！";
            //通过输出流将响应发送回客户端
            OutputStream os = socket.getOutputStream();
            os.write(reply.getBytes());

            //释放相应资源
            os.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
