package vau.ac.lk.ICAE022022.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vau.ac.lk.ICAE022022.Model.Post;
import vau.ac.lk.ICAE022022.Model.User;
import vau.ac.lk.ICAE022022.Model.UserView;

public class SocialMediaRepo extends Repo {

	public SocialMediaRepo() {
		getDriver();
	}

	public Post getPostwithcomments(int postId) {
		Post post = null;
		List<String> comments = new ArrayList<String>();
		ResultSet postResultSet = getResultFromTable(getDBConnection(),
				"select * from post inner join user on post.user_id=user.user_id where post_id='" + postId + "'");
		ResultSet commentResultSet = getResultFromTable(getDBConnection(),
				"select comment from comment where commented_in='" + postId + "'");
		try {
			while (commentResultSet.next()) {
				comments.add(commentResultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			postResultSet.next();
			User user = new User(postResultSet.getString(6), postResultSet.getString(8), postResultSet.getString(10),
					postResultSet.getInt(9), postResultSet.getString(7));
			post = new Post(postResultSet.getInt(1), postResultSet.getString(4), postResultSet.getString(2),
					postResultSet.getDate(3), user, comments);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	public List<UserView> getUsers() {
		List<UserView> users = new ArrayList<UserView>();
		String sql1 = "select * from user";
		String sql2 = "select count(*) from post where user_id =";
		String sql3 = "select count(*) from comment where commented_by =";

		ResultSet resultSet = getResultFromTable(getDBConnection(), sql1);

		try {
			while (resultSet.next()) {
				int posts = countRows(getDBConnection(), sql2 + "'" + resultSet.getString(1) + "'");
				int comments = countRows(getDBConnection(), sql3 + "'" + resultSet.getString(1) + "'");
				UserView userView = new UserView(resultSet.getString(1), resultSet.getString(3), resultSet.getString(5),
						resultSet.getInt(4), resultSet.getString(2), posts, comments);
				users.add(userView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

}
