package com.mydata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.Service.Materialservice;
import com.mydata.Model.Material;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private Materialservice materialService;

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material savedMaterial = materialService.savematrial(material);
        return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
    }
}