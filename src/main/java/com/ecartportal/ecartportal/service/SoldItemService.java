package com.ecartportal.ecartportal.service;

import com.ecartportal.ecartportal.entity.SoldItem;

import java.util.List;

public interface SoldItemService {

    SoldItem addSoldItem(SoldItem soldItem);

    List<SoldItem> getAllSoldItems();
}
