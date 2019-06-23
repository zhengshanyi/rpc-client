package com.zsy26.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @program: rpc-client
 * @description:
 * @author: Mr.Zheng
 * @create: 2019-06-23 09:28
 **/
public class RpcNetTransport {

    private String host;

    private int port ;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }
    //向服务端请求服务
    /** 
    * @Description:
    * @Param: [rpcRequest]  请求服务封装参数
    * @return: java.lang.Object 
    * @Author: Mr.Zheng
    * @Date: 2019/6/23 
    */ 
    public Object send(RpcRequest rpcRequest){
        //构建网络连接
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Object result = null;
        try {

            //发起请求
            socket = new Socket(host,port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            //写入请求
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            //获取返回数据
            objectInputStream =  new ObjectInputStream(socket.getInputStream());
            result = objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
