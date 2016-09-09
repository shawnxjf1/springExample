package com.data;

import java.util.List;

/**
 * 规则检索条件
 * 
 * @author lakala-shawn
 *
 */
public class RuleRetrieveCond {

	private String matchBegin;

	private String matchEnd;

	private List<String> matchedCollectionList;

	private String parseType;

	private String searchField;

	private String bizType;

	private String sysName;

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

	public List<String> getMatchedCollectionList() {
		return matchedCollectionList;
	}

	public void setMatchedCollectionList(List<String> matchedCollectionList) {
		this.matchedCollectionList = matchedCollectionList;
	}

	public String getParseType() {
		return parseType;
	}

	public void setParseType(String parseType) {
		this.parseType = parseType;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
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

	@Override
	public String toString() {
		return "RuleRetrieveCond [matchBegin=" + matchBegin + ", matchEnd=" + matchEnd + ", matchedCollectionList="
				+ matchedCollectionList + ", parseType=" + parseType + ", searchField=" + searchField + ", bizType="
				+ bizType + ", sysName=" + sysName + "]";
	}

}
