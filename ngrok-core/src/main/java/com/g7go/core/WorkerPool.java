package com.g7go.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * @author Mr_Lee
 */
public class WorkerPool {

    private static Logger log = LoggerFactory.getLogger(WorkerPool.class);

    private static final ExecutorService executorService = newCachedThreadPool();

    public static void shutdown() {
        log.info("Ngrok Worker is shutdown!");
        executorService.shutdownNow();
    }

    public static void submit(Runnable worker) {
        executorService.submit(worker);
    }
}
