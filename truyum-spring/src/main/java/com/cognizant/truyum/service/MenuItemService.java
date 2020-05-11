package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service("menuItemService")
public class MenuItemService  {
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.findAllForCustomer();
	}

	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}

	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		return menuItemRepository.getOne(menuItemId);
	}

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}
}
