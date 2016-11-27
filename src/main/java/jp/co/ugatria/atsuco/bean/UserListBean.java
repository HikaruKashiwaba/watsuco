/**
 *
 */
package jp.co.ugatria.atsuco.bean;

import java.util.List;

import jp.co.ugatria.atsuco.entity.User;

/**
 * @author Kashiwaba
 *
 */
public class UserListBean extends BaseBean {

	private List<User> users;

	/**
	 * usersを取得します.
	 * @return List<User> users
	 */

	public List<User> getUsers() {
		return users;
	}

	/**
	 * users を設定します.
	 * @param List<User> users
	 */

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
