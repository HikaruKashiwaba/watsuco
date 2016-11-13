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
public class ContractHistory extends BaseEntity {

	private Integer companyId;

	private Integer seqNo;

	private Date contractStartDate;

	private Integer userCount;

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
	 * seqNoを取得します.
	 * @return Integer seqNo
	 */

	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * seqNo を設定します.
	 * @param Integer seqNo
	 */

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * contractStartDateを取得します.
	 * @return Date contractStartDate
	 */

	public Date getContractStartDate() {
		return contractStartDate;
	}

	/**
	 * contractStartDate を設定します.
	 * @param Date contractStartDate
	 */

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	/**
	 * userCountを取得します.
	 * @return Integer userCount
	 */

	public Integer getUserCount() {
		return userCount;
	}

	/**
	 * userCount を設定します.
	 * @param Integer userCount
	 */

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

}
