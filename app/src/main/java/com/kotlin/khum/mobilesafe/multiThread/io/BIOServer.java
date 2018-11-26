package com.kotlin.khum.mobilesafe.multiThread.io;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     author : khum
 *     desc   : BIO 阻塞IO
 * </pre>
 */
public class BIOServer extends Thread {
    public ServerSocket serverSocket;

    public int getPort(){
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            Socket socket = serverSocket.accept();
            RequestHandler requestHandler = new RequestHandler(socket);
            executorService.execute(requestHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket!=null){
                try{
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] arg){
        BIOServer demoServer = new BIOServer();
        demoServer.start();
        try {
            Thread.sleep(new Random().nextInt(1000)+1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Socket client = null;
        try {
            client = new Socket(InetAddress.getLocalHost(), demoServer.getPort());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client!=null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RequestHandler extends Thread{

    private final Socket socket;

    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("hello world");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
