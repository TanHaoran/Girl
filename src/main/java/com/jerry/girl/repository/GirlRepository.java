package com.jerry.girl.repository;


import com.jerry.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findByAge(Integer age);
}
