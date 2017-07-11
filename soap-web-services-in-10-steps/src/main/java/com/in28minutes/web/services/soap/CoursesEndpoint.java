package com.in28minutes.web.services.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.Course;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;
import com.in28minutes.web.services.soap.service.CourseService;

@Endpoint
public class CoursesEndpoint {
	private static final String NAMESPACE_URI = "http://in28minutes.com/courses";

	@Autowired
	private CourseService courseService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse getCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		com.in28minutes.web.services.soap.model.Course retrieveCourse = courseService.retrieveCourse(request.getId());
		if(retrieveCourse==null)
			throw new RuntimeException("Course with id " + request.getId() + " not found"); 
		
		response.setCourse(mapCourse(retrieveCourse));

		return response;
	}

	private Course mapCourse(com.in28minutes.web.services.soap.model.Course courseFromDb) {
		Course course = new Course();
		course.setName(courseFromDb.getName());
		course.setDescription(courseFromDb.getDescription());
		course.setId(courseFromDb.getId());
		return course;
	}
}