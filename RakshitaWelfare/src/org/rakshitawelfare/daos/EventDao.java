package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rakshitawelfare.utilities.DateUtils;
import org.rakshitawelfare.pojos.Event;
import org.rakshitawelfare.utilities.ConnectionPool;

public class EventDao {
	public void create(Event event) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into event (eventname, eventdescription, eventdate, uploadurl) "
					+ "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, event.getEventname());
			ps.setString(2, event.getEventdescription());
			java.sql.Date dt = new java.sql.Date(event.getEventdate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, event.getUploadurl());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Event event) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update event "
					+ "set eventname = ?, eventdescription = ?, eventdate = ?, uploadurl = ? where eventid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, event.getEventname());
			ps.setString(2, event.getEventdescription());
			java.sql.Date dt = new java.sql.Date(event.getEventdate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, event.getUploadurl());
			ps.setInt(5, event.getEventid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int eventid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from event where eventid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eventid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Event find(int eventid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Event event = new Event();
		try {
			String sql = "select * from event where eventid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eventid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				event.setEventid((eventid));
				event.setEventname((rs.getString("eventname")));
				java.sql.Date dt = rs.getDate("eventdate");
				event.setEventdate(new java.util.Date(dt.getTime()));
				event.setEventdescription(rs.getString("eventdescription"));
				event.setUploadurl(rs.getString("uploadurl"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return event;
	}

	public ArrayList<Event> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Event> listEvent = new ArrayList<Event>();
		try {
			String sql = "select * from event";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event event = new Event();
				event.setEventid(rs.getInt("eventid"));
				event.setEventname((rs.getString("eventname")));
				java.sql.Date dt = rs.getDate("eventdate");
				event.setEventdate(new java.util.Date(dt.getTime()));
				event.setEventdescription(rs.getString("eventdescription"));
				event.setUploadurl(rs.getString("uploadurl"));
				listEvent.add(event);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listEvent;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		Event event = new Event("asdfd", "2558.0", dt, "pay");
		EventDao eventDao = new EventDao();
		eventDao.create(event);

		// Event event = new Event(9,"Big Data","Diploma");
		// EventDao eventDao = new EventDao();
		// eventDao.edit(event);
		//

//		 EventDao eventDao = new EventDao();
//		 ArrayList<Event> al = eventDao.findAll();
//		 for (Event event : al) {
//		 System.out.println(event);
//		 }
		//
		// EventDao eventDao = new EventDao();
		// ArrayList<Event> al = eventDao.findAllByEventType("diploma");
		// for (Event event : al) {
		// System.out.println(event);
		// }

//		 EventDao eventDao = new EventDao();
//		 eventDao.remove(1);
//		

	}

}

