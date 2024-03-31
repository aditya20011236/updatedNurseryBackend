package com.mydata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Model.Plant;
import com.mydata.Repository.PlantRepository;
import com.mydata.Service.PlantService;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
	@Autowired
	private PlantService plantService;

	@GetMapping
	public List<Plant> getAllPlant() {
		return plantService.getAllplant();

	}
}
