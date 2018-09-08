package org.rakshitawelfare.pojos;

import java.util.Date;

public class Press {
	int pressid;
	public Press() {
		super();
	}
	String pressname;
	String pressdescription;
	Date pressdate;
	String uploadurl;
	@Override
	public String toString() {
		return "Press [pressid=" + pressid + ", pressname=" + pressname + ", pressdescription="
				+ pressdescription + ", pressdate=" + pressdate + ", uploadurl=" + uploadurl + "]";
	}
	public Press(String pressname, String pressdescription, Date pressdate, String uploadurl) {
		super();
		this.pressname = pressname;
		this.pressdescription = pressdescription;
		this.pressdate = pressdate;
		this.uploadurl = uploadurl;
	}
	public Press(int pressid, String pressname, String pressdescription, Date pressdate, String uploadurl) {
		super();
		this.pressid = pressid;
		this.pressname = pressname;
		this.pressdescription = pressdescription;
		this.pressdate = pressdate;
		this.uploadurl = uploadurl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pressdate == null) ? 0 : pressdate.hashCode());
		result = prime * result + ((pressdescription == null) ? 0 : pressdescription.hashCode());
		result = prime * result + pressid;
		result = prime * result + ((pressname == null) ? 0 : pressname.hashCode());
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
		Press other = (Press) obj;
		if (pressdate == null) {
			if (other.pressdate != null)
				return false;
		} else if (!pressdate.equals(other.pressdate))
			return false;
		if (pressdescription == null) {
			if (other.pressdescription != null)
				return false;
		} else if (!pressdescription.equals(other.pressdescription))
			return false;
		if (pressid != other.pressid)
			return false;
		if (pressname == null) {
			if (other.pressname != null)
				return false;
		} else if (!pressname.equals(other.pressname))
			return false;
		if (uploadurl == null) {
			if (other.uploadurl != null)
				return false;
		} else if (!uploadurl.equals(other.uploadurl))
			return false;
		return true;
	}
	public int getPressid() {
		return pressid;
	}
	public void setPressid(int pressid) {
		this.pressid = pressid;
	}
	public String getPressname() {
		return pressname;
	}
	public void setPressname(String pressname) {
		this.pressname = pressname;
	}
	public String getPressdescription() {
		return pressdescription;
	}
	public void setPressdescription(String pressdescription) {
		this.pressdescription = pressdescription;
	}
	public Date getPressdate() {
		return pressdate;
	}
	public void setPressdate(Date pressdate) {
		this.pressdate = pressdate;
	}
	public String getUploadurl() {
		return uploadurl;
	}
	public void setUploadurl(String uploadurl) {
		this.uploadurl = uploadurl;
	}
}
