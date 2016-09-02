package com.lakala.soa.examples.mybatis.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakala.soa.examples.mybatis.model.IndexRoute;

@Service
public class IndexRouteService {

	@Autowired
	SqlSessionTemplate sqlMap;

	public IndexRoute searchIndexRouteByIndexName(String indexName) {

		return (IndexRoute) sqlMap.selectOne("IndexRoute.getIndexRouteByIndexName", indexName);
	}

	public int addIndexRoute(IndexRoute indexRoute) {

		return sqlMap.insert("IndexRoute.addRoute", indexRoute);
	}

	public int deleteIndexRoute(IndexRoute indexRoute) {

		return sqlMap.delete("IndexRoute.deleteRoute", indexRoute);
	}

	/**
	 * 返回1
	 * 
	 * @param indexRoute
	 * @return 1：success
	 */
	public int updateIndexRoute(IndexRoute indexRoute) {

		return sqlMap.update("IndexRoute.updateRoute", indexRoute);
	}

}
