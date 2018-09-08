package org.rakshitawelfare.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.rakshitawelfare.pojos.PhotoGallery;
import org.rakshitawelfare.utilities.ConnectionPool;
import org.rakshitawelfare.utilities.DateUtils;

public class PhotoGalleryDao {
	public void create(PhotoGallery photo) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into photogallery (photoname, photodescription, photodate, uploadurl) "
					+ "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, photo.getPhotoname());
			ps.setString(2, photo.getPhotodescription());
			java.sql.Date dt = new java.sql.Date(photo.getPhotodate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, photo.getUploadurl());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(PhotoGallery photo) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update photogallery "
					+ "set photoname = ?, photodescription = ?, photodate = ?, uploadurl = ? where photoid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, photo.getPhotoname());
			ps.setString(2, photo.getPhotodescription());
			java.sql.Date dt = new java.sql.Date(photo.getPhotodate().getTime());
			ps.setDate(3, dt);
			ps.setString(4, photo.getUploadurl());
			ps.setInt(5, photo.getPhotoid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int photoid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from photogallery where photoid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, photoid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to remove row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public PhotoGallery find(int photoid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		PhotoGallery photo = new PhotoGallery();
		try {
			String sql = "select * from photogallery where photoid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, photoid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				photo.setPhotoid((photoid));
				photo.setPhotoname((rs.getString("photoname")));
				java.sql.Date dt = rs.getDate("photodate");
				photo.setPhotodate(new java.util.Date(dt.getTime()));
				photo.setPhotodescription(rs.getString("photodescription"));
				photo.setUploadurl(rs.getString("uploadurl"));

			}
		} catch (SQLException sq) {
			System.out.println("Unable to find row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return photo;
	}

	public ArrayList<PhotoGallery> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<PhotoGallery> listPhoto = new ArrayList<PhotoGallery>();
		try {
			String sql = "select * from photogallery";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhotoGallery photo = new PhotoGallery();
				photo.setPhotoid(rs.getInt("photoid"));
				photo.setPhotoname((rs.getString("photoname")));
				java.sql.Date dt = rs.getDate("photodate");
				photo.setPhotodate(new java.util.Date(dt.getTime()));
				photo.setPhotodescription(rs.getString("photodescription"));
				photo.setUploadurl(rs.getString("uploadurl"));
				listPhoto.add(photo);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to find all rows.");
		} finally {
			pool.putConnection(conn);
		}
		return listPhoto;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("22-04-2018");
		PhotoGallery photo = new PhotoGallery("asdfd", "2558.0", dt, "pay");
		PhotoGalleryDao photoDao = new PhotoGalleryDao();
		photoDao.create(photo);

		// Photo photo = new Photo(9,"Big Data","Diploma");
		// PhotoDao photoDao = new PhotoDao();
		// photoDao.edit(photo);
		//

//		 PhotoDao photoDao = new PhotoDao();
//		 ArrayList<Photo> al = photoDao.findAll();
//		 for (Photo photo : al) {
//		 System.out.println(photo);
//		 }
		//
		// PhotoDao photoDao = new PhotoDao();
		// ArrayList<Photo> al = photoDao.findAllByPhotoType("diploma");
		// for (Photo photo : al) {
		// System.out.println(photo);
		// }

//		 PhotoDao photoDao = new PhotoDao();
//		 photoDao.remove(1);
//		

	}


}
