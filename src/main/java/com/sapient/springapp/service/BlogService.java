package com.sapient.springapp.service;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.channel.BeanFactoryChannelResolver;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.core.DestinationResolver;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	public static void main(String[] args) throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("/blog/integration.xml", BlogService.class);
        System.out.println("Hit Enter to terminate");
        System.in.read();

	}

	public void loadBlogs() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/integration/blog.xml", BlogService.class);
        System.out.println("Hit Enter to terminate");
        System.in.read();
	}

/*	public void convertTemp() throws IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/integration/temperatureConversion.xml", BlogService.class);
		
		DestinationResolver<MessageChannel> channelResolver = new BeanFactoryChannelResolver(context);

		// Compose the XML message according to the server's schema
		String requestXml =
				"<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/webservices/\">" +
						"<Fahrenheit>90.0</Fahrenheit>" +
				"</FahrenheitToCelsius>";

		// Create the Message object
		Message<String> message = MessageBuilder.withPayload(requestXml).build();

		// Send the Message to the handler's input channel
		MessageChannel channel = channelResolver.resolveDestination("fahrenheitChannel");
		channel.send(message);		
		System.out.println(message);
		
	}*/	
	
}
