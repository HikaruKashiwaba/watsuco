/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.ProjectRank;

/**
 * @author Kashiwaba
 *
 */
public interface ProjectRankDao {

	List<ProjectRank> findByProjectId(@Param("companyId") Long companyId, @Param("projectId") Long projectId);

	void insert(ProjectRank entity);
}
