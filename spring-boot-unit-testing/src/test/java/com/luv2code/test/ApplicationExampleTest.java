package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// main과 test의 패키지 명이 다를 때 SpringBootApplication 클래스를 얄려줘야 한다.
@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    @Test
    void basicTest() {}
}
