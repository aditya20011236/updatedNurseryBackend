package com.mydata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Material;
import com.mydata.Repository.MaterialRepository;

@Service
public class MaterialServiceimpl implements Materialservice {
	@Autowired
	MaterialRepository materialRepository;

	@Override
	public Material savematrial(Material material) {
		return materialRepository.save(material);
	}

}
