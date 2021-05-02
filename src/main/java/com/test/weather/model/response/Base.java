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
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal temp;
	private BigDecimal feels_like;
	private BigDecimal temp_min;
	private BigDecimal temp_max;
	private BigDecimal pressure;
	private BigDecimal humidity;

}
