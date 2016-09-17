package com.person.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

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
	public String getClientIp(@Context HttpServletRequest request, @Context UriInfo uriInfo) {

		// 带有泛型的继承 那个地方必须保持一致：MultivaluedMap<K, V> extends Map<K, List<V>>
		// 请求参数：http://localhost:8080/dssp/services/rest/SearchRuleCache/displayRuleCache?ruleName=pospRule1
		Map<String, List<String>> pathParamMap = uriInfo.getPathParameters();// 空
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();// 有值

		List<String> ruleName = queryParams.get("ruleName");

		// FIXME 还差一点需要把服务注册进去，拉卡拉dssp里通过soa注入的。
		return request.getRemoteAddr();
	}

}
