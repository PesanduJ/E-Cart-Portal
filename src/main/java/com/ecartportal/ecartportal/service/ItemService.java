package com.ecartportal.ecartportal.service;

import java.util.List;

import com.ecartportal.ecartportal.entity.Item;

public interface ItemService {
	
	List<Item> getAllItems();

	Item addItem(Item item);

	Item getItemById(Long id);

	Item updateItem (Item item);


}
