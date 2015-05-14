/*
 * Copyright (c) 2013-2014 Shandong Antrol Network Technology Co.Ltd. All rights reserved. 版权所有(c) 2013-2014
 * 山东蚁巡网络科技有限公司。保留所有权利。
 */
package com.corundumstudio.socketio.demo;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

public class SocketServer2 {
    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        final SocketIOServer server = new SocketIOServer(config);
        String uid = "1111";
        String namespace = String.format("/%s_%s", "msg", uid);// 构建命名空间
        SocketIONamespace chat1namespace = server.addNamespace(namespace);
        System.out.println(namespace);
        server.start();
        while (true) {
            // server.getBroadcastOperations().sendEvent("chatevent", new ChatObject("xiaopan", "helloworld"));
            chat1namespace.getBroadcastOperations().sendEvent("chatevent", new ChatObject("xiaopan", "helloworld"));
            Thread.sleep(1000);
        }
        // String uid = "1111";
        // String namespace = String.format("/%s_%s", "msg", uid);// 构建命名空间
        // SocketIONamespace chat1namespace = server.addNamespace(namespace); // 设置命名空间
        // for (int i = 0; i < 50; i++) {
        // Thread.sleep(2000);
        // chat1namespace.getBroadcastOperations().sendEvent(" ", 1); // 每次发送数字一
        // }
        // Thread.sleep(Integer.MAX_VALUE);
        // server.stop();
    }
}
