package com.lakala.soa.examples.webservice.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lakala.soa.examples.webservice.api.WebService;
/**
 * ClassName:WebServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class WebServiceImpl implements WebService {

	public String printWord(String word) {
		String outWord = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS")
				.format(new Date()) + word;
		System.err.println(" xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  Provider client started : " + outWord);
		return outWord;
	}

}
