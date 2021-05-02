/**
 * 

Author Shenbagavalli
 */
package com.test.weather.model.response;

import lombok.Data;

/**
 * @author Shenbagavalli
 *
 */

@Data
public class ErrorInfo {
	
	private String code;
	private String message;
	/**
	 * @param code
	 * @param message
	 */
	public ErrorInfo(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	

}
