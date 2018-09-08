package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rakshitawelfare.utilities.ConnectionPool;
import org.rakshitawelfare.utilities.DateUtils;
import org.rakshitawelfare.pojos.Activity;

public class ActivityDao {
	public void create(Activity activity) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into activity (activityname, activitydescription, activitydate, uploadurl) "
					+ "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, activity.getActivityname());
			ps.setString(2, activity.getActivitydescription());
			java.sql.Date dt = new java.sql.Date(activity.getActivitydate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, activity.getUploadurl());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Activity activity) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update activity "
					+ "set activityname = ?, activitydescription = ?, activitydate = ?, uploadurl = ? where activityid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, activity.getActivityname());
			ps.setString(2, activity.getActivitydescription());
			java.sql.Date dt = new java.sql.Date(activity.getActivitydate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, activity.getUploadurl());
			ps.setInt(5, activity.getActivityid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int activityid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from activity where activityid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, activityid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Activity find(int activityid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Activity activity = new Activity();
		try {
			String sql = "select * from activity where activityid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, activityid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				activity.setActivityid((activityid));
				activity.setActivityname((rs.getString("activityname")));
				java.sql.Date dt = rs.getDate("activitydate");
				activity.setActivitydate(new java.util.Date(dt.getTime()));
				activity.setActivitydescription(rs.getString("activitydescription"));
				activity.setUploadurl(rs.getString("uploadurl"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return activity;
	}

	public ArrayList<Activity> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Activity> listActivity = new ArrayList<Activity>();
		try {
			String sql = "select * from activity";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Activity activity = new Activity();
				activity.setActivityid(rs.getInt("activityid"));
				activity.setActivityname((rs.getString("activityname")));
				java.sql.Date dt = rs.getDate("activitydate");
				activity.setActivitydate(new java.util.Date(dt.getTime()));
				activity.setActivitydescription(rs.getString("activitydescription"));
				activity.setUploadurl(rs.getString("uploadurl"));
				listActivity.add(activity);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listActivity;
	}

	public static void main(String args[]) {
//		java.util.Date dt = DateUtils.convertDate("22-04-2018");
//		Activity activity = new Activity("asdfd", "2558.0", dt, "pay");
//		ActivityDao activityDao = new ActivityDao();
//		activityDao.create(activity);

		// Activity activity = new Activity(9,"Big Data","Diploma");
		// ActivityDao activityDao = new ActivityDao();
		// activityDao.edit(activity);
		//

		 ActivityDao activityDao = new ActivityDao();
		 ArrayList<Activity> al = activityDao.findAll();
		 for (Activity activity : al) {
		 System.out.println(activity);
		 }
		//
		// ActivityDao activityDao = new ActivityDao();
		// ArrayList<Activity> al = activityDao.findAllByActivityType("diploma");
		// for (Activity activity : al) {
		// System.out.println(activity);
		// }

//		 ActivityDao activityDao = new ActivityDao();
//		 activityDao.remove(1);
//		

	}

}
