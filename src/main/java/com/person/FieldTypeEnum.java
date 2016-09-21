package com.person;

public enum FieldTypeEnum {
	/**
	 * 后续可添加返回类型
	 */
	NUMBER("Number", 1), STRING("String", 2), DATE("Date", 3), COLLECTION("Collection", 4);

	private String name;

	private int value;

	private FieldTypeEnum(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * 检测枚举是否相等
	 * 
	 * @param value
	 * @param ftype
	 * @return
	 */
	public static boolean isEquals(int value, FieldTypeEnum ftype) {
		return value == ftype.getValue();
	}

	/**
	 * 通过值得到fieldTypeEnum 对象。
	 * 
	 * 有该函数可以在别人类 priva FieldTypeEnum fieldType;(用FieldTypeEnum 不用 int
	 * 这样不会赋值了enum之外的值)
	 * 
	 * @param value
	 * @return
	 */
	public static FieldTypeEnum get(int value) {
		FieldTypeEnum ftype = null;
		switch (value) {
		case 1:
			ftype = FieldTypeEnum.NUMBER;
			break;
		case 2:
			ftype = FieldTypeEnum.STRING;
			break;
		case 3:
			ftype = FieldTypeEnum.DATE;
			break;
		case 4:
			ftype = FieldTypeEnum.COLLECTION;
			break;
		default:
			;
		}
		return ftype;
	}

}
