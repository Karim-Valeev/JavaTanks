package ru.kpfu.itis.server.exceptions;

public class GameServerException extends Exception{
    public GameServerException() {
        super();
    }

    public GameServerException(String message) {
        super(message);
    }

    public GameServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameServerException(Throwable cause) {
        super(cause);
    }

    protected GameServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
