package com.jerry.girl;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findByAge(Integer age);
}
