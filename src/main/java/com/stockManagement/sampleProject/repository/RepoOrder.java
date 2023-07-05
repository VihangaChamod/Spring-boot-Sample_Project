package com.stockManagement.sampleProject.repository;

import com.stockManagement.sampleProject.entity.Order;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RepoOrder extends JpaRepository<Order, Integer> {
}
