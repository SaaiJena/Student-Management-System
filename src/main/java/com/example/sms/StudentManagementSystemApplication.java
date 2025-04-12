package com.example.sms;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;   //inject student repository object

	@Override
	public void run(String... args) throws Exception {
		if (studentRepository.count() == 0) {//manually insert new students record
		
			Student student1 = new Student("Saai Nandan", "Jena", "saaijena@gmail.com");
			studentRepository.save(student1);
		
			Student student2 = new Student("Utsav", "Jena", "utsavjena@gmail.com");
			studentRepository.save(student2);
		
			Student student3 = new Student("Jibanananda", "Jena", "jibanjena@gmail.com");
			studentRepository.save(student3);
		}
		
		
	}

}
