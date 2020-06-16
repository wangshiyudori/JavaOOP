package course.TCP2_1204.multiClients2;

import java.io.*;
import java.net.Socket;

//模拟用户登录功能，客户端发送登录信息请求，服务器接收请求并回应。
public class Loginclient1 {
    public static void main(String[] args) throws IOException {

        //发送请求到服务器
        //创建一个客户端的Socket
        Socket socket = new Socket("localhost",8888);
        //通过输出流发送请求
        String info = "用户名：Kate 密码：111111";
        //将字符串打散为字节数组
        byte[] infos = info.getBytes();
        OutputStream os  = socket.getOutputStream();
        os.write(infos);

        socket.shutdownOutput();

        //接收服务器回应
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String reply;
        while ((reply = br.readLine())!=null){
            System.out.println("接收服务器信息："+reply);
        }

        //释放相应资源
        br.close();
        is.close();
        os.close();
        socket.close();



    }
}
