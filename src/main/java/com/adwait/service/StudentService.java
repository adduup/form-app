package com.adwait.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adwait.model.Student;
import com.adwait.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	public List<Student> showAllStudents() {
		List<Student> students = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			students.add(student);
		}
		return students;
	}

	public List<Student> showAllStudentsByFirst() {
		List<Student> students = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			students.add(student);
		}
		students = studentRepository.orderByFirstName();
		return students;
	}

	public List<Student> showAllStudentsByLast() {
		List<Student> students = new ArrayList<>();
		for (Student student : studentRepository.findAll()) {
			students.add(student);
		}
		students = studentRepository.orderByLastName();
		return students;
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public Student findStudentById(int id) {
		Optional<Student> result = studentRepository.findById(id);
		Student student = null;
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new RuntimeException("Did not find student id -" + id);
		}
		return student;
	}

	public List<Student> findByFirstNameLike(String searchName) {
		List<Student> students = studentRepository.findByFirstNameLike(searchName);

		return students;
	}

}
