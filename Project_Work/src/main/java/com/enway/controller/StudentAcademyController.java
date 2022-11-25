package com.enway.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.enway.entity.Academy;
import com.enway.service.StudentAcademyService;

@Controller
public class StudentAcademyController {

	
@Autowired
private StudentAcademyService studentAcademyService;

	@GetMapping("/home")
	public ModelAndView showHomePage() {

		ModelAndView mav = new ModelAndView("academy");

		mav.addObject("academy", new Academy());
		
		return mav;
	}
	
	@GetMapping("/academies")
	public ModelAndView showAllAcademies() {
		List<Academy> academies = studentAcademyService.FindAllAcademies();
		
		ModelAndView mav = new ModelAndView("academies");
		
		mav.addObject("academies", academies);
		
		return mav;
	}
	
	
	@PostMapping("/academies")
	public ModelAndView addOrUpdateAcademy(@ModelAttribute("academy") Academy academy) {

		String page = null;

		page = studentAcademyService.checkAddOrUpdateAcademy(academy);

		List<Academy> academies = studentAcademyService.FindAllAcademies();

		ModelAndView mav = new ModelAndView(page);

		mav.addObject("academies", academies);

		return mav;
	}
	
	@GetMapping("/academies/update/{code}")
	public ModelAndView showAcademyToUpdate(@PathVariable String code) {
		
		Academy academyToUpdate = studentAcademyService.findAcademyById(code);
		
		ModelAndView mav = new ModelAndView("academy");
		
		mav.addObject("academy", academyToUpdate);
		
		return mav;
		
		
	}
	@GetMapping("/academies/remove/{code}")
	public ModelAndView deleteAcademy(@PathVariable String code) {
		String page = studentAcademyService.checkRemoveAcademyAndStudents(code);
		List<Academy> academies = studentAcademyService.FindAllAcademies();
		ModelAndView mav = new ModelAndView(page);
		mav.addObject("academies", academies);
		return mav;
	}

}
