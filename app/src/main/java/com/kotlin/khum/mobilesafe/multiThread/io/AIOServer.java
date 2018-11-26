package com.kotlin.khum.mobilesafe.multiThread.io;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * <pre>
 *     author : khum
 *     desc   : AIO(NIO2) 异步非阻塞IO
 * </pre>
 */
public class AIOServer extends Thread{

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            channel.accept(channel, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                @Override
                public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                    try(SocketChannel client = (SocketChannel) attachment.accept()){
                        client.write(Charset.defaultCharset().encode("hello world"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
