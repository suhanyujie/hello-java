package study.stream;

import java.io.*;
import java.net.URL;

public class DataStream {
    public static void main(String[] args) {
        // convertStream();
        readDataFromNetStream();
    }

    /**
     * 从网络流中读取数据
     */
    public static void readDataFromNetStream () {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new URL("https://www.baidu.com").openStream(),
        "UTF-8"
                )
            );
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 字符流和字节流的转换
     * 以字符流的形式操作字节流（文本类型的）
     */
    public static void convertStream () {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in, "UTF-8")
            );
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(System.out)
            );
            // 循环读取输入
            while (true) {
                String input = reader.readLine();
                if (input.equals("exit")) {
                    writer.flush();
                    break;
                }
                writer.write(input);
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void stream1 () {
        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
        DataOutputStream d1 = new DataOutputStream(b1);
        byte[] data1 = b1.toByteArray();
        try {
            d1.writeUTF("你猜，这是什么");
            d1.writeInt(21);
            d1.writeBoolean(true);
            d1.flush();

            // 读取时，必须按写入的顺序
            DataInputStream d2 = new DataInputStream(new ByteArrayInputStream(data1));
            String msg = d2.readUTF();
            System.out.println(msg);
        }catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
