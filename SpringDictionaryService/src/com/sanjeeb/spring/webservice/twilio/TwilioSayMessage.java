package com.sanjeeb.spring.webservice.twilio;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class TwilioSayMessage {
	private String voice;
	//private int loop;
	private String message;
	private String language;
		
	public TwilioSayMessage() {
		this.message = "Welcome Some Message";
		this.voice = "woman";
		//this.loop = 1;
		//this.language = "en-US";
	}
	
	@XmlAttribute(name="voice")
	public void setVoice(String voice) {
		this.voice = voice;
	}

//	@XmlAttribute(name="loop")
//	public void setLoop(int loop) {
//		this.loop = loop;
//	}
	
	@XmlAttribute(name="language")
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@XmlValue
	public void setMessage(String message) {
		this.message = message;
	}

//	public int getLoop() {
//		return loop;
//	}

	public String getLanguage() {
		return language;
	}

	public String getMessage() {
		return message;
	}
	
	public String getVoice() {
		return voice;
	}
}