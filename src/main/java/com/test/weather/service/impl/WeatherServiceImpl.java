/**
 * 

Author Shenbagavalli
 */
package com.test.weather.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.weather.exception.ApiException;
import com.test.weather.model.request.WeatherRequest;
import com.test.weather.model.response.CountryResponse;
import com.test.weather.model.response.WeatherResponse;
import com.test.weather.service.RestService;
import com.test.weather.service.WeatherService;
import com.test.weather.util.constatnts.ErrorConstants;


/**
 * @author Shenbagavalli
 *
 */


@Service
public class WeatherServiceImpl implements WeatherService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	@Autowired
	private RestService restService;
	
	@Autowired
	private ObjectMapper mapper;

	@Value("${weathher.api.url}")
	private String waetherApiUrl;
	
	@Value("${weather.api.key}")
	private String weatherApiKey;

	@Override
	@Cacheable("countryList")
	public List<CountryResponse> getCountryList() throws ApiException {
		TypeReference<List<CountryResponse>> typeReference = new TypeReference<List<CountryResponse>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/countryList.json");
		List<CountryResponse> list = new ArrayList<CountryResponse>();
		try {
			 list = mapper.readValue(inputStream, typeReference);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			throw new ApiException(ErrorConstants.SERVICE_ERROR, ErrorConstants.SERVICE_ERROR);
		}
		return list;
	}
	
	@Override
	@Cacheable("byCity")
	public WeatherResponse getWeatherByCity(WeatherRequest weatherRequest) throws ApiException {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(waetherApiUrl).queryParam("q", weatherRequest.getCity()+","+weatherRequest.getCountry()).queryParam("appId", weatherApiKey);
		return restService.getRestServiceresponse(uriComponentsBuilder.build().toString());
	}


	@Override
	@Cacheable("byLocation")
	public WeatherResponse getWeatherByLocation(WeatherRequest weatherRequest) throws ApiException {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(waetherApiUrl).
				queryParam("lat", weatherRequest.getLat())
				.queryParam("lon", weatherRequest.getLon())
				.queryParam("appId", weatherApiKey);

		return restService.getRestServiceresponse(uriComponentsBuilder.build().toString());
	}
	
	@Override
	@Scheduled(fixedDelay = 7200000)
	@CacheEvict("countryList")
	public void clearCountryListCache() {
		// Will remove countrylist Cache Every 2 hrs
	}

	@Override
	@Scheduled(fixedDelay = 7200000)
	@CacheEvict("byCity")
	public void clearCityCache() {
		// Will remove city Cache Every 2 hrs
	}

	@Override
	@Scheduled(fixedDelay = 7200000)
	@CacheEvict("byLocation")
	public void clearLocationCache() {
		// Will remove location Cache Every 2 hrs
		
	}

}
