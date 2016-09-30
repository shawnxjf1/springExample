package com.packClassStructure;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

/**
 * 如果有接口，注释和注解定义在interface上<br>
 * 
 * @author lakala-shawn
 *
 */
@Path("searchRuleService")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public interface ISearchService {

	/**
	 * 
	 * @param uriInfo
	 * @return
	 */
	public Object displayRuleCache(@Context UriInfo uriInfo);

}
