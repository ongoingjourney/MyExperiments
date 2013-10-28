package com.sanjeeb.spring.webservice.twilio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/*")
public class TwilioController {
	@RequestMapping(value="/getTwiml", method=RequestMethod.GET)
	public @ResponseBody String getTwiml() {
		return readTwiml();
	}
	
	@RequestMapping(value="/getResponse", method = RequestMethod.GET)
	public @ResponseBody Response getCoffeeInXML() {
		Response response = new Response();
		TwilioSayMessage twilioSayMessage = new TwilioSayMessage();
		response.setTwilioSayMessage(twilioSayMessage);
		return response;
	}
	
	private String readTwiml() {
		String filePath = "D:\\Eclipse\\workspace\\SpringDictionaryService\\src\\resources\\twiml.xml";
		StringBuilder bldr = new StringBuilder();
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String str;
			while((str=bufferedReader.readLine())!=null) {
				bldr.append(str);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bldr.toString(); 
	}
	
	public static void main(String[] args) {
		TwilioController controller = new TwilioController();
		System.out.println(controller.getTwiml());
	}
}