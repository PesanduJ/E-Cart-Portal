package com.ecartportal.ecartportal.repository;

import com.ecartportal.ecartportal.entity.SoldItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldItemRepository extends JpaRepository<SoldItem, Long> {
}
