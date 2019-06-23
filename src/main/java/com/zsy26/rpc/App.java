package com.zsy26.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //需要一个代理类
        RpcProxyClient client = new RpcProxyClient();
        HelloService service = client.proxyClient(HelloService.class, "localhost", 8080);
        String result = service.sayHello("郑善艺");
        System.out.println(result);
    }
}
