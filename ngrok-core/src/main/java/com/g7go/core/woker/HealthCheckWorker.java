package com.g7go.core.woker;

import com.g7go.core.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用ping维持链接正常
 *
 * @author Mr_Lee
 */
public class HealthCheckWorker implements Runnable {

    Logger log = LoggerFactory.getLogger(HealthCheckWorker.class);

    private final MessageHandler messageHandler;

    public HealthCheckWorker(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                messageHandler.sendPing();
                Thread.sleep(30000);
            }
        } catch (Exception e) {
            log.error("occurred some exception", e);
        }

    }
}
