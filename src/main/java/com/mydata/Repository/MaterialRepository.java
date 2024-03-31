package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
