package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.rakshitawelfare.pojos.Press;
import org.rakshitawelfare.utilities.ConnectionPool;
import org.rakshitawelfare.utilities.DateUtils;

public class PressDao {
	public void create(Press press) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into press (pressname, pressdescription, pressdate, uploadurl) "
					+ "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, press.getPressname());
			ps.setString(2, press.getPressdescription());
			java.sql.Date dt = new java.sql.Date(press.getPressdate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, press.getUploadurl());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Press press) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update press "
					+ "set pressname = ?, pressdescription = ?, pressdate = ?, uploadurl = ? where pressid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, press.getPressname());
			ps.setString(2, press.getPressdescription());
			java.sql.Date dt = new java.sql.Date(press.getPressdate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, press.getUploadurl());
			ps.setInt(5, press.getPressid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int pressid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from press where pressid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pressid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Press find(int pressid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Press press = new Press();
		try {
			String sql = "select * from press where pressid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pressid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				press.setPressid((pressid));
				press.setPressname((rs.getString("pressname")));
				java.sql.Date dt = rs.getDate("pressdate");
				press.setPressdate(new java.util.Date(dt.getTime()));
				press.setPressdescription(rs.getString("pressdescription"));
				press.setUploadurl(rs.getString("uploadurl"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return press;
	}

	public ArrayList<Press> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Press> listPress = new ArrayList<Press>();
		try {
			String sql = "select * from press";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Press press = new Press();
				press.setPressid(rs.getInt("pressid"));
				press.setPressname((rs.getString("pressname")));
				java.sql.Date dt = rs.getDate("pressdate");
				press.setPressdate(new java.util.Date(dt.getTime()));
				press.setPressdescription(rs.getString("pressdescription"));
				press.setUploadurl(rs.getString("uploadurl"));
				listPress.add(press);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listPress;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		Press press = new Press("asdfd", "2558.0", dt, "pay");
		PressDao pressDao = new PressDao();
		pressDao.create(press);

		// Press press = new Press(9,"Big Data","Diploma");
		// PressDao pressDao = new PressDao();
		// pressDao.edit(press);
		//

//		 PressDao pressDao = new PressDao();
//		 ArrayList<Press> al = pressDao.findAll();
//		 for (Press press : al) {
//		 System.out.println(press);
//		 }
		//
		// PressDao pressDao = new PressDao();
		// ArrayList<Press> al = pressDao.findAllByPressType("diploma");
		// for (Press press : al) {
		// System.out.println(press);
		// }

//		 PressDao pressDao = new PressDao();
//		 pressDao.remove(1);
//		

	}


}
