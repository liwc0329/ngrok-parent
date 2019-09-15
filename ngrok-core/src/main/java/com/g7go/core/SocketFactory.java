package com.g7go.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

/**
 * 创建链接工厂
 *
 * @author Mr_Lee
 */
public class SocketFactory {

    private Logger log = LoggerFactory.getLogger(SocketFactory.class);

    private final String serverAddress;

    private final int serverPort;

    public SocketFactory(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public SSLSocket build() {
        try {
            SSLSocket socket = (SSLSocket) trustAllSocketFactory().createSocket(serverAddress, serverPort);
            socket.startHandshake();
            return socket;
        } catch (Exception e) {
            throw new NgrokClientException("Create connect failed,Please check ngrok server!", e);
        }
    }


    /**
     * 忽略证书
     *
     * @return
     * @throws Exception
     */
    public SSLSocketFactory trustAllSocketFactory() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }

                }
        };

        SSLContext sslCxt = SSLContext.getInstance("TLSv1.2");

        sslCxt.init(null, trustAllCerts, null);

        return sslCxt.getSocketFactory();
    }

}
