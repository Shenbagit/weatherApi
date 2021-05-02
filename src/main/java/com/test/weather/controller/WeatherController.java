/**
 * 

Author Shenbagavalli
 */
package com.test.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.weather.exception.ApiException;
import com.test.weather.model.request.WeatherRequest;
import com.test.weather.model.response.ErrorInfo;
import com.test.weather.model.response.WeatherResponse;
import com.test.weather.service.WeatherService;
import com.test.weather.util.constatnts.ApiConstants;
import com.test.weather.util.constatnts.ErrorConstants;
import com.test.weather.validator.RequestValidator.CityValidator;
import com.test.weather.validator.RequestValidator.LocationValidator;

/**
 * @author Shenbagavalli
 *
 */


@RestController
@RequestMapping(ApiConstants.WEATHER)
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;

	/**
	 * Api to fetch the weather by city. Takes input city and country code. Country code can be fetchhed from Api http localhost:8080/weather/countries using GET method
	 *
	 */
	@PostMapping(ApiConstants.WEATHER_CITY)
	public Object getWatherByCity(@Validated(CityValidator.class) @RequestBody WeatherRequest weatherRequest) throws ApiException {
			return weatherService.getWeatherByCity(weatherRequest);
		
		
	}
	
	
	/**
	 * Api to fetch the weather by location. Takes input as lat, lon
	 *
	 */
	@PostMapping(ApiConstants.WEATHER_LOCATION)
	public Object getWatherByLocation(@Validated(LocationValidator.class) @RequestBody WeatherRequest weatherRequest) throws ApiException {
			return weatherService.getWeatherByLocation(weatherRequest);
		
		
	}
	
	
	/**
	 * Api to fetch the list of countries
	 *
	 */
	@GetMapping(ApiConstants.COUNTRIES)
	public Object getCountryList() throws ApiException {
			return weatherService.getCountryList();
		
		
	}

}
