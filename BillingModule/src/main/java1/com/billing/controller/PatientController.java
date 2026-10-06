package com.billing.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.billing.DAO.PatientDAO;
import com.billing.java.Patient;

	@Controller
	@RequestMapping("/patient")
	
	public class PatientController {
		
		private PatientDAO patientdao  ;

		private PatientController(PatientDAO patientdao) {
			this.patientdao =patientdao;
		}
		@GetMapping("/")
		public String home() {
			return "index";
			}
		
	  public String showAddForm(Model model) {
		  model.addAttribute("patient", new Patient());
		return "patient-form";
		  
	  }
		
		@PostMapping("/save")
		public String savePatient(@ModelAttribute Patient patient) {
			patientdao.save(patient);
			return "redirect:/student/list";
		     
		}
		
		@GetMapping("/list")
		public String listPatients(Model model) {
			model.addAttribute("patient", patientdao.getAllPatients());
			return "patient-list";
		}
	
	@GetMapping("/edit/{Id")
		public String showEditForm(@PathVariable int ID, Model model) {
			 Patient patient = patientdao.getPatientById(ID) ; 
			 model.addAttribute("patient", patient);
			 return "patient";
	}
	
	@PostMapping("/update")
	public String updatePatient(@ModelAttribute Patient patient) {
		patientdao.update(patient);
		return "redirect:/student/list";
	}
	
	@GetMapping("delete/{Id}")
	public String deletePatient(@PathVariable int Id) {
		patientdao.delete(Id);
		return "redirect:/student/list";
	}
	}
		
		
	    
