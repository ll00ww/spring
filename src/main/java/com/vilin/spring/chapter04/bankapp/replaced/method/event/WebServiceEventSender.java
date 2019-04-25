package com.vilin.spring.chapter04.bankapp.replaced.method.event;

import java.util.Properties;

public class WebServiceEventSender implements EventSender {
	@SuppressWarnings("unused")
	private Properties webServiceProperties;

	public void setWebServiceProperties(Properties webServiceProperties) {
		this.webServiceProperties = webServiceProperties;
	}

	@Override
	public void sendEvent(Event e) {
		// -- send the event to the remote web service
	}

}