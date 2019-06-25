package com.zsy26.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        //使用spring启动
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient client = context.getBean(RpcProxyClient.class);
        HelloService service = client.proxyClient(HelloService.class, "localhost", 8080);
        String result = service.sayHello("郑善艺");
        System.out.println(result);



    }
}
