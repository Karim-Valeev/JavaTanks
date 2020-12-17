package ru.kpfu.itis.server.exceptions;

public class ServerEventListenerException extends Exception{
    public ServerEventListenerException() {
        super();
    }

    public ServerEventListenerException(String message) {
        super(message);
    }

    public ServerEventListenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerEventListenerException(Throwable cause) {
        super(cause);
    }

    protected ServerEventListenerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
