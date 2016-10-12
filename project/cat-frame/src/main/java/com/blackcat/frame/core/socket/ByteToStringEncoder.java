package com.blackcat.frame.core.socket;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

public class ByteToStringEncoder extends MessageToMessageEncoder<ByteBuf>{

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
	
		out.add(msg.toString(CharsetUtil.UTF_8));
	}

}
