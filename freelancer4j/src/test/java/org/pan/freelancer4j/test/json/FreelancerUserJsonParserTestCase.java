package org.pan.freelancer4j.test.json;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.pan.freelancer4j.json.GenericSerializer;
import org.pan.freelancer4j.json.JacksonJsonSerializer;
import org.pan.freelancer4j.model.user.FreelancerUser;
import org.pan.freelancer4j.model.user.FreelancerUserAddress;
import org.pan.freelancer4j.model.user.FreelancerUserList;
import org.pan.freelancer4j.test.BaseTestCase;

public class FreelancerUserJsonParserTestCase extends BaseTestCase {
	
	private GenericSerializer serializer;
	
	@Before
	public void initParser() {
		serializer = new JacksonJsonSerializer();
	}
	
	@Test
	public void testAddressSerialization() {
		FreelancerUserAddress address = new FreelancerUserAddress("MKD", "Tetovo");
		
		String userJson = serializer.toJson(address);
		System.out.println("Returned json: " + userJson);
			
	}
	
	@Test
	public void testSerialization() {
		FreelancerUser user = new FreelancerUser();
		user.setUsername("Panche");
		user.setUserId(124);
		user.setCompany("PAN");
		user.setAddress(new FreelancerUserAddress("MKD", "Tetovo"));
		user.setAveragePricing(12);
		
		String userJson = serializer.toJson(user);
		System.out.println("Returned json: " + userJson);
	}
	
	@Test
	public void testListSerialization() {
		FreelancerUser user = new FreelancerUser();
		user.setUsername("Panche");
		user.setUserId(124);
		user.setCompany("PAN");
		user.setAddress(new FreelancerUserAddress("MKD", "Tetovo"));
		user.setAveragePricing(12);
		
		FreelancerUserList list = new FreelancerUserList();
		list.setCount(1);
		list.setUsers(Arrays.asList(user));
		
		String userListJson = serializer.toJson(list);
		System.out.println("Returned json: " + userListJson);
	}
	
	@Test
	public void testDeserialization() {
		
		FreelancerUser user = new FreelancerUser();
		user.setUsername("Panche");
		user.setUserId(124);
		user.setCompany("PAN");
		user.setAddress(new FreelancerUserAddress("MKD", "Tetovo"));
		user.setAveragePricing(12);
		
		String userJson = serializer.toJson(user);
		System.out.println("Returned json: " + userJson);
		
		FreelancerUser newUser = serializer.fromJson(userJson, FreelancerUser.class);
		
		Assert.assertEquals(user, newUser);
		
	}
	
	@Test
	public void testListDeserialization() {
		
		FreelancerUser user = new FreelancerUser();
		user.setUsername("Panche");
		user.setUserId(124);
		user.setCompany("PAN");
		user.setAddress(new FreelancerUserAddress("MKD", "Tetovo"));
		user.setAveragePricing(12);
		
		FreelancerUserList list = new FreelancerUserList();
		list.setCount(1);
		list.setUsers(Arrays.asList(user));
		
		String userListJson = serializer.toJson(list);
		System.out.println("Returned json: " + userListJson);
		
		FreelancerUserList newList = serializer.fromJson(userListJson, FreelancerUserList.class);
		
		Assert.assertEquals(list.getCount(), newList.getCount());
		
	}
}
