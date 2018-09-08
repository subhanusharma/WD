package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.rakshitawelfare.pojos.Volunteer;
import org.rakshitawelfare.utilities.ConnectionPool;
import org.rakshitawelfare.utilities.DateUtils;
public class VolunteerDao {
	public void create(Volunteer volunteer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into volunteer (name, mobile, dob, email, state, city, areaofintrest, capabilities, availability, motive, resumeurl, donation, status) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, volunteer.getName());
			ps.setInt(2, volunteer.getMobile());
			java.sql.Date dt = new java.sql.Date(volunteer.getDob().getTime());
			ps.setDate(3, dt);
			ps.setString(4, volunteer.getEmail());
			ps.setString(5, volunteer.getState());
			ps.setString(6, volunteer.getCity());
			ps.setString(7, volunteer.getAreaofintrest());
			ps.setString(8, volunteer.getCapabilities());
			ps.setString(9, volunteer.getAvailability());
			ps.setString(10, volunteer.getMotive());
			ps.setString(11, volunteer.getResumeurl());
			ps.setString(12, volunteer.getDonation());
			ps.setString(13, volunteer.getStatus());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Volunteer volunteer) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update volunteer "
					+ "set name = ?, mobile = ?, dob = ?, email = ?, state = ?, city = ?, areaofintrest = ?, capabilities = ?, availability = ?, motive = ?, resumeurl = ?, donation = ?, status  = ? where volunteerid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, volunteer.getName());
			ps.setInt(2, volunteer.getMobile());
			java.sql.Date dt = new java.sql.Date(volunteer.getDob().getTime());
			ps.setDate(3, dt);
			ps.setString(4, volunteer.getEmail());
			ps.setString(5, volunteer.getState());
			ps.setString(6, volunteer.getCity());
			ps.setString(7, volunteer.getAreaofintrest());
			ps.setString(8, volunteer.getCapabilities());
			ps.setString(9, volunteer.getAvailability());
			ps.setString(10, volunteer.getMotive());
			ps.setString(11, volunteer.getResumeurl());
			ps.setString(12, volunteer.getDonation());
			ps.setString(13, volunteer.getStatus());
			ps.setInt(14, volunteer.getVolunteerid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int volunteerid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from volunteer where volunteerid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Volunteer find(int volunteerid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Volunteer volunteer = new Volunteer();
		try {
			String sql = "select * from volunteer where volunteerid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, volunteerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				volunteer.setVolunteerid((volunteerid));
				volunteer.setName((rs.getString("name")));
				volunteer.setMobile((rs.getInt("mobile")));
				java.sql.Date dt = rs.getDate("dob");
				volunteer.setDob(new java.util.Date(dt.getTime()));
				volunteer.setEmail((rs.getString("email")));
				volunteer.setState(rs.getString("state"));
				volunteer.setCity(rs.getString("city"));
				volunteer.setAreaofintrest((rs.getString("areaofintrest")));
				volunteer.setCapabilities(rs.getString("capabilities"));
				volunteer.setMotive(rs.getString("motive"));
				volunteer.setResumeurl(rs.getString("resumeurl"));
				volunteer.setDonation(rs.getString("donation"));
				volunteer.setStatus(rs.getString("status"));
				
				

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return volunteer;
	}

	public ArrayList<Volunteer> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Volunteer> listVolunteer = new ArrayList<Volunteer>();
		try {
			String sql = "select * from volunteer";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Volunteer volunteer = new Volunteer();
				volunteer.setVolunteerid(rs.getInt("volunteerid"));
				volunteer.setName((rs.getString("name")));
				volunteer.setMobile((rs.getInt("mobile")));
				java.sql.Date dt = rs.getDate("dob");
				volunteer.setDob(new java.util.Date(dt.getTime()));
				volunteer.setEmail((rs.getString("email")));
				volunteer.setState(rs.getString("state"));
				volunteer.setCity(rs.getString("city"));
				volunteer.setAreaofintrest((rs.getString("areaofintrest")));
				volunteer.setCapabilities(rs.getString("capabilities"));
				volunteer.setMotive(rs.getString("motive"));
				volunteer.setResumeurl(rs.getString("resumeurl"));
				volunteer.setDonation(rs.getString("donation"));
				volunteer.setStatus(rs.getString("status"));
				listVolunteer.add(volunteer);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listVolunteer;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		Volunteer volunteer = new Volunteer("asdfd", 5454, dt, "asdfdfsdftgyd",  "asdf454d", "asdf454d", "asd", "asdfsqwewe", "asdfdsadd", "asdqwerwtyrytufd", "asdf@#$%^&%d", "as454787dfd", "pay");
		VolunteerDao volunteerDao = new VolunteerDao();
		volunteerDao.create(volunteer);

		// Volunteer volunteer = new Volunteer(9,"Big Data","Diploma");
		// VolunteerDao volunteerDao = new VolunteerDao();
		// volunteerDao.edit(volunteer);
		//

//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 ArrayList<Volunteer> al = volunteerDao.findAll();
//		 for (Volunteer volunteer : al) {
//		 System.out.println(volunteer);
//		 }
		//
		// VolunteerDao volunteerDao = new VolunteerDao();
		// ArrayList<Volunteer> al = volunteerDao.findAllByVolunteerType("diploma");
		// for (Volunteer volunteer : al) {
		// System.out.println(volunteer);
		// }

//		 VolunteerDao volunteerDao = new VolunteerDao();
//		 volunteerDao.remove(1);
//		

	}


}
