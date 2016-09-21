package com.data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.lakala.soa.examples.mybatis.model.IndexMeta;

public class SearchRule implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ruleId;

	private String ruleName;

	/**
	 * 存储信息 : [f1]|[f2]|f3
	 */
	private String searchKey;

	/**
	 * 查询字段解析类型 f1:date,f2:number,f3:collection
	 */
	private String parseTypes;

	private String beginRanges;

	private String endRanges;

	private String matchCollections;

	private Timestamp createTime;

	private Timestamp updateTime;

	// status int(2) NOT NULL COMMENT '-1：删除 0：无效 1：有效',
	private int status;

	private String description;

	/**
	 * 
	 */
	private IndexMeta indexMeta = null;

	public SearchRule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getParseTypes() {
		return parseTypes;
	}

	public void setParseTypes(String parseTypes) {
		this.parseTypes = parseTypes;
	}

	public String getBeginRanges() {
		return beginRanges;
	}

	public void setBeginRanges(String beginRanges) {
		this.beginRanges = beginRanges;
	}

	public String getEndRanges() {
		return endRanges;
	}

	public void setEndRanges(String endRanges) {
		this.endRanges = endRanges;
	}

	public String getMatchCollections() {
		return matchCollections;
	}

	public void setMatchCollections(String matchCollections) {
		this.matchCollections = matchCollections;
	}

	/**
	 * 
	 * @return
	 */
	public IndexMeta getIndexMeta() {
		return indexMeta;
	}

	public void setIndexMeta(IndexMeta indexMeta) {
		this.indexMeta = indexMeta;
	}

	public String getIndexName() {
		if (this.indexMeta != null) {
			return this.indexMeta.getIndexName();
		}
		return null;
	}

	public String getTypeName() {
		if (this.indexMeta != null) {
			return this.indexMeta.getTypeName();
		}
		return null;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SearchRule [ruleId=" + ruleId + ", ruleName=" + ruleName + ", searchKey=" + searchKey + ", parseTypes="
				+ parseTypes + ", beginRanges=" + beginRanges + ", endRanges=" + endRanges + ", matchCollections="
				+ matchCollections + ", indexMeta=" + indexMeta + "]";
	}

}
