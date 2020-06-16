package course.UDP_1204;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        String message = "发送出去的数据";

        //定义本机的IP地址
        InetAddress local = InetAddress.getByName("localhost");
        //定义socket 客户端
        DatagramSocket socket = new DatagramSocket();
        //定义发送的数据包
        //发送的内容、长度、地址、端口
        DatagramPacket datagramPacket =new DatagramPacket(message.getBytes(),message.getBytes().length,local,9999);
        //调用发送的方法
        socket.send(datagramPacket);
        System.out.println("发送成功");

        //关闭连接
        socket.close();
    }
}
