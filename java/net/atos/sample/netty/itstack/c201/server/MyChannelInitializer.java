package net.atos.sample.netty.itstack.c201.server;

import java.nio.charset.Charset;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        // Based on line feed symbols
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // Data decoding operation with GBK or UTF-8
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // Data encoding operation with GBK or UTF-8
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // Add our own implementation method of receiving data in the pipeline
        channel.pipeline().addLast(new MyServerHandler());
    }

}
