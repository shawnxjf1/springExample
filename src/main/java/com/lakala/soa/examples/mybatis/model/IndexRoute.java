package com.lakala.soa.examples.mybatis.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class IndexRoute implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rId;

	/**
	 * 查询开始时间
	 */
	private Timestamp startTime;

	/**
	 * 查询结束时间
	 */
	private Timestamp endTime;

	/**
	 * es index名字
	 */
	private String indexName;

	/**
	 * es type名字
	 */
	private String typeName;

	/**
	 * 业务类型，比如是posp 还是tv数据
	 */
	private String busiType;

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "IndexRoute [rId=" + rId + ", startTime=" + startTime + ", endTime=" + endTime + ", indexName="
				+ indexName + ", typeName=" + typeName + ", busiType=" + busiType + "]";
	}

}
