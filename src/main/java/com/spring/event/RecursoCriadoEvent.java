package com.spring.event;

import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private ServletResponse response;
	private Long id;
	
	public RecursoCriadoEvent(Object source, ServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}

	public ServletResponse getResponse() {
		return response;
	}

	public Long getId() {
		return id;
	}
}
