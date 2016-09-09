package com.data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class SearchRule implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ruleId;

	private String ruleName;

	/**
	 * 该字段必须是索引创建的基准字段
	 */
	private String searchField;

	/**
	 * 查询字段解析类型
	 */
	private String parseType;

	private String matchBegin;

	private String matchEnd;

	private String matchCollection;

	private List<String> matchCollectionList;

	private int indexId;

	private String bizType;

	private String sysName;

	private Timestamp createTime;

	private Timestamp updateTime;

	// status int(2) NOT NULL COMMENT '-1：删除 0：无效 1：有效',
	private int status;

	private String description;

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

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getParseType() {
		return parseType;
	}

	public void setParseType(String parseType) {
		this.parseType = parseType;
	}

	public String getMatchBegin() {
		return matchBegin;
	}

	public void setMatchBegin(String matchBegin) {
		this.matchBegin = matchBegin;
	}

	public String getMatchEnd() {
		return matchEnd;
	}

	public void setMatchEnd(String matchEnd) {
		this.matchEnd = matchEnd;
	}

	public String getMatchCollection() {
		return matchCollection;
	}

	public void setMatchCollection(String matchCollection) {
		this.matchCollection = matchCollection;
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
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

	public List<String> getMatchCollectionList() {
		return matchCollectionList;
	}

	public void setMatchCollectionList(List<String> matchCollectionList) {
		this.matchCollectionList = matchCollectionList;
	}

	@Override
	public String toString() {
		return "SearchRule [ruleId=" + ruleId + ", ruleName=" + ruleName + ", searchField=" + searchField
				+ ", parseType=" + parseType + ", matchBegin=" + matchBegin + ", matchEnd=" + matchEnd
				+ ", matchCollection=" + matchCollection + ", matchCollectionList=" + matchCollectionList + ", indexId="
				+ indexId + ", bizType=" + bizType + ", sysName=" + sysName + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", status=" + status + ", description=" + description + "]";
	}

}
