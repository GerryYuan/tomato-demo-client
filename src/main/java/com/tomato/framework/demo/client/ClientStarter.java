package com.tomato.framework.demo.client;

import com.tomato.framework.demo.facade.dto.PostDemo;
import com.tomato.framework.demo.facade.service.HelloWorld;
import com.tomato.framework.plugin.rmi.discovery.Discovery;
import com.tomato.framework.plugin.rmi.discovery.ZKDiscovery;
import java.rmi.RemoteException;

/**
 * @author Created by gerry
 * @version 1.0
 * @date 2019-06-13-22:40
 */
public class ClientStarter {
    
    public static void main(String[] args)
        throws RemoteException, InterruptedException {
//        Discovery discovery = new RmiDiscovery();
        Discovery discovery = new ZKDiscovery("127.0.0.1:2181", "rmi://127.0.0.1:18081");
        HelloWorld helloWorld = discovery.getBean(HelloWorld.class);
        System.out.println(helloWorld.hello("hello gerry!"));
        PostDemo postDemo = new PostDemo();
        postDemo.setName("gerry");
        System.out.println(helloWorld.post(postDemo));
        Thread.sleep(1000 * 40);
    }
}
