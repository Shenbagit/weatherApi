/**
 * 
 */
package com.test.weather.model.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author shenbagavalli
 *
 */

@Data
public class WeatherResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Coordinates coord;
	private List<Weather> weather;
	private Base main;
	private Sys sys;
	private String name;
	

}
