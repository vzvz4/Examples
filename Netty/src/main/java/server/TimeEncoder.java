package server;


import POJO.UnixTimePOJO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TimeEncoder extends MessageToByteEncoder<UnixTimePOJO> {
  @Override
  protected void encode(ChannelHandlerContext ctx, UnixTimePOJO msg, ByteBuf out) {
    out.writeInt((int)msg.value());
  }
}
