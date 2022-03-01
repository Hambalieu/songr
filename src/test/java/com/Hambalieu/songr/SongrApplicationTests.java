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

//
//	@Test
//	void testSetCapitalize_SingleWordToUpperCase() {
//		assertEquals(
//				"testSetCapitalize_SingleWordToUpperCase should return: ",
//				"WORD",
//				setCapitalize("word")
//		);
//	}
//	@Test
//	void testSetCapitalize_MultipleWordsToUpperCase() {
//		assertEquals(
//				"testSetCapitalize_MultipleWordToUpperCase should return: ",
//				"MULTIPLE WORDS CAPITALIZED",
//				setCapitalize("multIplE WoRds cApitaliZED")
//		);
//	}


}
