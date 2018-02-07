package server;

import javax.jws.WebService;

@WebService
public interface Weather {
	String queryWeather();
}
