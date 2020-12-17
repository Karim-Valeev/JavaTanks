package ru.kpfu.itis.server.abstracts;

import ru.kpfu.itis.protocol.Message;
import ru.kpfu.itis.server.Connection;
import ru.kpfu.itis.server.exceptions.ServerEventListenerException;

import java.util.List;

public interface ServerEventListener extends Runnable {

    void init(Server server);
    void handle(Connection connection, Message message) throws ServerEventListenerException;
    void submit(Connection connection, Message message);
    List<Integer> getTypes();

}
