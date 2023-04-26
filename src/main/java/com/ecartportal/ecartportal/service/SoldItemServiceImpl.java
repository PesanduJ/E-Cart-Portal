package com.ecartportal.ecartportal.service;

import com.ecartportal.ecartportal.entity.SoldItem;
import com.ecartportal.ecartportal.repository.SoldItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldItemServiceImpl implements SoldItemService{

    @Autowired
    private SoldItemRepository soldItemRepository;

    @Override
    public SoldItem addSoldItem(SoldItem soldItem) {
        return soldItemRepository.save(soldItem);
    }

    @Override
    public List<SoldItem> getAllSoldItems() {
        return soldItemRepository.findAll();
    }
}
