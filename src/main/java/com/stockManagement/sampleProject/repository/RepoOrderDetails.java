package com.stockManagement.sampleProject.repository;

import com.stockManagement.sampleProject.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RepoOrderDetails extends JpaRepository<OrderDetails,Integer> {
}
