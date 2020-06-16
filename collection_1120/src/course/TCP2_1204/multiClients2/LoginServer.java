package course.TCP2_1204.multiClients2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        //创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            //使用accept监听并接收到此ServerSocket的连接
            Socket socket = serverSocket.accept();
            //创建一个和该客户端响应的线程
            LoginThread loginThread = new LoginThread(socket);
            loginThread.start();

        }


    }
}
