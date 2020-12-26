package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.PricingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingCategoryRepository extends JpaRepository<PricingCategory, String> {

}
