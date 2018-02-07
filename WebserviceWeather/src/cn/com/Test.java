package cn.com;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import cn.com.WebXml.WeatherWebService;
import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;
import cn.com.WebXml.WeatherWebServiceSoapProxy;

public class Test {
	public static void main(String[] args) {
		WeatherWebService service = new WeatherWebServiceLocator();
		WeatherWebServiceSoap soap;
		try {
			soap = service.getWeatherWebServiceSoap();
			String[]  str= soap.getWeatherbyCityName("成都");
			for (String string : str) {
				System.out.println(string);
			}
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
