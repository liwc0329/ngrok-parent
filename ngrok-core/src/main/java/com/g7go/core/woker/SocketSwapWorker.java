package com.g7go.core.woker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/**
 * 代理消息
 *
 * @author Mr_Lee
 */
public class SocketSwapWorker implements Runnable {

    Logger log = LoggerFactory.getLogger(HealthCheckWorker.class);

    private DataInputStream in;

    private DataOutputStream out;

    public SocketSwapWorker(InputStream in, OutputStream out) {
        this.in = new DataInputStream(in);
        this.out = new DataOutputStream(out);
    }

    @Override
    public void run() {
        // 线程运行函数,循环读取返回数据,并发送给相关客户端
        try {
            int readBytes;
            byte buf[] = new byte[1024];
            while (true) {
                readBytes = in.read(buf, 0, 1024);
                if (readBytes == -1) {
                    break;
                }
                if (readBytes > 0) {
                    out.write(buf, 0, readBytes);
                    out.flush();
                }
            }
            out.close();
            in.close();
        } catch (SocketException e) {
            //链接关闭,等待下一次访问时重新打开
            return;
        } catch (Exception e) {
            log.error("Occurred some exception", e);
        }
    }
}