package course.TCP1_1203.demoInClass;

import java.io.*;
import java.net.Socket;

//模拟用户登录的功能，客户端发送登录信息请求，服务端接受请求并回应。 (先写客户端。 先跑服务器。)
public class LoginClient {
    public static void main(String[] args) {
        System.out.println("客户端启动");

        try {
            //发送请求到服务器
            //创建一个客户端的socket
            Socket socket = new Socket("localhost",8888);
            //通过输出流发送请求
            String info ="用户名：Tom，密码：123456";
            //将字符串打散为字节数组
            byte[] infos = info.getBytes();
            OutputStream os = socket.getOutputStream();
            os.write(infos);

            socket.shutdownOutput();

            //接收服务器回应
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String reply;
            while ((reply=br.readLine()) != null){
                System.out.println("服务器信息："+reply);
            }

            //释放相应资源
            br.close();
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
