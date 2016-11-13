/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class TaskCategory extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private Integer categoryId;

	private String categoryName;

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
	 * projectIdを取得します.
	 * @return Integer projectId
	 */

	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param Integer projectId
	 */

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * categoryIdを取得します.
	 * @return Integer categoryId
	 */

	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * categoryId を設定します.
	 * @param Integer categoryId
	 */

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * categoryNameを取得します.
	 * @return String categoryName
	 */

	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * categoryName を設定します.
	 * @param String categoryName
	 */

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
