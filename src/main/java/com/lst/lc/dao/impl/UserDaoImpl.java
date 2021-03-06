package com.lst.lc.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lst.lc.dao.RankDao;
import com.lst.lc.dao.UserDao;
import com.lst.lc.entities.Course;
import com.lst.lc.entities.RelUser;
import com.lst.lc.entities.RelUserCourse;
import com.lst.lc.entities.RelUserCourseId;
import com.lst.lc.entities.RelUserId;
import com.lst.lc.entities.User;
import com.lst.lc.utils.SetUtils;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Autowired
	@Qualifier("rankDao")
	private RankDao rankDao;

	@Override
	public void addUser(User user) {
		save(user);
	}

	@Override
	public void updateUser(User user) {
		update(user);
	}

	@Override
	public User getById(int userId) {
		return get(User.class, userId);
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	@Override
	public User validateUser(String email, String password) {
		String hql = "from User as user where user.email = ?";
		List<User> users = query(hql).setString(0, email).list();
		if (users.size() != 1)
			return null;
		else
			return users.get(0);
	}

	@Override
	public void addIntegral(int userId, int integral) {
		String hql = "update User as user set user.integral = user.integral + ?, user.rank = ? where user.userId = ?";
		String rank = rankDao.getRank(integral);
		Query query = query(hql).setInteger(0, integral).setString(1, rank)
				.setInteger(2, userId);
		query.executeUpdate();
	}

	@Override
	public boolean ifEmailExisted(String email) {
		String hql = "from User as user where user.email = ?";
		Query query = query(hql).setString(0, email);
		List<User> users = query.list();
		if (users.size() != 0)
			return true;
		return false;
	}

	@Override
	public void update(int userId, String gender, String avatar, String motto,
			String city) {
		String hql = "update User as user set user.gender = ?, user.avatar = ?, user.motto = ?, user.city = ? where user.userId = ?";
		Query query = query(hql);
		query.setString(0, gender).setString(1, avatar).setString(2, motto)
				.setString(3, city).setInteger(4, userId).executeUpdate();

	}

	@Override
	public void learn(int userId, int courseId) {
		User user = get(User.class, userId);
		Course course = get(Course.class, courseId);
		RelUserCourseId id = new RelUserCourseId(userId, courseId);
		RelUserCourse userCourse = new RelUserCourse(id, course, user, new Date(), 0);
		save(userCourse);
		getSession().flush();
	}

	@Override
	public List<User> getTopFive() {
		String hql = "from User as user order by user.blogs.size desc";
		Query query = query(hql).setMaxResults(5);
		return query.list();
	}

        @Override
        public void addRel(int uid1, int uid2) {
                System.out.println("ddd");
               RelUserId id = new RelUserId(uid1, uid2);
               User user1 = getById(uid1);
               User user2 = getById(uid2);
               RelUser relUser = new RelUser(id, user1, user2, 0, new Date());
               save(relUser);
               getSession().flush();
        }

        @Override
        public List<User> getFriends(int uid) {
                User user = getById(uid);
                List<User> users = SetUtils.mergeFriend(user.getRelUsersForUserId1(), user.getRelUsersForUserId2(), user, 1);
                return users;
        }

        @Override
        public List<User> getValidateFriends(int uid) {
                User user = getById(uid);
                List<User> users = SetUtils.mergeFriend(user.getRelUsersForUserId1(), user.getRelUsersForUserId2(), user, 0);
                return users;
        }

        @Override
        public void validateFriend(int uid1, int uid2, int state) {
                String hql = "update RelUser as relUser set relUser.state = ? where relUser.id.userId1 = ? and relUser.id.userId2 = ?";
                Query query = query(hql).setInteger(0, state).setInteger(1, uid1).setInteger(2, uid2);
                query.executeUpdate();
        }

        @Override
        public boolean ifFriend(int uid1, int uid2) {
                List<User> friends = getFriends(uid1);
                User user = getById(uid2);
                if(friends.contains(user))
                        return true;
                return false;
        }

        @Override
        public long count() {
                String hql = "select count(*) from User";
                Query query = query(hql);
                long res = (long) query.uniqueResult();
                return res;
        }

}
