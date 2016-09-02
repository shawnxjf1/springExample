/**
 * 
 */
package com.lakala.soa.examples.rest.bsfit.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakala.soa.examples.rest.bsfit.model.BlackNameListParam;
import com.lakala.soa.examples.rest.bsfit.model.NameListBean;
import com.lakala.soa.examples.rest.bsfit.service.NameListService;



/**
 * @author Administrator
 *
 */
//@ContextConfiguration(locations="/applicationContext.xml")
//@Service

@Service(value="nameListService")//testjunit
public class NameListServiceImpl implements NameListService {
	//private static Logger log = Logger.getLogger(NameListServices.class);
	private static Logger log=Logger.getLogger(NameListServiceImpl.class);
	
	@Autowired
	SqlSessionTemplate sqlMap;

	public void setSqlMap(SqlSessionTemplate sqlMap) {
		this.sqlMap = sqlMap;
	}



	public List<NameListBean> getFinyByNameList(BlackNameListParam paras) {
		
		Map<Object, Object> map= new HashMap<Object, Object>();
		map.put("uniqueId", paras.getUniqueId());
		map.put("tag", paras.getTag());
		
		map.put("pageEnd", paras.getPageSize()+paras.getPageStart());
		map.put("pageStart", paras.getPageStart());
		log.info("request params:"+map.toString());
		List<NameListBean> list=sqlMap.selectList("nameList.findByNameList",map);
		
		if (list !=null ){
			log.info("response List<NameListBean> count:"+list.size());
			return list;
		}	
		else {
			return new ArrayList<NameListBean>();
		}
	}
	
	public NameListBean getFinyByName(BlackNameListParam paras) {
		if(paras.getUniqueId() ==null || paras.getUniqueId().length()==0 || paras.getTag()==null || paras.getTag().length()==0){
			log.info(" http request params is error 。。。。。。。。。。。。。。。。");
			return null;
		}
		System.out.println("getFinyByName------------------>");
		Map<String, String> map= new HashMap<String, String>();
		map.put("uniqueId", paras.getUniqueId());
		map.put("tag", paras.getTag());
		log.info("request params:"+map.toString());
		NameListBean nameListBean=sqlMap.selectOne("nameList.findByName",map);
		if(nameListBean != null){
			log.info("response NameListBean:"+nameListBean.toString());
			return nameListBean;
		}else{
			return new NameListBean();
		}
		
		
		
	}


    /****
     * 
     * @return 1:启用，2：不启用，3：参数错误
     */
	@Override
	public String getFinyStatus(BlackNameListParam paras) {
		String tmp_Status="2";//不存在记录，
		if(paras == null){
			return "null";
		}
		String varUniqueId=paras.getUniqueId();
		String varTag=paras.getTag();
		if(varUniqueId ==null || varUniqueId.length()==0 ||varTag==null || varTag.length()==0){
			log.info(" http request params is error 。。。。。。。。。。。。。。。。");
			return "3";
		}
		//判断参数是否符合查询要求
		if("license".equals(varTag) ||"settleaccounts".equals(varTag) ||"certificate".equals(varTag)){
			Map<String, String> map= new HashMap<String, String>();
			map.put("uniqueId", varUniqueId);
			map.put("tag", varTag);
			log.info("request params:"+map.toString());
			NameListBean nameListBean=sqlMap.selectOne("nameList.findByName",map);
			if(nameListBean!=null){
				log.info("response getFinyStatus:"+nameListBean.toString());
				//NameListBean nameListBean=list.get(0);
				//判断入网拦截
				if (nameListBean.getBussiness().equals("merchantin") && nameListBean.getStatus().equals("1") 
						&& nameListBean.getCheckStatus().equals("2") && nameListBean.getType().equals("black")){
					
					tmp_Status="1";//启用
				}
			}
		}else{
			tmp_Status = "3";
		}
		return tmp_Status;
	}



	@Override
	public List<NameListBean> getTestFinyByNameList() {
	
		System.out.println("getTestFinyByNameList------------------>");
		List<NameListBean> list=sqlMap.selectList("nameList.testfindByName");
		if (list.size()>0 )
			
			return list;
		else 
			return null;
	}

}
