package course.UDP_1204;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        byte[] receive = new byte[1024];
        //定义服务器的监听端口
        DatagramSocket socket = new DatagramSocket(9999);
        //定义接受的数据包
        DatagramPacket packet = new DatagramPacket(receive,receive.length);
        //通过连接接受数据
        socket.receive(packet);
        //通过packet.getData() 拿到接收到的字节数组
        System.out.println(new String(packet.getData()));
        packet = null;
        //关闭连接
        socket.close();
    }
}
