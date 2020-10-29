package server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

@ChannelHandler.Sharable
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    super.channelRead(ctx, msg);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    // Метод channelActive() вызывается при открытии соединения и готовности передавать данные.
    // В данном случае при открытии соединения отправим 32-битное целое число, обозначающее время.
    final ByteBuf time = ctx.alloc().buffer(4);
    time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
    final ChannelFuture f = ctx.writeAndFlush(time);
    f.addListener((ChannelFutureListener) channelFuture -> {
      assert f == channelFuture;
      ctx.close();
    });
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
