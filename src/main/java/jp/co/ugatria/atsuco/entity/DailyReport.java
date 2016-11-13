/**
 *
 */
package jp.co.ugatria.atsuco.entity;

import java.util.Date;

import jp.co.ugatria.base.entity.BaseEntity;

/**
 * @author Kashiwaba
 *
 */
public class DailyReport extends BaseEntity {

	private Integer companyId;

	private Integer projectId;

	private Integer userId;

	private Date reportDate;

	private Integer notStartCnt;

	private Integer inWorkCnt;

	private Integer finishCnt;

	private Integer totalCnt;

	private Integer startDelayedCnt;

	private Integer completeDelayedCnt;

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
	 * userIdを取得します.
	 * @return Integer userId
	 */

	public Integer getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param Integer userId
	 */

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * reportDateを取得します.
	 * @return Date reportDate
	 */

	public Date getReportDate() {
		return reportDate;
	}

	/**
	 * reportDate を設定します.
	 * @param Date reportDate
	 */

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	/**
	 * notStartCntを取得します.
	 * @return Integer notStartCnt
	 */

	public Integer getNotStartCnt() {
		return notStartCnt;
	}

	/**
	 * notStartCnt を設定します.
	 * @param Integer notStartCnt
	 */

	public void setNotStartCnt(Integer notStartCnt) {
		this.notStartCnt = notStartCnt;
	}

	/**
	 * inWorkCntを取得します.
	 * @return Integer inWorkCnt
	 */

	public Integer getInWorkCnt() {
		return inWorkCnt;
	}

	/**
	 * inWorkCnt を設定します.
	 * @param Integer inWorkCnt
	 */

	public void setInWorkCnt(Integer inWorkCnt) {
		this.inWorkCnt = inWorkCnt;
	}

	/**
	 * finishCntを取得します.
	 * @return Integer finishCnt
	 */

	public Integer getFinishCnt() {
		return finishCnt;
	}

	/**
	 * finishCnt を設定します.
	 * @param Integer finishCnt
	 */

	public void setFinishCnt(Integer finishCnt) {
		this.finishCnt = finishCnt;
	}

	/**
	 * totalCntを取得します.
	 * @return Integer totalCnt
	 */

	public Integer getTotalCnt() {
		return totalCnt;
	}

	/**
	 * totalCnt を設定します.
	 * @param Integer totalCnt
	 */

	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}

	/**
	 * startDelayedCntを取得します.
	 * @return Integer startDelayedCnt
	 */

	public Integer getStartDelayedCnt() {
		return startDelayedCnt;
	}

	/**
	 * startDelayedCnt を設定します.
	 * @param Integer startDelayedCnt
	 */

	public void setStartDelayedCnt(Integer startDelayedCnt) {
		this.startDelayedCnt = startDelayedCnt;
	}

	/**
	 * completeDelayedCntを取得します.
	 * @return Integer completeDelayedCnt
	 */

	public Integer getCompleteDelayedCnt() {
		return completeDelayedCnt;
	}

	/**
	 * completeDelayedCnt を設定します.
	 * @param Integer completeDelayedCnt
	 */

	public void setCompleteDelayedCnt(Integer completeDelayedCnt) {
		this.completeDelayedCnt = completeDelayedCnt;
	}

}
