package com.chatboard.lib;


public class BaseMessage {
	
	public String serialize() {
		return SerializingUtil.serializeToStr(this);
	}
	
}
