package course.TCP2_1204.multiClients1;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

//实现2个客户端向1个服务器发送数据
public class LoginThread implements Runnable {
    private User user;
    private Socket socket;

    public LoginThread( Socket socket) {
        user = null;
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream inputStream = null;
        try {

            inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            user = (User)objectInputStream.readObject();
            //接受数据到数组里面

            byte[] receive = new byte[1024];

            System.out.println();
//            String result = new String(receive);

            System.out.println("从客户端接受到的数据："+new String(receive,0,receive.toString().length()));
            //通过输出流向客户端发送
            OutputStream outputStream = socket.getOutputStream();
            String ss = "false";
            System.out.println("客户端"+user.getUserName()+user.getPwd());

            if (user.getUserName().equals("kgc") && user.getPwd().equals("123")){
                ss = "success";
            }
            System.out.println(ss);

            outputStream.write(ss.getBytes());
            outputStream.flush();

            objectInputStream.close();
            inputStream.close();
            socket.close();



        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}
