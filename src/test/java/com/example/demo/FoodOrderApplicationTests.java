package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.ControllerOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodOrderApplicationTests 
{

	ControllerOrder cntrl=new ControllerOrder();
	
	@Test
	public void contextCheck() 	{	
		assertEquals("Hello, Welcome to FoodOrder (From OrderCart)", cntrl.show());
	}
}

