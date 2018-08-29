package registration;

import java.io.IOException;

import functions.Email;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email testEm = new Email("david.vennemeier@gmail.com", "WIP Gruppe 4", "Testemail über Eclipse");
		try {
			testEm.Send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
