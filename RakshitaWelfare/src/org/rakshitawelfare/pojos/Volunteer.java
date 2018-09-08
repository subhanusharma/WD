package org.rakshitawelfare.pojos;

import java.util.Date;

public class Volunteer {
	int volunteerid;
	String name;
	int mobile;
	Date dob;
	String email;
	String state;
	String city;
	String areaofintrest;
	String capabilities;
	String availability;
	String motive;
	String resumeurl;
	String donation;
	String status;
	public int getVolunteerid() {
		return volunteerid;
	}
	public void setVolunteerid(int volunteerid) {
		this.volunteerid = volunteerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAreaofintrest() {
		return areaofintrest;
	}
	public void setAreaofintrest(String areaofintrest) {
		this.areaofintrest = areaofintrest;
	}
	public String getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(String capabilities) {
		this.capabilities = capabilities;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getMotive() {
		return motive;
	}
	public void setMotive(String motive) {
		this.motive = motive;
	}
	public String getResumeurl() {
		return resumeurl;
	}
	public void setResumeurl(String resumeurl) {
		this.resumeurl = resumeurl;
	}
	public String getDonation() {
		return donation;
	}
	public void setDonation(String donation) {
		this.donation = donation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaofintrest == null) ? 0 : areaofintrest.hashCode());
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((capabilities == null) ? 0 : capabilities.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((donation == null) ? 0 : donation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + mobile;
		result = prime * result + ((motive == null) ? 0 : motive.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((resumeurl == null) ? 0 : resumeurl.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + volunteerid;
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
		Volunteer other = (Volunteer) obj;
		if (areaofintrest == null) {
			if (other.areaofintrest != null)
				return false;
		} else if (!areaofintrest.equals(other.areaofintrest))
			return false;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (capabilities == null) {
			if (other.capabilities != null)
				return false;
		} else if (!capabilities.equals(other.capabilities))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (donation == null) {
			if (other.donation != null)
				return false;
		} else if (!donation.equals(other.donation))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile != other.mobile)
			return false;
		if (motive == null) {
			if (other.motive != null)
				return false;
		} else if (!motive.equals(other.motive))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resumeurl == null) {
			if (other.resumeurl != null)
				return false;
		} else if (!resumeurl.equals(other.resumeurl))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (volunteerid != other.volunteerid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Volunteer [volunteerid=" + volunteerid + ", name=" + name + ", mobile=" + mobile + ", dob=" + dob
				+ ", email=" + email + ", state=" + state + ", city=" + city + ", areaofintrest=" + areaofintrest
				+ ", capabilities=" + capabilities + ", availability=" + availability + ", motive=" + motive
				+ ", resumeurl=" + resumeurl + ", donation=" + donation + ", status=" + status + "]";
	}
	public Volunteer(int volunteerid, String name, int mobile, Date dob, String email, String state, String city,
			String areaofintrest, String capabilities, String availability, String motive, String resumeurl,
			String donation, String status) {
		super();
		this.volunteerid = volunteerid;
		this.name = name;
		this.mobile = mobile;
		this.dob = dob;
		this.email = email;
		this.state = state;
		this.city = city;
		this.areaofintrest = areaofintrest;
		this.capabilities = capabilities;
		this.availability = availability;
		this.motive = motive;
		this.resumeurl = resumeurl;
		this.donation = donation;
		this.status = status;
	}
	public Volunteer(String name, int mobile, Date dob, String email, String state, String city, String areaofintrest,
			String capabilities, String availability, String motive, String resumeurl, String donation, String status) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.dob = dob;
		this.email = email;
		this.state = state;
		this.city = city;
		this.areaofintrest = areaofintrest;
		this.capabilities = capabilities;
		this.availability = availability;
		this.motive = motive;
		this.resumeurl = resumeurl;
		this.donation = donation;
		this.status = status;
	}
	public Volunteer() {
		super();
	}
	
}
