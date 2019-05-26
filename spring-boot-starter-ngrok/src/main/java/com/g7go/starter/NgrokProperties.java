package com.g7go.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Mr_Lee
 */
@ConfigurationProperties(prefix = "ngrok")
public class NgrokProperties {

    /**
     * 服务器地址
     */
    private String serverAddress = "ngrok.g7go.com";
    /**
     * 服务器端口
     */
    private int serverPort = 8092;
    /**
     * 协议
     */
    private String proto = "http";
    /**
     * 自定义子域名
     */
    private String subDomain;
    /**
     * 自定义域名
     */
    private String hostName;

    /**
     * tcp远程端口
     */
    private int remotePort;

    /**
     * 认证信息
     */
    private String httpAuth;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public String getHttpAuth() {
        return httpAuth;
    }

    public void setHttpAuth(String httpAuth) {
        this.httpAuth = httpAuth;
    }
}
