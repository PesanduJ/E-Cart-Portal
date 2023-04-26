package com.ecartportal.ecartportal.service;

import com.ecartportal.ecartportal.entity.CartItem;
import com.ecartportal.ecartportal.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem addItemToCart(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}
