package com.herocheer.order;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.Charset;

/**
 * @author chenwf
 * @desc
 * @date 2020/12/22
 * @company 厦门熙重电子科技有限公司
 */
public class MyZkSerializer implements ZkSerializer {
    @Override
    public byte[] serialize(Object serializable) throws ZkMarshallingError {
        return ((String)serializable).getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        return new String(bytes, Charset.forName("UTF-8"));
    }
}
