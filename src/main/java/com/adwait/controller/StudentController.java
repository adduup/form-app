package com.adwait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adwait.model.Address;
import com.adwait.model.Country;
import com.adwait.model.Student;
import com.adwait.service.AddressService;
import com.adwait.service.CountryService;
import com.adwait.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	AddressService addressService;
	@Autowired
	CountryService countryService;

	@GetMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.showAllStudents();
		model.addAttribute("students", students);
		return "list-students";
	}

	@GetMapping("listCountries")
	public String listCountries(Model model) {
		List<Country> countries = countryService.showAllCountries();
		model.addAttribute("countries", countries);
		return "list-countries";
	}

	@GetMapping("/listAddress")
	public String listAddress(Model model, @RequestParam("studentId") int id) {
		Student student = studentService.findStudentById(id);
		List<Address> addresses = student.getAddresses();

		model.addAttribute("addresses", addresses);
		return "list-address";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";

	}

	@GetMapping("/listByFirst")
	public String listStudentsByFirst(Model model) {
		List<Student> students = studentService.showAllStudentsByFirst();
		model.addAttribute("students", students);

		return "list-students";
	}

	@GetMapping("/listByLast")
	public String listStudentsByLast(Model model) {
		List<Student> students = studentService.showAllStudentsByLast();
		model.addAttribute("students", students);

		return "list-students";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/student/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		Student student = studentService.findStudentById(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/addAddress")
	public String showFormForAddAddress(@RequestParam("studentId") int id, Model model,
			@ModelAttribute("address") Address address) {
		Student student = studentService.findStudentById(id);

		model.addAttribute("address", address);
		List<Address> addresses = student.getAddresses();
		addresses.add(address);
		student.setAddresses(addresses);
		studentService.saveStudent(student);

		return "redirect:/student/list";
	}

	@GetMapping("/addAddress")
	public String addAddress(@RequestParam("studentId") int id, Model model) {
		Address address = new Address();
		address.setStudentId(id);
		model.addAttribute("address", address);
		return "address-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/student/list";
	}

	@GetMapping("/deleteAddress")
	public String deleteAddress(@RequestParam("addressId") int id) {
		addressService.deleteAddress(id);

		return "redirect:/student/list";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {
		List<Student> students = studentService.findByFirstNameLike(searchName);

		model.addAttribute("students", students);
		return "list-students";
	}

}
