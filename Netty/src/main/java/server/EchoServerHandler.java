package server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

//обработчик событий
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("client accepted: " + ctx.channel().remoteAddress());
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//    ByteBuf in = ((ByteBuf) msg);
//    try {
////      while (in.isReadable()) {        // (1)
////        System.out.print((char) in.readByte());
////        System.out.flush();
////      }
      ctx.writeAndFlush(msg);
//      ctx.flush();
//      } finally {
//      ReferenceCountUtil.release(msg);
//    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace(); //логируем
    ctx.close(); //закрываем канал
  }
}
