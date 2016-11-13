/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class ProjectRank extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private Integer rankNo;

	private String rankName;

	private Integer point;

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
	 * rankNoを取得します.
	 * @return Integer rankNo
	 */

	public Integer getRankNo() {
		return rankNo;
	}

	/**
	 * rankNo を設定します.
	 * @param Integer rankNo
	 */

	public void setRankNo(Integer rankNo) {
		this.rankNo = rankNo;
	}

	/**
	 * rankNameを取得します.
	 * @return String rankName
	 */

	public String getRankName() {
		return rankName;
	}

	/**
	 * rankName を設定します.
	 * @param String rankName
	 */

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	/**
	 * pointを取得します.
	 * @return Integer point
	 */

	public Integer getPoint() {
		return point;
	}

	/**
	 * point を設定します.
	 * @param Integer point
	 */

	public void setPoint(Integer point) {
		this.point = point;
	}

}
