package jp.co.ugatria.base.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4005538167438363517L;

	private Date createDate;

	private Date updateDate;

	/* 作成者ID */
	private Long createUserId;

	/* 更新者ID */
	private Long updateUserId;

	private String delFlg;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * createDateを取得します.
	 * @return Date createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * createDate を設定します.
	 * @param Date createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * updateDateを取得します.
	 * @return Date updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * updateDate を設定します.
	 * @param Date updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * createUserIdを取得します.
	 * @return String createUserId
	 */
	public Long getCreateUserId() {
		return createUserId;
	}

	/**
	 * createUserId を設定します.
	 * @param String createUserId
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * updateUserIdを取得します.
	 * @return String updateUserId
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * updateUserId を設定します.
	 * @param String updateUserId
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * delFlgを取得します.
	 * @return String delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * delFlg を設定します.
	 * @param String delFlg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
}
