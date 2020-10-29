package client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder { // (1)
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
    if (in.readableBytes() < 4) {
      return;                                    // (3)
    }
    out.add(in.readBytes(4));                      // (4)
  }

  //1. ByteToMessageDecoder — реализация ChannelInboundHandler, которая решает проблему фрагментации сообщений.
  //2. ByteToMessageDecoder вызывает метод decode() с внутренним кумулятивным буфером при получении новых данных.
  //3. decode() может ничего не добавлять в out, если в кумулятивном буфере не хватает данных для получения готового сообщения.
  // ByteToMessageDecoder будет и дальше вызывать decode() при получении новых данных.
  //4. Если метод decode() добавляет объект в out, это означает, что декодеру удалось декодировать/собрать готовое сообщение.
  // Затем ByteToMessageDecoder выкидывает из буфера обработанную часть.
}
