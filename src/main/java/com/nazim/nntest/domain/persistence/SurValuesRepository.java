package com.nazim.nntest.domain.persistence;

import com.nazim.nntest.domain.entity.SurValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurValuesRepository extends JpaRepository<SurValues, Integer> {
}
