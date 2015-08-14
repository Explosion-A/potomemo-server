package pictureService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PictureSerivceTest{
	
	@Before
	public void initContext() {
		
		
	}
	@Test
	public void test() {
		ApplicationContext context =new ClassPathXmlApplicationContext("spring-context.xml");

	}

}
