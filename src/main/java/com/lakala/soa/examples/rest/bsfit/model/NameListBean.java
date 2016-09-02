/**
 * 
 */
package com.lakala.soa.examples.rest.bsfit.model;

import java.io.Serializable;

//import org.apache.ibatis.type.Alias;

/**
 * @author Administrator
 *
 */

public class NameListBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int Id;
	private String UniqueId;
	private String Name;
	private String Status;
	private String ExpiressDate;
	private String Comments;
	private String Source;
	private String Tag;
	private String Type;
	private String CreateTime;
	private String UpdateTime;
	private String ModifyUser;
	private String CheckStatus;
	private String Bussiness;
	private String HisId;

	public NameListBean() {
	};

	@Override
	public String toString() {
		return "NameListBean [Id=" + Id + ", UniqueId=" + UniqueId + ", Name=" + Name + ", Status=" + Status
				+ ", ExpiressDate=" + ExpiressDate + ", Comments=" + Comments + ", Source=" + Source + ", Tag=" + Tag
				+ ", Type=" + Type + ", CreateTime=" + CreateTime + ", UpdateTime=" + UpdateTime + ", ModifyUser="
				+ ModifyUser + ", CheckStatus=" + CheckStatus + ", Bussiness=" + Bussiness + ", HisId=" + HisId + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUniqueId() {
		return UniqueId;
	}

	public void setUniqueId(String uniqueId) {
		UniqueId = uniqueId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getExpiressDate() {
		return ExpiressDate;
	}

	public void setExpiressDate(String expiressDate) {
		ExpiressDate = expiressDate;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}

	public String getModifyUser() {
		return ModifyUser;
	}

	public void setModifyUser(String modifyUser) {
		ModifyUser = modifyUser;
	}

	public String getCheckStatus() {
		return CheckStatus;
	}

	public void setCheckStatus(String checkStatus) {
		CheckStatus = checkStatus;
	}

	public String getBussiness() {
		return Bussiness;
	}

	public void setBussiness(String bussiness) {
		Bussiness = bussiness;
	}

	public String getHisId() {
		return HisId;
	}

	public void setHisId(String hisId) {
		HisId = hisId;
	}

	public NameListBean(int id, String uniqueId, String name, String status, String expiressDate, String comments,
			String source, String tag, String type, String createTime, String updateTime, String modifyUser,
			String checkStatus, String bussiness, String hisId) {
		super();
		Id = id;
		UniqueId = uniqueId;
		Name = name;
		Status = status;
		ExpiressDate = expiressDate;
		Comments = comments;
		Source = source;
		Tag = tag;
		Type = type;
		CreateTime = createTime;
		UpdateTime = updateTime;
		ModifyUser = modifyUser;
		CheckStatus = checkStatus;
		Bussiness = bussiness;
		HisId = hisId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bussiness == null) ? 0 : Bussiness.hashCode());
		result = prime * result + ((CheckStatus == null) ? 0 : CheckStatus.hashCode());
		result = prime * result + ((Comments == null) ? 0 : Comments.hashCode());
		result = prime * result + ((CreateTime == null) ? 0 : CreateTime.hashCode());
		result = prime * result + ((ExpiressDate == null) ? 0 : ExpiressDate.hashCode());
		result = prime * result + ((HisId == null) ? 0 : HisId.hashCode());
		result = prime * result + Id;
		result = prime * result + ((ModifyUser == null) ? 0 : ModifyUser.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Source == null) ? 0 : Source.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((Tag == null) ? 0 : Tag.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + ((UniqueId == null) ? 0 : UniqueId.hashCode());
		result = prime * result + ((UpdateTime == null) ? 0 : UpdateTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameListBean other = (NameListBean) obj;
		if (Bussiness == null) {
			if (other.Bussiness != null)
				return false;
		} else if (!Bussiness.equals(other.Bussiness))
			return false;
		if (CheckStatus == null) {
			if (other.CheckStatus != null)
				return false;
		} else if (!CheckStatus.equals(other.CheckStatus))
			return false;
		if (Comments == null) {
			if (other.Comments != null)
				return false;
		} else if (!Comments.equals(other.Comments))
			return false;
		if (CreateTime == null) {
			if (other.CreateTime != null)
				return false;
		} else if (!CreateTime.equals(other.CreateTime))
			return false;
		if (ExpiressDate == null) {
			if (other.ExpiressDate != null)
				return false;
		} else if (!ExpiressDate.equals(other.ExpiressDate))
			return false;
		if (HisId == null) {
			if (other.HisId != null)
				return false;
		} else if (!HisId.equals(other.HisId))
			return false;
		if (Id != other.Id)
			return false;
		if (ModifyUser == null) {
			if (other.ModifyUser != null)
				return false;
		} else if (!ModifyUser.equals(other.ModifyUser))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Source == null) {
			if (other.Source != null)
				return false;
		} else if (!Source.equals(other.Source))
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (Tag == null) {
			if (other.Tag != null)
				return false;
		} else if (!Tag.equals(other.Tag))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (UniqueId == null) {
			if (other.UniqueId != null)
				return false;
		} else if (!UniqueId.equals(other.UniqueId))
			return false;
		if (UpdateTime == null) {
			if (other.UpdateTime != null)
				return false;
		} else if (!UpdateTime.equals(other.UpdateTime))
			return false;
		return true;
	}

}
