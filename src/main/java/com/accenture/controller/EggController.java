package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.data.ChickenDAO;
import com.accenture.data.EggDAO;
import com.accenture.model.Egg;

@Controller
@RequestMapping("/Eggs")
public class EggController {
	

	@Autowired
	EggDAO eggDAO;
	
	@Autowired
	ChickenDAO chickenDAO;
	
	
	@RequestMapping("/")
	public ModelAndView eggList(){
		List<Egg> eggList = eggDAO.eggList();
		return new ModelAndView("Eggs/List", "eggList", eggList);
	}
	
	@RequestMapping("/Add")
	public ModelAndView addEgg(){
		ModelAndView m = new ModelAndView("Eggs/Add");
		m.addObject("chickenList", chickenDAO.chickenList());
		m.addObject("egg", new Egg());
		return m;
	}
	
	@RequestMapping(path="Add", method=RequestMethod.POST)
	public String addEggRedirect(@ModelAttribute("egg")Egg egg){
		eggDAO.addEgg(egg);
		return "redirect:../Farms/";
	}
	
	@RequestMapping("Details/{id}")
	public ModelAndView Details(@PathVariable("id")String id)
	{
		@SuppressWarnings("unused")
		Egg egg = null;
		
		try{
		 egg = eggDAO.getEgg(Long.parseLong(id));
		}
		catch(org.hibernate.ObjectNotFoundException er){
			egg = null;
			System.out.println("ERROR");
		}
		
		ModelAndView m = new ModelAndView("Eggs/Details");
		m.addObject("eggList", eggDAO.eggListDeterminado(id));
		m.addObject("chicken", chickenDAO.getChicken(Long.parseLong(id)));
		return m;
	}
	
	@RequestMapping("Modify/{id}")
	public ModelAndView Modify(@PathVariable("id")String id)
	{
		Egg egg = null;
		try{
			egg = eggDAO.getEgg(Long.parseLong(id));
			
		}
		catch(org.hibernate.ObjectNotFoundException er){
			egg = null;
			System.out.println("ERROR");
		}
		ModelAndView m = new ModelAndView("Eggs/Modify");
		m.addObject("egg", egg);
		return m;
	}

	@RequestMapping(path="Modify", method=RequestMethod.POST)
	public String Modification(@ModelAttribute("egg")Egg egg){
		eggDAO.updateEgg(egg);
		return "redirect:/Farms/";
	}
	
}
