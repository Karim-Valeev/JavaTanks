package ru.kpfu.itis.server;

import ru.kpfu.itis.models.Game;
import ru.kpfu.itis.protocol.Message;
import ru.kpfu.itis.server.abstracts.Server;
import ru.kpfu.itis.server.abstracts.ServerEventListener;
import ru.kpfu.itis.server.exceptions.GameServerException;
import ru.kpfu.itis.server.exceptions.ServerEventListenerException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer implements Server {

    protected List<Connection> connections;
    protected List<Game> games;
    protected List<ServerEventListener> listeners;
    protected ServerSocket serverSocket;
    protected boolean started;
    protected int port;

    public GameServer(int port) {
        init(port);
    }

    @Override
    public void registerListener(ServerEventListener listener) throws GameServerException {
        if (started) {
            throw new GameServerException("Server has been started");
        }
        listener.init(this);
        Thread listenerThread = new Thread(listener);
        listenerThread.start();
        listeners.add(listener);
    }

    @Override
    public void sendMessage(Connection connection, Message message) throws GameServerException {
        if (!started) {
            throw new GameServerException("Server hasn't been started");
        }
        try {
            if (connections.contains(connection)) {
                connection.getSocket().getOutputStream().write(Message.getBytes(message));
                connection.getSocket().getOutputStream().flush();
            } else{
                throw new GameServerException("No such connection");
            }
        } catch (IOException e) {
            throw new GameServerException("Can't send message", e);
        }
    }

    @Override
    public void sendBroadcastMessage(Message message) throws GameServerException {
        if (!started) {
            throw new GameServerException("Server hasn't been started");
        }
        try {
            byte[] messageBytes = Message.getBytes(message);
            for (Connection connection : connections){
                connection.getSocket().getOutputStream().write(messageBytes);
                connection.getSocket().getOutputStream().flush();
            }
        }catch (IOException e){
            throw new GameServerException("Can't send message", e);
        }
    }

    @Override
    public void sendBroadcastMessageExcept(Connection exceptConnection, Message message) throws GameServerException {
        if (!started) {
            throw new GameServerException("Server hasn't been started");
        }
        try {
            byte[] messageBytes = Message.getBytes(message);
            for (Connection connection : connections){
                if (connection.equals(exceptConnection)){
                    continue;
                }
                connection.getSocket().getOutputStream().write(messageBytes);
                connection.getSocket().getOutputStream().flush();
            }
        }catch (IOException e){
            throw new GameServerException("Can't send message", e);
        }
    }

    @Override
    public void handleConnection(Connection connection) throws GameServerException {
        try{
            Message message = Message.readMessage(connection.getSocket().getInputStream());
            System.out.println("New message:");
            System.out.println(Message.toString(message));
            for(ServerEventListener listener : listeners){
                if(listener.getTypes().contains(message.getType())){
                    // One by one! Another left listeners will wait current
                    // Another thread could be created here or before for every Listener
                    //TODO submit to treads
                    listener.submit(connection, message);
                }
            }
        }
        catch(IOException ex){
            throw new GameServerException("Problem with handling connection.", ex);
        }
    }

    private void init(int port) {
        this.connections = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.games = new ArrayList<>();
        this.port = port;
    }

    @Override
    public void start() throws GameServerException {
        try {
            this.serverSocket = new ServerSocket(this.port);
            this.started = true;
            System.out.println("Server was started...");

            while (true) {
                Socket s = serverSocket.accept();

                Connection connection = initConnection(s);
                connections.add(connection);
                Thread thread = new Thread(connection);
                thread.start();
            }
        } catch (IOException e) {
            throw new GameServerException("Game server starting problems...", e);
        }
    }

    private Connection initConnection(Socket s) throws GameServerException {
        try {
            Message message = Message.readMessage(s.getInputStream());
            if (message.getType() == Message.TYPE_INIT_CONNECTION) {
                String username = "User#" + connections.size();
                return new Connection(
                        (long) connections.size(),
                        username,
                        s,
                        this
                );
            } else {
                throw new GameServerException("Connection initialization problem...");
            }
        } catch (IOException e) {
            throw new GameServerException("Connection initialization problem...", e);
        }
    }
}
