package com.mydata.Service;

import java.util.List;

import com.mydata.Model.Plant;

public interface PlantService {

	Plant saveplantDetails(Plant plant);
	
	List<Plant>getAllplant();
}
