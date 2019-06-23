package com.zsy26.rpc;

import java.lang.reflect.Proxy;

/**
 * @program: rpc-client
 * @description:
 * @author: Mr.Zheng
 * @create: 2019-06-23 09:00
 **/
public class RpcProxyClient {
    
    
    /** 
    * @Description:  创建代理类
    * @Param: [interfaceClass, host, prot]  需要被代理的对象， ip ， 端口
    * @return: T 
    * @Author: Mr.Zheng
    * @Date: 2019/6/23 
    */ 
    public <T> T proxyClient(final Class<T> interfaceClass , final String host , final int prot ){

       return  (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[] {interfaceClass},
                new RemoteInvocationHandler(host,prot));
    }

}
