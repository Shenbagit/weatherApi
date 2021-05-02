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
public class Weather implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String main;
	private String description;
	private String icon;

}
