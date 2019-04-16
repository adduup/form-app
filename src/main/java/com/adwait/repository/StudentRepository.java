package com.adwait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adwait.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT * FROM Student WHERE first_name like %?1%", nativeQuery = true)
	public List<Student> findByFirstNameLike(@Param("searchName") String searchName);

	@Query(value = "SELECT * FROM Student order by last_name ASC", nativeQuery = true)
	public List<Student> orderByLastName();

	@Query(value = "SELECT * FROM Student order by first_name ASC", nativeQuery = true)
	public List<Student> orderByFirstName();

}
