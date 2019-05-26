package com.g7go.core;

/**
 * @author Mr_Lee
 */
public class NgrokClientException extends RuntimeException {
    public NgrokClientException() {
    }

    public NgrokClientException(String message) {
        super(message);
    }

    public NgrokClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public NgrokClientException(Throwable cause) {
        super(cause);
    }

    public NgrokClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
