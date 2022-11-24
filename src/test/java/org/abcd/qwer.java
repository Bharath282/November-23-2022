package org.abcd;

import org.test.BaseClass;
import org.testng.annotations.Test;

public class qwer extends BaseClass {
	

	@Test
	private void tc1() {
	System.out.println("TC1 : "+ Thread.currentThread().getId());
	browserLaunch();
	launchUrl("https://www.naukri.com/");
    quitCurrentPage();
	}

	@Test
	private void tc2() {
	System.out.println("TC2 : "+ Thread.currentThread().getId());
	browserLaunch();
	launchUrl("https://www.instagram.com/");
	quitCurrentPage();
	}
	
	@Test
	private void tc3(){
	System.out.println("TC3 : "+ Thread.currentThread().getId());
	browserLaunch();
	launchUrl("https://www.facebook.com/");
	quitCurrentPage();
	}
	
	
	
	
}
