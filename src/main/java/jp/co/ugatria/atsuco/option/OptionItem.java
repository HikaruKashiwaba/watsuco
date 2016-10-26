package jp.co.ugatria.atsuco.option;

public enum OptionItem {

	GENDER_0("GENDER", "0", "男性"),
	GENDER_1("GENDER", "1", "女性"),
	CARE_LV_00("CARE_LV", "00", "要支援1"),
	CARE_LV_01("CARE_LV", "01", "要支援2"),
	CARE_LV_10("CARE_LV", "10", "要介護1"),
	CARE_LV_11("CARE_LV", "11", "要介護2"),
	CARE_LV_12("CARE_LV", "12", "要介護3"),
	CARE_LV_13("CARE_LV", "13", "要介護4"),
	CARE_LV_14("CARE_LV", "14", "要介護5"),
	INTEREST_LV_0("INTEREST_LV", "0", ""),
	INTEREST_LV_1("INTEREST_LV", "1", "している"),
	INTEREST_LV_2("INTEREST_LV", "2", "してみたい"),
	INTEREST_LV_3("INTEREST_LV", "3", "興味がある"),
	MOVE_LV_0("MOVE_LV", "0", ""),
	MOVE_LV_1("MOVE_LV", "1", "自立"),
	MOVE_LV_2("MOVE_LV", "2", "見守り"),
	MOVE_LV_3("MOVE_LV", "3", "一部介助"),
	MOVE_LV_4("MOVE_LV", "4", "全介助"),
	ATTAINMENT_0("ATTAINMENT", "0", "達成"),
	ATTAINMENT_1("ATTAINMENT", "1", "一部"),
	ATTAINMENT_2("ATTAINMENT", "2", "未達"),
	UMU_0("UMU", "0", "無"),
	UMU_1("UMU", "1", "有"),
	;

	private String type;
	private String value;
	private String name;

	private OptionItem(String type, String value, String name) {
		this.type = type;
		this.value = value;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public static String convertName(String type, String value) {
		for (OptionItem item : values()) {
			if (item.getType().equals(type)
					&& item.getValue().equals(value)) {
				return item.getName();
			}
		}
		return "";
	}

	public static String convertName(String type, Integer value) {
		if (value != null) {
			String valueS = value.toString();
			for (OptionItem item : values()) {
				if (item.getType().equals(type)
						&& item.getValue().equals(valueS)) {
					return item.getName();
				}
			}
		}
		return "";
	}
}
