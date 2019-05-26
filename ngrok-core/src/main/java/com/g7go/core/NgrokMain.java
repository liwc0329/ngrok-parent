package com.g7go.core;

/**
 * @author Mr_Lee
 */
public class NgrokMain {

    private static final String serverAddress = "ngrok.g7go.com";
    private static final int serverPort = 8092;

    public static void main(String[] args) throws Exception {
        Tunnel tunnel = new Tunnel.TunnelBuild()
                .setPort(8080).setProto("http").setSubDomain("test").build();
        new NgrokClient(serverAddress, serverPort).addTunnel(tunnel).start();
    }
}
