/**
 * 

Author Shenbagavalli
 */
package com.test.weather.model.response;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Shenbagavalli
 *
 */

@Data
public class CountryResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String description;

}
