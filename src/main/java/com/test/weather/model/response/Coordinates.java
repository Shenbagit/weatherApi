/**
 * 
 */
package com.test.weather.model.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author shenbagavalli
 *
 */
@Data
public class Coordinates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal lon;
	private BigDecimal lat;

}
