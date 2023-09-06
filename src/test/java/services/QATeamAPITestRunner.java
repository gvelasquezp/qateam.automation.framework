package services;

import org.junit.Test;

public class QATeamAPITestRunner extends QATeamAPITest{
	
	@Test
	public void verifyCreatePet() throws Exception {
		
		verifyCreatePet(1001, "100", "CategoryName100", "Pet Name ID 1000", "PhotoURL ID 1000", "100", "TagName100");
		
	}
	
	@Test
	public void verifyGetPet() throws Exception {
		
		verifyGetPet(1001);
		
	}
	
	@Test
	public void verifyGetStore() throws Exception {
		
		verifyGetPet(5);
		
	}

}
