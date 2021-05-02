package com.test.weather.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.weather.exception.ApiException;
import com.test.weather.model.response.ServiceErrorResponse;
import com.test.weather.model.response.WeatherResponse;
import com.test.weather.service.RestService;
import com.test.weather.util.constatnts.ErrorConstants;

/**
 * @author Shenbagavalli
 *
 */

@Service
public class RestServiceImpl implements RestService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RestServiceImpl.class);
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public WeatherResponse getRestServiceresponse( String url) throws ApiException {
		try {

            HttpEntity<Object> httpEntity;

                  httpEntity = new HttpEntity<Object>(null);

           



            RestTemplate externalRestTemplate = new RestTemplate();


LOGGER.info("REST URL :: {}",  url );

LOGGER.info("Service request {}", httpEntity);

LocalDateTime startTime = LocalDateTime.now();

ResponseEntity<WeatherResponse> responseEntity =  externalRestTemplate.exchange(url, HttpMethod.GET, httpEntity,WeatherResponse.class);

     LocalDateTime endTime = LocalDateTime.now();

     LOGGER.info("Response from  external service: " + responseEntity.toString() + ":: End Time=" + Duration.between(endTime, startTime).getSeconds()+"secs" );

return responseEntity.getBody();

} catch(RestClientResponseException e) {


     LOGGER.error("Error from the service :"+e.getResponseBodyAsString());
     ServiceErrorResponse error;
	try {
		error = mapper.readValue(e.getResponseBodyAsString(), ServiceErrorResponse.class);
	     throw new ApiException(error.getCod(), error.getMessage());

	} catch (JsonProcessingException e1) {
	     LOGGER.error("JsonProcessingException caught  :"+e.getResponseBodyAsString());
		throw new ApiException(ErrorConstants.SERVICE_ERROR, ErrorConstants.SERVICE_ERROR);
	}

}
	}

}
