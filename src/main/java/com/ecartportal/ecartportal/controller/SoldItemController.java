package com.ecartportal.ecartportal.controller;

import com.ecartportal.ecartportal.entity.CartItem;
import com.ecartportal.ecartportal.entity.SoldItem;
import com.ecartportal.ecartportal.service.SoldItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SoldItemController {

    @Autowired
    private SoldItemService soldItemService;

//    @GetMapping("/soldItems")
//    public String listOfSoldItems(Model model){
//        model.addAttribute("soldItemList", soldItemService.getAllSoldItems());
//        return "sold_items";
//    }

    //Go to cart function
    //Show total value of items in cart
    @GetMapping("/soldItems")
    public String listOfCartItems(Model model){
        List<SoldItem> soldItemList = soldItemService.getAllSoldItems();
        float total = soldItemList.stream().map(SoldItem::getSelling_price).reduce(0f, Float::sum);
        String formattedTotal = String.format("%.2f", total);
        model.addAttribute("soldItemList", soldItemList);
        model.addAttribute("profit", formattedTotal);
        return "sold_items";
    }
}
