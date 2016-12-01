/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.ProjectTeam;

/**
 * @author Kashiwaba
 *
 */
public interface ProjectTeamDao {

	List<ProjectTeam> findByProjectId(@Param("companyId") Long companyId, @Param("userId") Long userId);

	void insert(ProjectTeam entity);

	void deleteByProjectId(@Param("companyId") Long companyId, @Param("projectId") Long projectId);
}
