package com.info.course;

import org.junit.Test;
import org.junit.runner.*;

import static org.junit.Assert.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.course.domain.Student;
import com.info.course.domain.StudentRepository;
import com.info.course.domain.User;
import com.info.course.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentPortalApplicationTests {


	private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    
    
    @Test
    public void addUser() {
    	User user = new User("testuser", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }
    
	@Test
    public void addStudent() {
		Student student = new Student("Test", "Student", "IT", "test@test.com");
		
		studentRepository.save(student);
		Optional<Student> findStudent = studentRepository.findById(student.getId());
		assertTrue(findStudent.isPresent());
    }
    
}
