package server;

import client.TimePOJODecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Server {
  private int port;

  public Server(int port) {
    this.port = port;
  }
  public void run(ChannelInboundHandlerAdapter adapter, ByteToMessageDecoder... decoder) throws InterruptedException {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workGroup = new NioEventLoopGroup();
    // NioEventLoopGroup - пул потоков, обрабатывающий
    // входящие и исходящие операции.
    // boss - обрабатывает подключение
    // worker - обрабатывает потоки данных
    try {
      ServerBootstrap boot = new ServerBootstrap();
      // ServerBootstrap - позволяет настроить сервер перед запуском
      boot.group(bossGroup, workGroup)
          .channel(NioServerSocketChannel.class) //Указываем использование класса NioServerSocketChannel
          // для создания канала после того, как принято входящее соединение.
          .childHandler(new ChannelInitializer<SocketChannel>() { //Указываем обработчик, который будем использовать для открытого канала (Channel).
            // ChannelInitializer помогает пользователю сконфигурировать новый канал.
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline().addLast(new TimeEncoder(), adapter);
            }
          })
      .option(ChannelOption.SO_BACKLOG, 128)
      .childOption(ChannelOption.SO_KEEPALIVE, true);
      // option() применяются к NioServerSocketChannel, который принимает входящие подключения,
      // а childOption() — для обрабатываемых каналов.
      ChannelFuture future = boot.bind(port).sync();
      future.channel().closeFuture().sync();
    } finally {
      workGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    int port = 8185;
    new Server(port).run(new TimeServerHandler());
  }
}
