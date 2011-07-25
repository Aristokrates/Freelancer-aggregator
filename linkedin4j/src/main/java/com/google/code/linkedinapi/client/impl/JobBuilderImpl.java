/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.linkedinapi.client.impl;

import com.google.code.linkedinapi.client.JobsApiClient.JobBuilder;
import com.google.code.linkedinapi.schema.Company;
import com.google.code.linkedinapi.schema.Country;
import com.google.code.linkedinapi.schema.ExperienceLevel;
import com.google.code.linkedinapi.schema.ExperienceLevelCode;
import com.google.code.linkedinapi.schema.HowToApply;
import com.google.code.linkedinapi.schema.Industries;
import com.google.code.linkedinapi.schema.Industry;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.JobFunction;
import com.google.code.linkedinapi.schema.JobFunctionCode;
import com.google.code.linkedinapi.schema.JobFunctions;
import com.google.code.linkedinapi.schema.JobType;
import com.google.code.linkedinapi.schema.JobTypeCode;
import com.google.code.linkedinapi.schema.Location;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Poster;
import com.google.code.linkedinapi.schema.Role;
import com.google.code.linkedinapi.schema.RoleCode;
import com.google.code.linkedinapi.schema.SchemaElementFactory;

/**
 * @author nmukhtar
 *
 */
public class JobBuilderImpl implements JobBuilder {
	private final SchemaElementFactory<?> factory;
	private Job job;
	
	JobBuilderImpl(SchemaElementFactory<?> factory) {
		this.factory = factory;
		job = this.factory.createJob();
	}

	/* (non-Javadoc)
	 * @see com.google.code.linkedinapi.client.JobsApiClient.JobBuilder#build()
	 */
	@Override
	public Job build() {
		return job;
	}

	@Override
	public JobBuilder withApplicationUrl(String applicationUrl) {
		HowToApply apply = factory.createHowToApply();
		apply.setApplicationUrl(applicationUrl);
		job.setHowToApply(apply);
		return this;
	}

	@Override
	public JobBuilder withCompany(String companyId, String companyName,
			String description) {
		Company company = factory.createCompany();
		company.setId(companyId);
		company.setName(companyName);
		company.setDescription(description);
		job.setCompany(company);
		return this;
	}

	@Override
	public JobBuilder withContractId(Long value) {
		job.setContractId(value);
		return this;
	}

	@Override
	public JobBuilder withCountry(String country) {
		Country c = factory.createCountry();
		c.setCode(country);
		getJobLocation().setCountry(c);
		return this;
	}

	@Override
	public JobBuilder withCustomerJobCode(String value) {
		job.setCustomerJobCode(value);
		return this;
	}

	@Override
	public JobBuilder withDescription(String jobDescription) {
		getJobPosition().setDescription(jobDescription);
		return this;
	}

	@Override
	public JobBuilder withDisplayPoster(Boolean display) {
		getJobPoster().setDisplay(display);
		return this;
	}

	@Override
	public JobBuilder withExperienceLevel(ExperienceLevelCode experienceLevel) {
		ExperienceLevel level = factory.createExperienceLevel();
		level.setCode(experienceLevel);
		getJobPosition().setExperienceLevel(level);
		return this;
	}

	@Override
	public JobBuilder withIndustries(String... industries) {
		for (int i = 0; i < industries.length; i++) {
			Industry industry = factory.createIndustry();
			industry.setCode(industries[i]);
			getJobIndustries().getIndustryList().add(industry);
		}
		return this;
	}

	@Override
	public JobBuilder withJobFunctions(JobFunctionCode... jobFunctions) {
		for (JobFunctionCode jobFunction : jobFunctions) {
			JobFunction function = factory.createJobFunction();
			function.setCode(jobFunction);
			getJobFunctions().getJobFunctionList().add(function);
		}
		return this;
	}

	@Override
	public JobBuilder withLocation(String location) {
		getJobLocation().setName(location);
		return this;
	}

	@Override
	public JobBuilder withPartnerJobId(String value) {
		job.setPartnerJobId(value);
		return this;
	}

	@Override
	public JobBuilder withPostalCode(String postalCode) {
		getJobLocation().setPostalCode(postalCode);
		return this;
	}

	@Override
	public JobBuilder withPosterEmailAddress(String emailAddress) {
		getJobPoster().setEmailAddress(emailAddress);
		return this;
	}

	@Override
	public JobBuilder withPosterRole(RoleCode role) {
		Role r = factory.createRole();
		r.setCode(role);
		getJobPoster().setRole(r);
		return this;
	}

	@Override
	public JobBuilder withReferralBonus(String value) {
		job.setReferralBonus(value);
		return this;
	}

	@Override
	public JobBuilder withRenewal() {
		job.setRenewal(factory.createRenewal());
		return this;
	}

	@Override
	public JobBuilder withSalary(String value) {
		job.setSalary(value);
		return this;
	}

	@Override
	public JobBuilder withSkillsAndExperience(String skillsAndExperience) {
		getJobPosition().setSkillsAndExperience(skillsAndExperience);
		return this;
	}

	@Override
	public JobBuilder withTitle(String jobTitle) {
		getJobPosition().setTitle(jobTitle);
		return this;
	}

	@Override
	public JobBuilder withTrackingPixelUrl(String value) {
		job.setTrackingPixelUrl(value);
		return this;
	}

	@Override
	public JobBuilder withType(JobTypeCode jobType) {
		JobType value = factory.createJobType();
		value.setCode(jobType);
		getJobPosition().setJobType(value);
		return this;
	}
	
	private Position getJobPosition() {
		if (job.getPosition() == null) {
			job.setPosition(factory.createPosition());
		}
		return job.getPosition();
	}
	
	private Location getJobLocation() {
		Position position = getJobPosition();
		if (position.getLocation() == null) {
			position.setLocation(factory.createLocation());
		}
		
		return position.getLocation();
	}
	
	private Poster getJobPoster() {
		if (job.getPoster() == null) {
			job.setPoster(factory.createPoster());
		}
		
		return job.getPoster();
	}
	
	private Industries getJobIndustries() {
		Position position = getJobPosition();
		if (position.getIndustries() == null) {		
			position.setIndustries(factory.createIndustries());
		}
		
		return position.getIndustries();
	}
	
	private JobFunctions getJobFunctions() {
		Position position = getJobPosition();
		if (position.getJobFunctions() == null) {
			position.setJobFunctions(factory.createJobFunctions());
		}
		return position.getJobFunctions();
	}
}
