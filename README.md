# ngrok-parent
java 版本ngrok客户端，包含两个项目（core和starter），starter项目支持spring2.0及以上。

1,使用core

```
public class NgrokMain {

    private static final String SERVER_ADDRESS = "ngrok.g7go.com";
    private static final int SERVER_PORT = 8092;

    public static void main(String[] args) throws Exception {
        Tunnel tunnel = new Tunnel.TunnelBuild().setPort(8080).setProto("http").setSubDomain("test").build();
        new NgrokClient(SERVER_ADDRESS, SERVER_PORT).addTunnel(tunnel).start();
    }
}
```
2,Spring Boot 使用starter(starter依赖core)

安装jar到maven本地库,或者在项目目录  maven install

```
安装指定文件到本地仓库命令：mvn install:install-file
-DgroupId=<groupId>       : 设置项目代码的包名(一般用组织名)
-DartifactId=<artifactId> : 设置项目名或模块名 
-Dversion=1.0.0           : 版本号
-Dpackaging=jar           : 什么类型的文件(jar包)
-Dfile=<myfile.jar>       : 指定jar文件路径与文件名(同目录只需文件名)
安装命令实例：
mvn install:install-file -DgroupId=xxx -DartifactId=xxx -Dversion=xxx -Dpackaging=jar -Dfile=xxx.jar
```

引入依赖

```
<dependency>
    <groupId>com.g7go</groupId>
    <artifactId>spring-boot-starter-ngrok</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>

```

配置文件

```
#是否开启映射,默认开启
#ngrok.enabled=true

#自定义域名
#ngrok.hostName=www.baidu.com

#访问授权
#ngrok.httpAuth=user:password

#tcp远程端口
#ngrok.remotePort=8765

#ngrok访问地址
#ngrok.serverAddress=ngrok.g7go.com

#ngrok访问端口
#ngrok.serverPort=8092

#访问子域名前缀,默认随机字符串
#ngrok.subDomain=lwc

#协议名称
#ngrok.proto=http
```


