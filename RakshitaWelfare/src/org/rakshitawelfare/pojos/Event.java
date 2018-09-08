package org.rakshitawelfare.pojos;

import java.util.Date;

public class Event {
	int eventid;
	String eventname;
	String eventdescription;
	Date eventdate;
	String uploadurl;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventdescription() {
		return eventdescription;
	}
	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	public String getUploadurl() {
		return uploadurl;
	}
	public void setUploadurl(String uploadurl) {
		this.uploadurl = uploadurl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventdate == null) ? 0 : eventdate.hashCode());
		result = prime * result + ((eventdescription == null) ? 0 : eventdescription.hashCode());
		result = prime * result + eventid;
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
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
		Event other = (Event) obj;
		if (eventdate == null) {
			if (other.eventdate != null)
				return false;
		} else if (!eventdate.equals(other.eventdate))
			return false;
		if (eventdescription == null) {
			if (other.eventdescription != null)
				return false;
		} else if (!eventdescription.equals(other.eventdescription))
			return false;
		if (eventid != other.eventid)
			return false;
		if (eventname == null) {
			if (other.eventname != null)
				return false;
		} else if (!eventname.equals(other.eventname))
			return false;
		if (uploadurl == null) {
			if (other.uploadurl != null)
				return false;
		} else if (!uploadurl.equals(other.uploadurl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", eventname=" + eventname + ", eventdescription=" + eventdescription
				+ ", eventdate=" + eventdate + ", uploadurl=" + uploadurl + "]";
	}
	public Event(int eventid, String eventname, String eventdescription, Date eventdate, String uploadurl) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.eventdescription = eventdescription;
		this.eventdate = eventdate;
		this.uploadurl = uploadurl;
	}
	public Event(String eventname, String eventdescription, Date eventdate, String uploadurl) {
		super();
		this.eventname = eventname;
		this.eventdescription = eventdescription;
		this.eventdate = eventdate;
		this.uploadurl = uploadurl;
	}
	public Event() {
		super();
	}
	
	
}
