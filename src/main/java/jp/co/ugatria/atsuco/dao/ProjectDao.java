/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.Project;

/**
 * @author Kashiwaba
 *
 */
public interface ProjectDao {

	Project findByPrimary(@Param("companyId") Long companyId, @Param("projectId") Long projectId);

	List<Project> findAll(@Param("companyId") Long companyId);

	List<Project> findByUserId(@Param("companyId") Long companyId, @Param("userId") Long userId);

	void insert(Project entity);

	void update(Project entity);

	void delete(@Param("companyId") Long companyId, @Param("projectId") Long projectId);
}
