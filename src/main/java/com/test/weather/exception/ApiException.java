/**
 * 

Author Shenbagavalli
 */
package com.test.weather.exception;

import lombok.Data;

/**
 * @author Shenbagavalli
 *
 */

@Data
public class ApiException extends Exception{
	
	private String code;
	private String message;
	
	
	/**
	 * @param code
	 * @param message
	 */
	public ApiException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
