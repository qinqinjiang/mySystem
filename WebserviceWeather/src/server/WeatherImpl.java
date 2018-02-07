package server;

import javax.jws.WebService;

@WebService
public class WeatherImpl implements Weather{

	@Override
	public String queryWeather() {
		// TODO Auto-generated method stub
		return "气温1-3度，加穿衣物";
	}
	
}
