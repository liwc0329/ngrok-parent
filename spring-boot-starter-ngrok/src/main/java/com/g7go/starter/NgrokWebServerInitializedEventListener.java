package com.g7go.starter;

import com.g7go.core.NgrokClient;
import com.g7go.core.Tunnel;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Mr_Lee
 */
public class NgrokWebServerInitializedEventListener implements ApplicationListener<WebServerInitializedEvent> {
    private final NgrokProperties ngrokProperties;

    public NgrokWebServerInitializedEventListener(NgrokProperties ngrokProperties) {
        this.ngrokProperties = ngrokProperties;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getSource().getPort();
        String serverAddress = ngrokProperties.getServerAddress();
        int serverPort = ngrokProperties.getServerPort();
        String subDomain = ngrokProperties.getSubDomain();
        String hostName = ngrokProperties.getHostName();
        String proto = ngrokProperties.getProto();
        int remotePort = ngrokProperties.getRemotePort();
        String httpAuth = ngrokProperties.getHttpAuth();

        Tunnel tunnel = new Tunnel.TunnelBuild()
                .setPort(port)
                .setProto(proto)
                .setSubDomain(subDomain)
                .setHostName(hostName)
                .setRemotePort(remotePort)
                .setHttpAuth(httpAuth)
                .build();
        new NgrokClient(serverAddress, serverPort).addTunnel(tunnel).start();
    }
}

