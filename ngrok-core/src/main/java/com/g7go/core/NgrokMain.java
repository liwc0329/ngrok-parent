package com.g7go.core;

/**
 * 测试实例
 *
 * @author Mr_Lee
 */
public class NgrokMain {

    private static final String serverAddress = "";

    private static final int serverPort = 80;

    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel.TunnelBuild().setPort(8080).setProto("http").setSubDomain("test").build();
        new NgrokClient(serverAddress, serverPort).addTunnel(tunnel).start();
    }
}
