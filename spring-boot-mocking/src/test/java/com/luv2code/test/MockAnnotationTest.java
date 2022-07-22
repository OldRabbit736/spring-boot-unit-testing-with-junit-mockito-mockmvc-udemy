package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;  // prototype bean

    @Autowired
    StudentGrades studentGrades;

    //@Mock
    @MockBean
    private ApplicationDao applicationDao;

    //@InjectMocks
    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    public void beforeEach() {
        studentOne.setEmailAddress("Eric");
        studentOne.setLastname("Roby");
        studentOne.setEmailAddress("eric.roby@abc.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    public void assertEqualsTestAddGrades() {
        when(applicationDao.addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults()
        )).thenReturn(100.00);

        assertEquals(100, applicationService.addGradeResultsForSingleClass(
                studentOne.getStudentGrades().getMathGradeResults()));

        // Verifies certain behavior happened once.
        verify(applicationDao)
                .addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1))
                .addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @DisplayName("Find Gpa")
    @Test
    public void assertEqualsTestFindGpa() {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);

        // 다른 스타일
        // Beware that when(Object) is always recommended for stubbing because
        // it is argument type-safe and more readable
        //doReturn(88.31).when(applicationDao).findGradePointAverage(studentGrades.getMathGradeResults());

        assertEquals(88.31, applicationService.findGradePointAverage(
                studentOne.getStudentGrades().getMathGradeResults()
        ));

    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull() {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(true);

        assertNotNull(applicationService.checkNull(studentOne.getStudentGrades().getMathGradeResults()),
                "Object should not be null");

    }




}
