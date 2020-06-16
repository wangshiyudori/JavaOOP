package course.TCP2_1204.multiClients2;

import java.io.*;
import java.net.Socket;

public class LoginClient2 {
    public static void main(String[] args) throws IOException {

        Socket socket =new Socket("localhost",8888);
        String info="用户名：Tom  密码：333333";
        byte[] infos = info.getBytes();
        OutputStream os  = socket.getOutputStream();
        os.write(infos);
        socket.shutdownOutput();

        InputStream is  = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String reply;
        while ((reply = br.readLine())!=null ){
            System.out.println("接收服务器信息："+reply);
        }

        br.close();
        is.close();
        os.close();
        socket.close();

    }
}
