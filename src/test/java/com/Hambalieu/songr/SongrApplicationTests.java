package com.Hambalieu.songr;
import com.Hambalieu.songr.controller.AlbumController;
import com.Hambalieu.songr.controller.HelloController;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static com.Hambalieu.songr.controller.HelloController.setCapitalize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class songrApplicationTests{
	@Test
	void ContextLoads(){
		HelloController testController = new HelloController();
		assertNotNull(testController, "Test controller was null");
	}
	@Test
	void ContextLoads2(){
		AlbumController testController = new AlbumController();
		assertNotNull(testController, "Test controller was null");
	}




}
