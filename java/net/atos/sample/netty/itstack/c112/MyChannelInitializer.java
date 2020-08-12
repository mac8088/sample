package net.atos.sample.netty.itstack.c112;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

/**
 * Create by fuzhengwei on 2019
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) {
        // Data decoding operation
        channel.pipeline().addLast(new HttpResponseEncoder());
        // Data encoding operation
        channel.pipeline().addLast(new HttpRequestDecoder());
        // Add our own implementation method of receiving data in the pipeline
        channel.pipeline().addLast(new MyServerHandler());
    }

}
