package com.lakala.soa.examples.rest.bsfit.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.lakala.soa.examples.rest.bsfit.model.BlackNameListParam;
import com.lakala.soa.examples.rest.bsfit.model.NameListBean;

@Path("bsfit")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public interface NameListService {
	
		@POST
		@Path("testfindByNameList")
		public List<NameListBean> getTestFinyByNameList();
	
	//@POST
	//@Path("findByNameList")
	public List<NameListBean> getFinyByNameList(BlackNameListParam paras);

	@POST
	@Path("findByName")
	public NameListBean getFinyByName(BlackNameListParam paras);
	
	@POST
	@Path("findStatus")
	public String getFinyStatus(BlackNameListParam paras);

}
