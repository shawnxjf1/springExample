package com.person.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("restExample")
public class RestExample {

	/**
	 * @avax.ws.rs.Context 用于获取环境信息。一个获取客户端ip的例子见下：
	 * @param request
	 * @return
	 */
	@Path("getClientIp")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getClientIp(@Context HttpServletRequest request) {
		return request.getRemoteAddr();
	}
}
