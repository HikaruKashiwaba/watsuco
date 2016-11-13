package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

public class Company extends BaseEntity {

	private Integer companyId;

	private String companyName;

	/**
	 * companyIdを取得します.
	 * @return Integer companyId
	 */

	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param Integer companyId
	 */

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * companyNameを取得します.
	 * @return String companyName
	 */

	public String getCompanyName() {
		return companyName;
	}

	/**
	 * companyName を設定します.
	 * @param String companyName
	 */

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
