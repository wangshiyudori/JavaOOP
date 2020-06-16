package course.TCP2_1204.multiClients2;


import java.io.*;
import java.net.Socket;

public class LoginClient3 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8888);
        OutputStream os  = socket.getOutputStream();
        String info = "用户名：Anna  密码：555555";
        byte[] infos= info.getBytes();
        os.write(infos);
        socket.shutdownOutput();

        InputStream is  = socket.getInputStream();
        BufferedReader br =new BufferedReader(new InputStreamReader(is));
        String reply;
        while ((reply = br.readLine())!=null){
            System.out.println("接收到来自服务器的响应："+reply);
        }

        br.close();
        is.close();
        os.close();
        socket.close();
    }
}
