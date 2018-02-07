package server;

import javax.servlet.ServletContextEvent;
import javax.xml.ws.Endpoint;

import org.springframework.web.context.ContextLoaderListener;
import server.WeatherImpl;

public class MyListener extends ContextLoaderListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String address = "http://localhost:8081/weather";
		Endpoint.publish(address, new WeatherImpl());
		super.contextInitialized(event);
	}
	
}
