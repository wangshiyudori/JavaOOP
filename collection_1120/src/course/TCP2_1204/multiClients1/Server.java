package course.TCP2_1204.multiClients1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
       byte[] receive = new byte[1024];
       User user = null;
        //定义服务器端的监听接口
        ServerSocket serverSocket = new ServerSocket(9999);
        //通过接受获取到客户端的连接

        //获取客户端发送过来的消息
        int i = 1;
        while (true){

            Socket socket = serverSocket.accept();
            LoginThread loginThread = new LoginThread(socket);
            Thread thread1 = new Thread(loginThread);
            thread1.setName(Integer.toString(i));
            i++;
            thread1.start();
        }

    }
}
