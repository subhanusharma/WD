package org.rakshitawelfare.pojos;

import java.util.Date;

public class PhotoGallery {
	int photoid;
	String photoname;
	String photodescription;
	Date photodate;
	String uploadurl;
	public PhotoGallery() {
		super();
	}
	public PhotoGallery(int photoid, String photoname, String photodescription, Date photodate, String uploadurl) {
		super();
		this.photoid = photoid;
		this.photoname = photoname;
		this.photodescription = photodescription;
		this.photodate = photodate;
		this.uploadurl = uploadurl;
	}
	
	public PhotoGallery(String photoname, String photodescription, Date photodate, String uploadurl) {
		super();
		this.photoname = photoname;
		this.photodescription = photodescription;
		this.photodate = photodate;
		this.uploadurl = uploadurl;
	}
	@Override
	public String toString() {
		return "PhotoGallery [photoid=" + photoid + ", photoname=" + photoname + ", photodescription="
				+ photodescription + ", photodate=" + photodate + ", uploadurl=" + uploadurl + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((photodate == null) ? 0 : photodate.hashCode());
		result = prime * result + ((photodescription == null) ? 0 : photodescription.hashCode());
		result = prime * result + photoid;
		result = prime * result + ((photoname == null) ? 0 : photoname.hashCode());
		result = prime * result + ((uploadurl == null) ? 0 : uploadurl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhotoGallery other = (PhotoGallery) obj;
		if (photodate == null) {
			if (other.photodate != null)
				return false;
		} else if (!photodate.equals(other.photodate))
			return false;
		if (photodescription == null) {
			if (other.photodescription != null)
				return false;
		} else if (!photodescription.equals(other.photodescription))
			return false;
		if (photoid != other.photoid)
			return false;
		if (photoname == null) {
			if (other.photoname != null)
				return false;
		} else if (!photoname.equals(other.photoname))
			return false;
		if (uploadurl == null) {
			if (other.uploadurl != null)
				return false;
		} else if (!uploadurl.equals(other.uploadurl))
			return false;
		return true;
	}
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhotodescription() {
		return photodescription;
	}
	public void setPhotodescription(String photodescription) {
		this.photodescription = photodescription;
	}
	public Date getPhotodate() {
		return photodate;
	}
	public void setPhotodate(Date photodate) {
		this.photodate = photodate;
	}
	public String getUploadurl() {
		return uploadurl;
	}
	public void setUploadurl(String uploadurl) {
		this.uploadurl = uploadurl;
	}
	
}
