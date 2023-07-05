package com.stockManagement.sampleProject.repository;

import com.stockManagement.sampleProject.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RepoAdmin extends JpaRepository<Admin,Integer> {



    Admin findAllByAdminUserNameAndAdminPasswordEquals(String adminUserName, String adminPassword);

    List<Admin> findAllByAdminActiveStateEquals(boolean status);
}
