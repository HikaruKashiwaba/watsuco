/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.Task;

/**
 * @author Kashiwaba
 *
 */
public interface TaskDao {

	Task findByPrimary(@Param("taskId") Long taskId);

	void insert(Task task);

	void update(Task task);

	void delete(@Param("taskId") Long taskId);
}
