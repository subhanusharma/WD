package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rakshitawelfare.pojos.Users;
import org.rakshitawelfare.utilities.ConnectionPool;
import org.rakshitawelfare.utilities.DateUtils;;

public class UsersDao {
	public void create(Users users) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into users (username, password, name, designation, dob) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, users.getUsername());
			ps.setString(2, users.getPassword());
			ps.setString(3, users.getName());
			ps.setString(4, users.getDesignation());
			java.sql.Date dt = new java.sql.Date(users.getDob().getTime());
			ps.setDate(5, dt);
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Users users) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update users "
					+ "set usersname = ?, password = ?, name = ?, designation = ? where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, users.getUsername());
			ps.setString(2, users.getPassword());
			ps.setString(3, users.getName());
			ps.setString(4, users.getDesignation());
			java.sql.Date dt = new java.sql.Date(users.getDob().getTime());
			ps.setDate(5, dt);
			ps.setInt(6, users.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	public int checkAvailablity(String uname) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString("username").equals(uname)) {
					return rs.getInt("uid");
				}
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return -1;
	}
	
	public static int checkAvailablity(String uname, String pwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString("username").equals(uname)) {
					if(rs.getString("password").equals(pwd)){
						return rs.getInt("uid");
					}
				}
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return -1;
	}
	
	public Users authenticate(String un, String pwd) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users users = new Users();
		try {
			String sql = "select * from users where username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, un);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				users.setUserid(rs.getInt("userid"));
				users.setUsername((rs.getString("username")));
				users.setPassword((rs.getString("password")));
				users.setName((rs.getString("name")));
				users.setDesignation((rs.getString("designation")));
				java.sql.Date dt = rs.getDate("dob");
				users.setDob(new java.util.Date(dt.getTime()));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return users;
	}

	public Users find(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users users = new Users();
		try {
			String sql = "select * from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				users.setUserid((userid));
				users.setUsername((rs.getString("username")));
				users.setPassword((rs.getString("password")));
				users.setName((rs.getString("name")));
				users.setDesignation((rs.getString("designation")));
				java.sql.Date dt = rs.getDate("dob");
				users.setDob(new java.util.Date(dt.getTime()));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return users;
	}

	public ArrayList<Users> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Users> listUsers = new ArrayList<Users>();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users users = new Users();
				users.setUserid(rs.getInt("userid"));
				users.setUsername((rs.getString("username")));
				users.setPassword((rs.getString("password")));
				users.setName((rs.getString("name")));
				users.setDesignation((rs.getString("designation")));
				java.sql.Date dt = rs.getDate("dob");
				users.setDob(new java.util.Date(dt.getTime()));
					listUsers.add(users);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listUsers;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		Users users = new Users("asdfd", "2558.0", "pay", "paydlfgjlfdkjgldfj", dt);
		UsersDao usersDao = new UsersDao();
		usersDao.create(users);

		// Users users = new Users(9,"Big Data","Diploma");
		// UsersDao usersDao = new UsersDao();
		// usersDao.edit(users);
		//

//		 UsersDao usersDao = new UsersDao();
//		 ArrayList<Users> al = usersDao.findAll();
//		 for (Users users : al) {
//		 System.out.println(users);
//		 }
		//
		// UsersDao usersDao = new UsersDao();
		// ArrayList<Users> al = usersDao.findAllByUsersType("diploma");
		// for (Users users : al) {
		// System.out.println(users);
		// }

//		 UsersDao usersDao = new UsersDao();
//		 usersDao.remove(1);
//		

	}

}
