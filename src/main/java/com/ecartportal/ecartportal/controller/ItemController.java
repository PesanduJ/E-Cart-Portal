package com.ecartportal.ecartportal.controller;

import com.ecartportal.ecartportal.entity.Item;
import com.ecartportal.ecartportal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public String listOfItems(Model model){
		model.addAttribute("itemList", itemService.getAllItems());
		return "items";
	}


	//Add items to database
	@GetMapping("/addItem/new")
	public String createAddItemForm(Model model){
		Item item = new Item();
		model.addAttribute("item", item);
		return "add_items";
	}
	@PostMapping("/addItem")
	public String addItems(@ModelAttribute("item")Item item){
		itemService.addItem(item);
		return "redirect:/items";
	}
}
