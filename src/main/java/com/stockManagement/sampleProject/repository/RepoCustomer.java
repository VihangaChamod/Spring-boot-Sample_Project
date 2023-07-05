package com.stockManagement.sampleProject.repository;

import com.stockManagement.sampleProject.dto.requestDtoCustomer.DtoCustomerSelectAll;
import com.stockManagement.sampleProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RepoCustomer extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByCustomerStatusEquals(boolean activeStatus);
}
