package com.ecartportal.ecartportal.service;


import com.ecartportal.ecartportal.entity.CartItem;
import com.ecartportal.ecartportal.entity.Item;

import java.util.List;

public interface CartItemService {

    List<CartItem> getAllCartItems();
    CartItem addItemToCart(CartItem cartItem);

    void deleteItemById(Long id);

    void clearCart();

}
