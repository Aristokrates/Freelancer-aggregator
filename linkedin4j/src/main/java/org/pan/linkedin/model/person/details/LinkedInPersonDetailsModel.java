package org.pan.linkedin.model.person.details;

import java.util.ArrayList;
import java.util.List;

import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Skill;

public class LinkedInPersonDetailsModel {
	
	private String personId;
	
	private String firstName;
	
	private String lastName;
	
	private String summary;
	
	private List<String> positions = new ArrayList<String>();
	
	private String publicProfileUrl;
	
	private String specialities;
	
	private List<String> skills = new ArrayList<String>();
	
	private String industry;
	
	private String location;
	
	public LinkedInPersonDetailsModel() {
		super();
	}

	public LinkedInPersonDetailsModel(Person person) {
		
		this.personId = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.summary = person.getSummary();
		this.publicProfileUrl = person.getPublicProfileUrl();
		
		this.industry = person.getIndustry();
		
		if (person.getPositions() != null) {
			for (Position pos : person.getPositions().getPositionList()) {
				this.positions.add(pos.getTitle());
			}
		}
		
		this.specialities = person.getSpecialties();
		
		if (person.getSkills() != null) {
			for (Skill skill : person.getSkills().getSkillList()) {
				this.skills.add(skill.getSkill().getName());
			}
		}	
		
		if (person.getLocation() != null) {
			this.location = person.getLocation().getName();
		}
		
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

	public List<String> getPositions() {
		return positions;
	}

	public void setPositions(List<String> positions) {
		this.positions = positions;
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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "LinkedInPersonDetailsModel [personId=" + personId
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
