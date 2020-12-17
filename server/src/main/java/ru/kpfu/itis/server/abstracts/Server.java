package ru.kpfu.itis.server.abstracts;

import ru.kpfu.itis.protocol.Message;
import ru.kpfu.itis.server.Connection;
import ru.kpfu.itis.server.exceptions.GameServerException;

public interface Server {


    void registerListener(ServerEventListener listener) throws GameServerException;

    void sendMessage(Connection connection, Message message) throws GameServerException;
    void sendBroadcastMessage(Message message) throws GameServerException;
    void sendBroadcastMessageExcept(Connection exceptConnection, Message message) throws GameServerException;
    void handleConnection(Connection connection) throws GameServerException;
    void start() throws GameServerException;

}
