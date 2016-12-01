/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.Task;

/**
 * @author Kashiwaba
 *
 */
public interface TaskDao {

	Task findByPrimary(@Param("companyId") Long companyId, @Param("projectId") Long projectId, @Param("taskId") Long taskId);

	List<Task> findByProjectId(@Param("companyId") Long companyId, @Param("projectId") Long projectId);

	void insert(Task task);

	void update(Task task);

	void updateUserAndStatus(Task task);

	void delete(@Param("companyId") Long companyId, @Param("projectId") Long projectId, @Param("taskId") Long taskId);
}
