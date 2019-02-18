package com.info.course;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.info.course.domain.Course;
import com.info.course.domain.CourseRepository;
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
    
    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }  
    
    @Test
    public void addUser() {
    	User user = new User("testuser1", "testuser", "USER");

    	assertNull(user.getId());
    	userRepository.save(user);
    	assertNotNull(user.getId());
    }

    
	@Test
    public void addStudent() {
		Student student = new Student("Test1", "Student", "IT", "test@test.com");
		
		studentRepository.save(student);
		Optional<Student> findStudent = studentRepository.findById(student.getId());
		assertTrue(findStudent.isPresent());
    }
	
	@Test
    public void addCourse() {
		
		Course course = new Course();
		course.setName("testcourse1");
		course.setStudents(new HashSet<>());
		courseRepository.save(course);
		List<Course> courses = courseRepository.findByName(course.getName());
		assertTrue(!courses.isEmpty());
    }
	
	@Test
    public void addCourse1() {
		
		Course course = new Course();
		course.setName("testcourse1");
		course.setStudents(new HashSet<>());
		courseRepository.save(course);
		List<Course> courses = courseRepository.findByName(course.getName());
		assertTrue(!courses.isEmpty());
    }
    
}
