package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceTest.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = context.getBean(MenuItemService.class);
		LOGGER.info("Inside main");
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
		testEditMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		LOGGER.info("start");
		LOGGER.debug("Items{}", menuItemService.getMenuItemListAdmin());
		LOGGER.info("end");
	}

	public static void testGetMenuItemListCustomer() {
		LOGGER.info("start");
		LOGGER.debug("Items{}", menuItemService.getMenuItemListCustomer());
		LOGGER.info("end");
	}

	public static void testGetMenuItem() {
		LOGGER.info("start");
		MenuItem item = menuItemService.getMenuItem(2);
		LOGGER.debug("Item{}", item);
		LOGGER.info("end");
	}

	public static void testEditMenuItem() {
		LOGGER.info("start");
		MenuItem menuItem = new MenuItem(3, "Patties", 29.00f, true, DateUtil.convertToDate("29/12/2017"), "Starter",
				true);
		menuItemService.modifyMenuItem(menuItem);
		List<MenuItem> items = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Items{}", items);
		LOGGER.info("end");
	}
}
