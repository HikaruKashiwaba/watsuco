/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public interface UserDao {

	User findByPrimary(@Param("userId") Long userId);

	User findByLoginId(@Param("email") String email);

	List<User> findByProjectId(@Param("companyId") Long companyId, @Param("projectId") Long projectId);

	List<User> findAll(@Param("companyId") Long companyId);

	void insert(User user);

	void update(User user);

	void updateLastLoginDate(@Param("userId") Long userId);

	void delete(@Param("userId") Long userId);

}
