package com.montella.demo.repository;

import com.montella.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Students,Long> {
        List<Students> findByFirstName(String firstName);
        List<Students> findByFirstNameContaining(String name);

}
