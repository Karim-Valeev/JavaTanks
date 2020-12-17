package ru.kpfu.itis;

import ru.kpfu.itis.server.GameServer;
import ru.kpfu.itis.server.exceptions.GameServerException;
import ru.kpfu.itis.server.listeners.EnterWithNameListener;

public class JavaTanksServer extends GameServer {
    private static int PORT = 11903;

    public static void main(String[] args) {
        JavaTanksServer server = new JavaTanksServer(PORT);
        try {
            server.registerListener(new EnterWithNameListener());

            server.start();
        } catch (GameServerException e) {
            throw new IllegalStateException(e);
        }
    }

    public JavaTanksServer(int port) {
        super(port);
    }
}
