package ru.kpfu.itis.server.abstracts;

import ru.kpfu.itis.protocol.Message;
import ru.kpfu.itis.server.Connection;
import ru.kpfu.itis.server.exceptions.ServerEventListenerException;


import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractServerEventListener implements ServerEventListener{

    protected boolean init;
    protected Server server;
    protected Queue<Pair<Connection, Message>> queue;
    protected List<Integer> types = new ArrayList<>();

    @Override
    public void init(Server server) {
        this.init = true;
        this.server = server;
        this.queue = new LinkedList<>();
        //Add types in inheritor-class
    }

    @Override
    public void submit(Connection connection, Message message) {
        queue.offer(new Pair<>(connection, message));
    }

    @Override
    public List<Integer> getTypes() {
        return types;
    }

    @Override
    public void run() {
        while (true){
            Thread.yield();
            if (!queue.isEmpty()){
                try {
                    Pair<Connection, Message> pair = queue.poll();
                    Connection connection = pair.getFirst();
                    Message message = pair.getSecond();
                    handle(connection, message);
                } catch (ServerEventListenerException e) {
                    throw new IllegalStateException("Can't handle message");
                }
            }
        }
    }
}
