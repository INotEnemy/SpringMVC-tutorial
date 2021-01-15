package ru.sevsu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.StudentService;
import ru.sevsu.rest.service.TeacherService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMvcApplicationTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CourseService courseService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkStudentService() {
	}

}
