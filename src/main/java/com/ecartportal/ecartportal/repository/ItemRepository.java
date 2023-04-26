package com.ecartportal.ecartportal.repository;

import com.ecartportal.ecartportal.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
