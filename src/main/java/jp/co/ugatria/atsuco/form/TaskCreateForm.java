package jp.co.ugatria.atsuco.form;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlAttribute;

@XmlRootElement
public class TaskCreateForm {

	@FormParam("companyId")
	private String companyId;

	@FormParam("projectId")
	private String projectId;

	@FormParam("title")
	private String title;

	@FormParam("contents")
	private String contents;

	@FormParam("startDeadlineDate")
	private String startDeadlineDate;

	@FormParam("endDeadlineDate")
	private String endDeadlineDate;

	@FormParam("rankNo")
	private String rankNo;

	@FormParam("userId")
	private String userId;

	@FormParam("comment")
	private String comment;

	/**
	 * companyIdを取得します.
	 * @return String companyId
	 */

	public String getCompanyId() {
		return companyId;
	}

	/**
	 * companyId を設定します.
	 * @param String companyId
	 */

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * projectIdを取得します.
	 * @return String projectId
	 */

	@XmlAttribute("projectId")
	public String getProjectId() {
		return projectId;
	}

	/**
	 * projectId を設定します.
	 * @param String projectId
	 */

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * titleを取得します.
	 * @return String title
	 */

	@XmlAttribute("title")
	public String getTitle() {
		return title;
	}

	/**
	 * title を設定します.
	 * @param String title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * contentsを取得します.
	 * @return String contents
	 */

	@XmlAttribute("contents")
	public String getContents() {
		return contents;
	}

	/**
	 * contents を設定します.
	 * @param String contents
	 */

	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * startDeadlineDateを取得します.
	 * @return String startDeadlineDate
	 */

	@XmlAttribute("startDeadlineDate")
	public String getStartDeadlineDate() {
		return startDeadlineDate;
	}

	/**
	 * startDeadlineDate を設定します.
	 * @param String startDeadlineDate
	 */

	public void setStartDeadlineDate(String startDeadlineDate) {
		this.startDeadlineDate = startDeadlineDate;
	}

	/**
	 * endDeadlineDateを取得します.
	 * @return String endDeadlineDate
	 */

	@XmlAttribute("endDeadlineDate")
	public String getEndDeadlineDate() {
		return endDeadlineDate;
	}

	/**
	 * endDeadlineDate を設定します.
	 * @param String endDeadlineDate
	 */

	public void setEndDeadlineDate(String endDeadlineDate) {
		this.endDeadlineDate = endDeadlineDate;
	}

	/**
	 * rankNoを取得します.
	 * @return String rankNo
	 */

	@XmlAttribute("rankNo")
	public String getRankNo() {
		return rankNo;
	}

	/**
	 * rankNo を設定します.
	 * @param String rankNo
	 */

	public void setRankNo(String rankNo) {
		this.rankNo = rankNo;
	}

	/**
	 * userIdを取得します.
	 * @return String userId
	 */

	@XmlAttribute("userId")
	public String getUserId() {
		return userId;
	}

	/**
	 * userId を設定します.
	 * @param String userId
	 */

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * commentを取得します.
	 * @return String comment
	 */

	public String getComment() {
		return comment;
	}

	/**
	 * comment を設定します.
	 * @param String comment
	 */

	public void setComment(String comment) {
		this.comment = comment;
	}
}
