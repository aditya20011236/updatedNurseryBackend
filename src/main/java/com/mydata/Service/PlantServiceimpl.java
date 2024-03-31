package com.mydata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Plant;
import com.mydata.Repository.PlantRepository;

@Service
public class PlantServiceimpl implements PlantService {
	@Autowired
	PlantRepository plantRepository;

	@Override
	public Plant saveplantDetails(Plant plant) {
		return plantRepository.save(plant);
	}

	@Override
	public List<Plant> getAllplant() {
		return plantRepository.findAll();
	}

}
