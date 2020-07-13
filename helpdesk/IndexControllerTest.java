package com.stinkelectronics.helpdesk.controller;

//import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.stinkelectronics.helpdesk.HelpdeskApplication;

@SpringBootTest
class IndexControllerTest {
	
	@Autowired
	private IndexController controller;

	@Test
	void contextLoads()
		throws Exception {
			assertThat(controller).isNotNull();
	}
	      
	
	

}
