package com.chatboard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

	protected Logger log = LoggerFactory.getLogger(getClass());

	public abstract boolean onStart();

	public abstract boolean onClose();
	
}
