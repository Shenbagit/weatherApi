
package com.test.weather.service;

import com.test.weather.exception.ApiException;
import com.test.weather.model.response.WeatherResponse;

/**
 * @author Shenbagavalli
 *
 */
public interface RestService {
	
	public WeatherResponse getRestServiceresponse (String url) throws ApiException;

}
