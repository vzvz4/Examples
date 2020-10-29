package client;

import POJO.UnixTimePOJO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class TimeClientHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    UnixTimePOJO m = (UnixTimePOJO) msg;
    System.out.println(m);
    ctx.close();
  }


  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    ChannelFuture f = ctx.writeAndFlush(new UnixTimePOJO());
    f.addListener(ChannelFutureListener.CLOSE);
  }


}
