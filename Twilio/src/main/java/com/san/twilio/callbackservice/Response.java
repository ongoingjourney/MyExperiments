package com.san.twilio.callbackservice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "Response")
public class Response {
	private TwilioSayMessage twilioSayMessage;

	@XmlElement(name="Say")
	public void setTwilioSayMessage(TwilioSayMessage twilioSayMessage) {
		this.twilioSayMessage = twilioSayMessage;
	}

	public TwilioSayMessage getTwilioSayMessage() {
		return twilioSayMessage;
	}
}