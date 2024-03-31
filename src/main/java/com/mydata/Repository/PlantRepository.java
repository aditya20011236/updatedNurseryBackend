package com.mydata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.Model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
