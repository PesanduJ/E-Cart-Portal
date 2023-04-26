package com.ecartportal.ecartportal.service;

import java.util.List;

import com.ecartportal.ecartportal.entity.Item;
import com.ecartportal.ecartportal.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;


	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}


}
