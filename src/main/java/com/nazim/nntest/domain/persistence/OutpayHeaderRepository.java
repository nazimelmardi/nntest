package com.nazim.nntest.domain.persistence;

import com.nazim.nntest.domain.entity.OutpayHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutpayHeaderRepository extends JpaRepository<OutpayHeader, Integer> {
}
