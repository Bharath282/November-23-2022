package org.abcd;

import org.test.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Sample extends BaseClass {
	@Test()
	private void tc4() {
		System.out.println("TC4 : "+ Thread.currentThread().getId());
		browserLaunch();
		launchUrl("https://www.youtube.com/");
	    quitCurrentPage();
	}
	
	@Test
	private void tc5() {
		System.out.println("TC5 : "+ Thread.currentThread().getId());
		browserLaunch();
		launchUrl("https://www.netflix.com/browse");
	    quitCurrentPage();
	}
	
	@Test
	private void tc6() {
		System.out.println("TC6 : "+ Thread.currentThread().getId());
		browserLaunch();
		launchUrl("https://www.reship.com/info/online-shopping-uk.html");
	    quitCurrentPage();
	}
	
}
