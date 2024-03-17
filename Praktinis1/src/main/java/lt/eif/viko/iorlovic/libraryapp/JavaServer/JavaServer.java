package lt.eif.viko.iorlovic.libraryapp.JavaServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * JavaServer class represents a server that sends XML and XSD files to a client.
 * @author Ilja
 * @version 1.0
 */
public class JavaServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    /**
     * Starts the server on the specified port and sends files to the client.
     *
     * @param port The port number on which the server will listen.
     */
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port);

            clientSocket = serverSocket.accept();

            sendFile("Author.xml");

            sendFile("Author.xsd");

            System.out.println("Files sent.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientResponse = reader.readLine();
            if ("Files received".equals(clientResponse)) {
                System.out.println("Client received the files. Server will now stop.");
                stop();
            } else {
                System.out.println("Client failed to receive the files. Server will continue running.");
            }
        } catch (IOException e) {
            System.err.println("Failed to start the server on port " + port + ": " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Sends a file to the client.
     *
     * @param fileName The name of the file to be sent.
     * @throws IOException If an I/O error occurs when sending the file.
     */
    private void sendFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileData = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedInputStream.read(fileData, 0, fileData.length);

        OutputStream os = clientSocket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(fileData.length);

        os.write(fileData, 0, fileData.length);
        os.flush();

        System.out.println(fileName + " sent.");
    }

    /**
     * Stops the server by closing the client and server sockets.
     */
    public void stop() {
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method to start the server.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        JavaServer server = new JavaServer();
        server.start(7777);
    }
}
