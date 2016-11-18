package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.data.ChickenDAO;
import com.accenture.model.Chicken;

@Controller
public class ChickenController {

	@Autowired
	ChickenDAO chickenDAO;
	
	@RequestMapping(path="/view/chickens", method=RequestMethod.GET)
	public @ResponseBody List<Chicken> chickenList(){
		List<Chicken> list = chickenDAO.chickenList();
		return list;	
	}
	
	@RequestMapping(path="/remove/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void removeChicken(@PathVariable("id")String id){
		Chicken chicken = chickenDAO.getChicken(Long.parseLong(id));
		chickenDAO.deleteChicken(chicken);
	}
	
}