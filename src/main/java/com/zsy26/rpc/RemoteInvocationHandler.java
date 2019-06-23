package com.zsy26.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: rpc-client
 * @description:
 * @author: Mr.Zheng
 * @create: 2019-06-23 09:05
 **/
public class RemoteInvocationHandler implements InvocationHandler {

    private String host ;

    private int port ;

    //我们还需要 调用服务的ip和端口号  修改构造方法 获取我们需要调用服务的ip 和端口
    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    //为什么要使用代理
    // 我们是客户端 客户端需要调用服务端 ， service的实现类是在服务端 而我们只有api
    //我们需要知道 我们要调用的类的 类名， 方法名， 以及参数 所以我们需要一个代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        //构建我们需要调用的远程服务信息
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParamters(args);

        //所有参数已经准备完毕 可以调用远程服务
        RpcNetTransport transport = new RpcNetTransport(host,port);
        Object result = transport.send(request);
        return result;
    }
}
