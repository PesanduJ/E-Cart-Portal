package com.ecartportal.ecartportal.controller;

import com.ecartportal.ecartportal.entity.CartItem;
import com.ecartportal.ecartportal.entity.Item;
import com.ecartportal.ecartportal.entity.SoldItem;
import com.ecartportal.ecartportal.repository.CartItemRepository;
import com.ecartportal.ecartportal.service.CartItemService;
import com.ecartportal.ecartportal.service.ItemService;
import com.ecartportal.ecartportal.service.SoldItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private SoldItemService soldItemService;


    //Add to cart function
    @RequestMapping(value = "/addItemToCart/{id}", method = RequestMethod.POST)
    public String addItemsToCart(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("selling_price") String selling_price, @ModelAttribute("cartitem") Item item){
        Item selectedItem = itemService.getItemById(id);
        selectedItem.setId(id);
        selectedItem.setName(name);
        selectedItem.setSelling_price(item.getSelling_price());

        CartItem cartItem = new CartItem();
        cartItem.setItem_no(selectedItem.getId());
        cartItem.setName(selectedItem.getName());
        cartItem.setSelling_price(selectedItem.getSelling_price());

        cartItemService.addItemToCart(cartItem);
        return "redirect:/items";
    }

    //Go to cart function
    //Show total value of items in cart
    @GetMapping("/viewCart")
    public String listOfCartItems(Model model){
        List<CartItem> cartItemList = cartItemService.getAllCartItems();
        float total = cartItemList.stream().map(CartItem::getSelling_price).reduce(0f, Float::sum);
        String formattedTotal = String.format("%.2f", total);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("total", formattedTotal);
        return "cart";
    }


    //Remove item from cart
    @GetMapping("/cartItem/remove/{id}")
    public String removeCartItem(@PathVariable Long id, RedirectAttributes redirectAttributes){
        cartItemService.deleteItemById(id);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String referrer = request.getHeader("Referer");
        return "redirect:" + referrer;
    }


    //Buy items in cart
    @GetMapping("/cartItem/buy/{value}")
    public String generateBill(@PathVariable float value, Model model) {
        List<CartItem> cartItemList = cartItemService.getAllCartItems();

        List<SoldItem> soldItemsList = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            SoldItem soldItem = new SoldItem();
            soldItem.setName(cartItem.getName());
            soldItem.setItem_no(cartItem.getItem_no());
            soldItem.setSelling_price(cartItem.getSelling_price());
            soldItemsList.add(soldItem);
        }

        for (SoldItem soldItem : soldItemsList) {
            soldItemService.addSoldItem(soldItem);
        }

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("total", String.format("%.2f", value));
        cartItemService.clearCart();
        return "bill";
    }
}
