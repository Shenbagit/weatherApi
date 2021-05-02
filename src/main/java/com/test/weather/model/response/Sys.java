/**
 * 
 */
package com.test.weather.model.response;

import java.io.Serializable;

import lombok.Data;

/**
 * @author shenbagavalli
 *
 */

@Data
public class Sys implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String country;
	private String sunrise;
	private String sunset;

}
