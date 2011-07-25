package org.pan.linkedin.model.person;

import com.google.code.linkedinapi.schema.Person;

public class LinkedInPersonModel {
	
	private String personId;
	
	private String firstName;
	
	private String lastName;
	
	private String summary;
	
	private String publicProfileUrl;
	
	private String specialities;

	public LinkedInPersonModel(Person person) {
		
		this.personId = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.summary = person.getSummary();
		this.publicProfileUrl = person.getPublicProfileUrl();
		
		this.specialities = person.getSpecialties();				
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPublicProfileUrl() {
		return publicProfileUrl;
	}

	public void setPublicProfileUrl(String publicProfileUrl) {
		this.publicProfileUrl = publicProfileUrl;
	}

	public String getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	@Override
	public String toString() {
		return "LinkedInPersonModel [personId=" + personId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", publicProfileUrl="
				+ publicProfileUrl + "]";
	}

}
