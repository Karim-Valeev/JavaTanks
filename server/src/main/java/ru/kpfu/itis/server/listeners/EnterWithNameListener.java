package ru.kpfu.itis.server.listeners;

import ru.kpfu.itis.protocol.Message;
import ru.kpfu.itis.server.Connection;
import ru.kpfu.itis.server.abstracts.AbstractServerEventListener;
import ru.kpfu.itis.server.abstracts.Server;
import ru.kpfu.itis.server.exceptions.GameServerException;
import ru.kpfu.itis.server.exceptions.ServerEventListenerException;

import java.nio.ByteBuffer;

public class EnterWithNameListener extends AbstractServerEventListener {

    @Override
    public void init(Server server) {
        super.init(server);
        types.add(Message.TYPE_SUBMIT_NAME);
    }

    @Override
    public void handle(Connection connection, Message message) throws ServerEventListenerException {
        if (!this.init) {
            throw new ServerEventListenerException();
        }
        String username = new String(message.getData());
        connection.setUsername(username);
        ByteBuffer byteBuffer = ByteBuffer.allocate(Long.BYTES);
        byteBuffer.putLong(connection.getId());
        Message answer = Message.createMessage(
                Message.TYPE_SUBMIT_NAME_ANSW,
                byteBuffer.array()
        );
        try {
            this.server.sendMessage(connection, answer);
        } catch (GameServerException e) {
            throw new IllegalStateException("Can't send message", e);
        }
    }
}
