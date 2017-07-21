package com.in28minutes.soap.webservices.coursemanagement;

import java.math.BigInteger;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetAllCourseDetailsRequest;
import com.in28minutes.courses.GetAllCourseDetailsResponse;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse getCourseDetails(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse courseDetailsResponse = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setDescription("description");
		courseDetails.setId(new BigInteger("1"));
		courseDetails.setName("name");
		courseDetailsResponse.setCourseDetails(courseDetails);
		return courseDetailsResponse;
	}

	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse getAllCourseDetails(@RequestPayload GetAllCourseDetailsRequest request) {
		GetAllCourseDetailsResponse courseDetailsResponse = new GetAllCourseDetailsResponse();

		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setDescription("description");
		courseDetails.setId(new BigInteger("1"));
		courseDetails.setName("name");
		List<CourseDetails> courseDetailslist = courseDetailsResponse.getCourseDetails();
		courseDetailslist.add(courseDetails);

		CourseDetails courseDetails2 = new CourseDetails();
		courseDetails2.setDescription("descriptio2n");
		courseDetails2.setId(new BigInteger("2"));
		courseDetails2.setName("name2");

		courseDetailslist.add(courseDetails2);

		return courseDetailsResponse;
	}

}
