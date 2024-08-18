package com.edureka.hotelreservationsystem.customerservice.dto;

import java.io.Serializable;

public class EventMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public EventMessage(String eventType, String eventMessage) {
		super();
		this.eventType = eventType;
		this.eventMessage = eventMessage;
	}

	private String eventType;
	
	private String eventMessage;

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the eventMessage
	 */
	public String getEventMessage() {
		return eventMessage;
	}

	/**
	 * @param eventMessage the eventMessage to set
	 */
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}

}
