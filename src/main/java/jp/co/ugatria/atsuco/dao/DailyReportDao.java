/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.DailyReport;

/**
 * @author Kashiwaba
 *
 */
public interface DailyReportDao {

	List<DailyReport> sumStatusCnt(@Param("companyId") Long companyId,
			@Param("projectId") Long projectId);

	List<DailyReport> sumDelayCnt(@Param("companyId") Long companyId,
			@Param("projectId") Long projectId);

	void inset(@Param("today") String today);
}
