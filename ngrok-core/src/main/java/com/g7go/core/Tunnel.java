package com.g7go.core;

import org.apache.commons.lang.StringUtils;

/**
 * 通道配置
 *
 * @author Mr_Lee
 */
public class Tunnel {
    /**
     * 端口
     */
    private int port;

    /**
     * 协议
     */
    private String proto;

    /**
     * 子域名
     */
    private String subDomain;

    /**
     * 域名
     */
    private String hostName;

    /**
     * tcp远程端口
     */
    private int remotePort;

    /**
     * 授权
     */
    private String httpAuth;


    private Tunnel() {

    }

    private Tunnel(int port, String proto, String subDomain, String hostname,
                   int remotePort, String httpAuth) {
        this.port = port;
        this.proto = proto;
        this.subDomain = subDomain;
        this.hostName = hostName;
        this.remotePort = remotePort;
        this.httpAuth = httpAuth;
    }

    public static class TunnelBuild {
        private int port;
        private String proto;
        private String subDomain;
        private String hostName;
        private int remotePort;
        private String httpAuth;

        public Tunnel build() {
            if (port == 0) {
                throw new IllegalArgumentException("port can not be zone");
            }
            if (StringUtils.isBlank(proto)) {
                throw new IllegalArgumentException("Proto can not be empty");
            }
            return new Tunnel(port, proto, subDomain, hostName, remotePort, httpAuth);
        }

        public TunnelBuild setPort(int port) {
            this.port = port;
            return this;
        }

        public TunnelBuild setHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public TunnelBuild setHttpAuth(String httpAuth) {
            this.httpAuth = httpAuth;
            return this;
        }

        public TunnelBuild setProto(String proto) {
            this.proto = proto;
            return this;
        }

        public TunnelBuild setRemotePort(int remotePort) {
            this.remotePort = remotePort;
            return this;
        }

        public TunnelBuild setSubDomain(String subDomain) {
            this.subDomain = subDomain;
            return this;
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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
