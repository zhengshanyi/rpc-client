package com.zsy26.rpc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rpc-client
 * @description:
 * @author: Mr.Zheng
 * @create: 2019-06-24 22:01
 **/

@Configuration
@ComponentScan("com.zsy26.rpc")
public class SpringConfig {

    @Bean("rpcProxyClient")
    public RpcProxyClient rpcProxyClient(){
        return  new RpcProxyClient();
    }
}
