/**
 * 

Author Shenbagavalli
 */
package com.test.weather.service;

import java.util.List;

import com.test.weather.exception.ApiException;
import com.test.weather.model.request.WeatherRequest;
import com.test.weather.model.response.CountryResponse;
import com.test.weather.model.response.WeatherResponse;

/**
 * @author Shenbagavalli
 *
 */
public interface WeatherService {
	
	public WeatherResponse getWeatherByCity(WeatherRequest weatherRequest) throws ApiException;
	public WeatherResponse getWeatherByLocation(WeatherRequest weatherRequest) throws ApiException;
	public List<CountryResponse> getCountryList() throws ApiException;
	public void clearCountryListCache() ;
	public void clearCityCache() ;
	public void clearLocationCache() ;


}
