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
public class ServiceErrorResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cod;
	private String message;

}
