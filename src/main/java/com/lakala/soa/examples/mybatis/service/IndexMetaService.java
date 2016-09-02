package com.lakala.soa.examples.mybatis.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakala.soa.examples.mybatis.model.IndexMeta;

@Service
public class IndexMetaService {

	@Autowired
	SqlSessionTemplate sqlMap;

	public IndexMeta searchIndexMetaByIndexName(String indexName) {

		return (IndexMeta) sqlMap.selectOne("IndexMeta.getIndexMetaByIndexName", indexName);
	}

	public int addIndexMeta(IndexMeta indexMeta) {

		return sqlMap.insert("IndexMeta.addIndexMeta", indexMeta);
	}

	public int deleteIndexMeta(IndexMeta indexMeta) {

		return sqlMap.delete("IndexMeta.deleteIndexMeta", indexMeta);
	}

	/**
	 * 返回1
	 * 
	 * @param IndexMeta
	 * @return 1：success
	 */
	public int updateIndexMeta(IndexMeta IndexMeta) {

		return sqlMap.update("IndexMeta.updateIndexMeta", IndexMeta);
	}

}
