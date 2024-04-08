package com.mydata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;

import com.mydata.Model.User;
import com.mydata.Service.UserService;

@Controller
@CrossOrigin
public class HomeController {
@RequestMapping(value = {"/", "/invoice", "/addproduct", "/editproduct/*", "/home", "/addexpance", "/rawmexpence", "/SD", "/SW", "/SM", "/SQ", "/SY", "/ExD", "/ExW", "/ExD", "/ExM", "/ExQ","/ExY", "/PLD", "/PLW", "/PLM", "/PLQ", "/PLY", "/advancebook", "/showbooking", "/updateproduct/*", "/admin-login", "/register", "/emp_register", "/employee-login", "/empinvoice"})
    public String index() {
        return "index.html";
    }
}