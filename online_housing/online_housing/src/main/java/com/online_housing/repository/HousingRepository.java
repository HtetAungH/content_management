package com.online_housing.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.online_housing.model.Housing;
import com.online_housing.model.Owner;

@Repository
public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<Housing> findByOwner(Owner owner);
}
