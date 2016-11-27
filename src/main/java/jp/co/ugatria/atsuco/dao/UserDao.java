/**
 *
 */
package jp.co.ugatria.atsuco.dao;

import org.apache.ibatis.annotations.Param;

import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public interface UserDao {

	User findByPrimary(@Param("userId") Long userId);

	User findByLoginId(@Param("email") String email);

	void insert(User user);

	void update(User user);

	void updateLastLoginDate(@Param("userId") Long userId);

	void delete(@Param("userId") Long userId);

}
