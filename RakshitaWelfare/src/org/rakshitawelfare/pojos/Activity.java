package org.rakshitawelfare.pojos;

import java.util.Date;

public class Activity {
int activityid;
String activityname;
String activitydescription;
Date activitydate;
String uploadurl;

public Activity() {
	super();
}
public int getActivityid() {
	return activityid;
}
public void setActivityid(int activityid) {
	this.activityid = activityid;
}
public String getActivityname() {
	return activityname;
}
public void setActivityname(String activityname) {
	this.activityname = activityname;
}
public String getActivitydescription() {
	return activitydescription;
}
public void setActivitydescription(String activitydescription) {
	this.activitydescription = activitydescription;
}
public Date getActivitydate() {
	return activitydate;
}
public void setActivitydate(Date activitydate) {
	this.activitydate = activitydate;
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
	result = prime * result + ((activitydate == null) ? 0 : activitydate.hashCode());
	result = prime * result + ((activitydescription == null) ? 0 : activitydescription.hashCode());
	result = prime * result + activityid;
	result = prime * result + ((activityname == null) ? 0 : activityname.hashCode());
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
	Activity other = (Activity) obj;
	if (activitydate == null) {
		if (other.activitydate != null)
			return false;
	} else if (!activitydate.equals(other.activitydate))
		return false;
	if (activitydescription == null) {
		if (other.activitydescription != null)
			return false;
	} else if (!activitydescription.equals(other.activitydescription))
		return false;
	if (activityid != other.activityid)
		return false;
	if (activityname == null) {
		if (other.activityname != null)
			return false;
	} else if (!activityname.equals(other.activityname))
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
	return "Activity [activityid=" + activityid + ", activityname=" + activityname + ", activitydescription="
			+ activitydescription + ", activitydate=" + activitydate + ", uploadurl=" + uploadurl + "]";
}
public Activity(int activityid, String activityname, String activitydescription, Date activitydate, String uploadurl) {
	super();
	this.activityid = activityid;
	this.activityname = activityname;
	this.activitydescription = activitydescription;
	this.activitydate = activitydate;
	this.uploadurl = uploadurl;
}
public Activity(String activityname, String activitydescription, Date activitydate, String uploadurl) {
	super();
	this.activityname = activityname;
	this.activitydescription = activitydescription;
	this.activitydate = activitydate;
	this.uploadurl = uploadurl;
}

}
