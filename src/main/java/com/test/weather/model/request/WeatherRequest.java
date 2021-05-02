/**
 * 

Author Shenbagavalli
 */
package com.test.weather.model.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.test.weather.util.constatnts.ErrorConstants;
import com.test.weather.validator.RequestValidator.CityValidator;
import com.test.weather.validator.RequestValidator.LocationValidator;

import lombok.Data;

/**
 * @author Shenbagavalli
 *
 */
@Data
public class WeatherRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(groups= {LocationValidator.class}, message =ErrorConstants.INVALID_INPUT)
	@Min(value = -90)
	@Max(value = 90)
	private BigDecimal lat;
	@NotNull(groups= {LocationValidator.class}, message =ErrorConstants.INVALID_INPUT)
	@Min(value = -180)
	@Max(value = 180)
	private BigDecimal lon;
	
	@NotEmpty(groups= {CityValidator.class}, message =ErrorConstants.INVALID_INPUT)
	private String city;
	@NotEmpty(groups= {CityValidator.class}, message =ErrorConstants.INVALID_INPUT)
	@Size(min = 2, max = 2, message=ErrorConstants.UNSUPPORTED_VALUE)
	private String country;

}
