package com.lakala.soa.examples.mybatis.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class IndexMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	private int mId;
	private String indexName;
	private String typeName;
	private Timestamp updateTime;
	private Timestamp createTime;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "IndexMeta [mId=" + mId + ", indexName=" + indexName + ", typeName=" + typeName + ", updateTime="
				+ updateTime + ", createTime=" + createTime + "]";
	}

}
