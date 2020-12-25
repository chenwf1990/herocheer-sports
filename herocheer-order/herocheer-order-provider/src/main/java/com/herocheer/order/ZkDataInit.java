package com.herocheer.order;

import com.alibaba.fastjson.JSONObject;
import io.seata.config.zk.ZookeeperConfiguration;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/22
 * @company 厦门熙重电子科技有限公司
 */
public class ZkDataInit {
    private static volatile ZkClient zkClient;

    public static void main(String[] args) {

        if (zkClient == null) {
            zkClient = new ZkClient("127.0.0.1:2181", 6000, 2000);
        }
        if (!zkClient.exists("/seata")) {
            zkClient.createPersistent("/seata", true);
        }
        //获取key对应的value值
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        // 使用properties对象加载输入流
        try {
            zkClient.setZkSerializer(new MyZkSerializer());
//            File file = ResourceUtils.getFile("classpath:zk-config.properties");
            File file = new File("D:\\chenwf\\work\\seata-server-1.4.0\\seata\\conf\\config.txt");
            InputStream in = new FileInputStream(file);
            properties.load(in);
            Set<Object> keys = properties.keySet();//返回属性key的集合
            for (Object key : keys) {
                System.out.println("====:"+properties.get(key).toString());
                boolean b = putConfig(key.toString(), properties.get(key).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dataId
     * @param content
     * @return
     */
    public static boolean putConfig(final String dataId, final String content) throws UnsupportedEncodingException {
        Boolean flag = false;
        String path = "/seata/" + dataId;
        System.out.println(dataId);
        System.out.println(content);
//        //利用getBytes将unicode字符串转成UTF-8格式的字节数组
//        byte[] utf8Bytes = content.getBytes("UTF-8");
//        //然后用utf-8 对这个字节数组解码成新的字符串
//        String utf8Str = new String(utf8Bytes, "UTF-8");
//        zkClient.delete(path);
        byte[] tmpbyte=content.getBytes("ISO8859_1");
        String str =new String(tmpbyte);
        if (!zkClient.exists(path)) {
            zkClient.create(path, str, CreateMode.PERSISTENT);
            flag = true;
        } else {
            zkClient.writeData(path, str);
            flag = true;
        }
        return flag;


    }
}
