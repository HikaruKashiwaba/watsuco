/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import jp.co.ugatria.atsuco.entity.TaskComment;

import org.apache.ibatis.annotations.Param;

/**
 * @author Kashiwaba
 *
 */
public interface TaskCommentDao {


	TaskComment findByPrimary(
			@Param("taskId") Long taskId,
			@Param("commentNo") Integer commentNo);

	void insert(TaskComment task);

	void update(TaskComment task);

	void delete(
			@Param("taskId") Long taskId,
			@Param("commentNo") Integer commentNo);

}
