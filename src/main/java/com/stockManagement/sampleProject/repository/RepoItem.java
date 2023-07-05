package com.stockManagement.sampleProject.repository;

import com.stockManagement.sampleProject.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RepoItem extends JpaRepository<Items,Integer> {
    List<Items> findAllByItemActiveStateEquals(boolean activeStatus);

    Items findAllByItemActiveStateEqualsAndAndItemIdEquals(boolean activeStatus, int id);
}
