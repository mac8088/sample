package net.atos.sample.netty.itstack.c210.domain;

import net.atos.sample.netty.itstack.c210.domain.protocol.Command;
import net.atos.sample.netty.itstack.c210.domain.protocol.Packet;

/**
 * 虫洞栈：https://bugstack.cn 公众号：bugstack虫洞栈 ｛关注获取学习源码｝ 虫洞群：①群5398358 ②群5360692
 * Create by fuzhengwei on 2019
 */
public class MsgDemo03 extends Packet {

	private String channelId;
	private String demo03;

	public MsgDemo03(String channelId, String demo03) {
		this.channelId = channelId;
		this.demo03 = demo03;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getDemo03() {
		return demo03;
	}

	public void setDemo03(String demo03) {
		this.demo03 = demo03;
	}

	@Override
	public Byte getCommand() {
		return Command.Demo03;
	}
}
