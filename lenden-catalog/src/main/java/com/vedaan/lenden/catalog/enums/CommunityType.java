/**
 * 
 */
package com.vedaan.lenden.catalog.enums;

/**
 * @author mayank
 *
 */
public enum CommunityType {

	COLLEGE("COLLEGE"), CITY("CITY"), LOCAL("LOCAL"), OTHER("OTHER");

	private final String name;

	public String value() {
		return name();
	}

	public static CommunityType fromValue(String v) {
		if (null == v || "".equals(v) || "null".equals(v.toLowerCase()))
			return null;

		return valueOf(v.toUpperCase());
	}

	public static CommunityType fromString(String name) {
		if (name != null) {
			for (CommunityType type : CommunityType.values()) {
				if (name.equalsIgnoreCase(type.toString()))
					return type;
			}
		}
		return null;
	}

	private CommunityType(String s) {
		name = s;
	}

	public boolean equalsName(String otherName) {

		return (otherName == null || "".equals(otherName) || "null".equals(otherName.toLowerCase())) ? false
				: name.equals(otherName);
	}

	public String toString() {
		return name;
	}
}
