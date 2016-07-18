package com.spring.mongodb.home.customer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.mongodb.home.customer.constants.RoomExpenseManagerConstants;
import com.spring.mongodb.home.customer.service.RoomMemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
@WebAppConfiguration
public class RoomExpensesManagerControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private RoomMemberDAO memberDAO;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		System.out.println("Before");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void homeTestWithSlash() {
		final String urlPattern = "/";
		try {
			mockMvc.perform(get(urlPattern))
					.andExpect(status().isOk())
					.andExpect(
							view().name(RoomExpenseManagerConstants.HOME_PAGE))
					.andExpect(forwardedUrl("/WEB-INF/views/roomExpenses.jsp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void homeTestWithMember() {
		final String urlPattern = "/member";
		try {
			mockMvc.perform(get(urlPattern))
					.andExpect(status().isOk())
					.andExpect(
							view().name(RoomExpenseManagerConstants.HOME_PAGE))
					.andExpect(forwardedUrl("/WEB-INF/views/roomExpenses.jsp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void homeTestWithHome() {
		final String urlPattern = "/home";
		try {
			mockMvc.perform(get(urlPattern))
					.andExpect(status().isOk())
					.andExpect(
							view().name(RoomExpenseManagerConstants.HOME_PAGE))
					.andExpect(forwardedUrl("/WEB-INF/views/roomExpenses.jsp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void close() {
		System.out.println("After");
		mockMvc = null;
	}

}
