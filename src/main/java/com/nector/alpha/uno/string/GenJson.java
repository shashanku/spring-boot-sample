/**
 * 
 */
package com.nector.alpha.uno.string;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nector.alpha.uno.entity.CommodityDetails;
import com.nector.alpha.uno.entity.EventDetails;
import com.nector.alpha.uno.entity.TokenDetails;
import com.nector.alpha.uno.entity.Transaction;

/**
 * 
 */
public class GenJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println(gson.toJson(new TokenDetails()));

	}

}
