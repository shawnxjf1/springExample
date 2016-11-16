package com.person.constants;

/**
 * 
 * @author lakala-shawn
 *
 */
public enum SearchTypeEnum {
	// 用枚举的体会：数据库对应的值变了的话不用改多少代码只要稍微改一点枚举就可以了，比如以前DATE("date")编程了DATE("1")
	/**
	 * 后续可添加返回类型
	 */
	DATE("1"), NUMBER("2"), STRING("4"), COLLECTION("3");

	// DATE("data"), NUMBER("number"), STRING("string"),
	// COLLECTION("collection");

	private String value;

	private SearchTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
