<p align="center">
	<a href="https://img.shields.io/github/issues/liwc0329/ngrok-parent">
		<img src="https://img.shields.io/github/issues/liwc0329/ngrok-parent"/>
	</a>
	<a href="https://img.shields.io/github/forks/liwc0329/ngrok-parent">
		<img src="https://img.shields.io/github/forks/liwc0329/ngrok-parent"/>
	</a>
	<a href="https://img.shields.io/github/stars/liwc0329/ngrok-parent">
		<img src="https://img.shields.io/github/stars/liwc0329/ngrok-parent"/>
	</a>
	<a href="https://img.shields.io/badge/license-Apache--2.0-green">
		<img src="https://img.shields.io/badge/license-Apache--2.0-green"/>
	</a>
</p>

java 版本ngrok客户端，包含两个项目（core和starter），starter项目支持spring2.0及以上。

1,安装jar到maven本地库,或者在项目目录  maven install

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

2,使用core

引入依赖

```
<dependency>
    <groupId>com.g7go</groupId>
    <artifactId>ngrok-core</artifactId>
    <version>1.0.0.RELEASE</version>
</dependency>
```

使用
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

3,Spring Boot 使用starter(starter依赖core)

引入依赖

```
<dependency>
    <groupId>com.g7go</groupId>
    <artifactId>ngrok-spring-boot-starter</artifactId>
    <version>1.0.0.RELEASE</version>
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
#ngrok.serverAddress=

#ngrok访问端口
#ngrok.serverPort=80

#访问子域名前缀,默认随机字符串
#ngrok.subDomain=lwc

#协议名称
#ngrok.proto=http
```

启动项目

```
"C:\Program Files\Java\jdk8\bin\java.exe" -XX:TieredStopAtLevel=1 -noverify -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=60584:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk8\jre\lib\charsets.jar;C:\Program Files\Java\jdk8\jre\lib\deploy.jar;C:\Program Files\Java\jdk8\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk8\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk8\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk8\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk8\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk8\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk8\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk8\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk8\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk8\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk8\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk8\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk8\jre\lib\javaws.jar;C:\Program Files\Java\jdk8\jre\lib\jce.jar;C:\Program Files\Java\jdk8\jre\lib\jfr.jar;C:\Program Files\Java\jdk8\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk8\jre\lib\jsse.jar;C:\Program Files\Java\jdk8\jre\lib\management-agent.jar;C:\Program Files\Java\jdk8\jre\lib\plugin.jar;C:\Program Files\Java\jdk8\jre\lib\resources.jar;C:\Program Files\Java\jdk8\jre\lib\rt.jar;C:\Users\m\IdeaProjects\ngrok\target\classes;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter-thymeleaf\2.1.5.RELEASE\spring-boot-starter-thymeleaf-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter\2.1.5.RELEASE\spring-boot-starter-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot\2.1.5.RELEASE\spring-boot-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.1.5.RELEASE\spring-boot-starter-logging-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.11.2\log4j-to-slf4j-2.11.2.jar;C:\Users\m\.m2\repository\org\apache\logging\log4j\log4j-api\2.11.2\log4j-api-2.11.2.jar;C:\Users\m\.m2\repository\org\slf4j\jul-to-slf4j\1.7.26\jul-to-slf4j-1.7.26.jar;C:\Users\m\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\m\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23.jar;C:\Users\m\.m2\repository\org\thymeleaf\thymeleaf-spring5\3.0.11.RELEASE\thymeleaf-spring5-3.0.11.RELEASE.jar;C:\Users\m\.m2\repository\org\thymeleaf\thymeleaf\3.0.11.RELEASE\thymeleaf-3.0.11.RELEASE.jar;C:\Users\m\.m2\repository\org\attoparser\attoparser\2.0.5.RELEASE\attoparser-2.0.5.RELEASE.jar;C:\Users\m\.m2\repository\org\unbescape\unbescape\1.1.6.RELEASE\unbescape-1.1.6.RELEASE.jar;C:\Users\m\.m2\repository\org\slf4j\slf4j-api\1.7.26\slf4j-api-1.7.26.jar;C:\Users\m\.m2\repository\org\thymeleaf\extras\thymeleaf-extras-java8time\3.0.4.RELEASE\thymeleaf-extras-java8time-3.0.4.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.1.5.RELEASE\spring-boot-starter-web-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.1.5.RELEASE\spring-boot-starter-json-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.9.8\jackson-databind-2.9.8.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.9.8\jackson-core-2.9.8.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.8\jackson-datatype-jdk8-2.9.8.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.8\jackson-datatype-jsr310-2.9.8.jar;C:\Users\m\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.8\jackson-module-parameter-names-2.9.8.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.1.5.RELEASE\spring-boot-starter-tomcat-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\9.0.19\tomcat-embed-core-9.0.19.jar;C:\Users\m\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\9.0.19\tomcat-embed-el-9.0.19.jar;C:\Users\m\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\9.0.19\tomcat-embed-websocket-9.0.19.jar;C:\Users\m\.m2\repository\org\hibernate\validator\hibernate-validator\6.0.16.Final\hibernate-validator-6.0.16.Final.jar;C:\Users\m\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\m\.m2\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;C:\Users\m\.m2\repository\com\fasterxml\classmate\1.4.0\classmate-1.4.0.jar;C:\Users\m\.m2\repository\org\springframework\spring-web\5.1.7.RELEASE\spring-web-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-beans\5.1.7.RELEASE\spring-beans-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-webmvc\5.1.7.RELEASE\spring-webmvc-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-aop\5.1.7.RELEASE\spring-aop-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-context\5.1.7.RELEASE\spring-context-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-expression\5.1.7.RELEASE\spring-expression-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\projectlombok\lombok\1.18.8\lombok-1.18.8.jar;C:\Users\m\.m2\repository\com\g7go\spring-boot-starter-ngrok\1.0.0.RELEASE\spring-boot-starter-ngrok-1.0.0.RELEASE.jar;C:\Users\m\.m2\repository\com\g7go\ngrok-core\1.0.0.RELEASE\ngrok-core-1.0.0.RELEASE.jar;C:\Users\m\.m2\repository\com\alibaba\fastjson\1.2.33\fastjson-1.2.33.jar;C:\Users\m\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;C:\Users\m\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.1.5.RELEASE\spring-boot-autoconfigure-2.1.5.RELEASE.jar;C:\Users\m\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\m\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\m\.m2\repository\org\springframework\spring-core\5.1.7.RELEASE\spring-core-5.1.7.RELEASE.jar;C:\Users\m\.m2\repository\org\springframework\spring-jcl\5.1.7.RELEASE\spring-jcl-5.1.7.RELEASE.jar" com.g7go.ngrok.NgrokApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-05-26 16:34:12.984  INFO 8564 --- [           main] com.g7go.ngrok.NgrokApplication          : Starting NgrokApplication on 李文超 with PID 8564 (C:\Users\m\IdeaProjects\ngrok\target\classes started by m in C:\Users\m\IdeaProjects\ngrok)
2019-05-26 16:34:13.007  INFO 8564 --- [           main] com.g7go.ngrok.NgrokApplication          : No active profile set, falling back to default profiles: default
2019-05-26 16:34:24.018  INFO 8564 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 5678 (http)
2019-05-26 16:34:24.184  INFO 8564 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-05-26 16:34:24.185  INFO 8564 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.19]
2019-05-26 16:34:24.858  INFO 8564 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-05-26 16:34:24.859  INFO 8564 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 11565 ms
2019-05-26 16:34:26.019  INFO 8564 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-05-26 16:34:26.515  WARN 8564 --- [           main] ion$DefaultTemplateResolverConfiguration : Cannot find template location: classpath:/templates/ (please add some templates or check your Thymeleaf configuration)
2019-05-26 16:34:27.115  INFO 8564 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 5678 (http) with context path ''
2019-05-26 16:34:32.480  INFO 8564 --- [           main] com.g7go.ngrok.NgrokApplication          : Started NgrokApplication in 21.605 seconds (JVM running for 26.821)
2019-05-26 16:34:33.152  INFO 8564 --- [pool-1-thread-1] com.g7go.core.MessageHandler             : register url: http://601e4453.ngrok.g7go.com:8090
```
