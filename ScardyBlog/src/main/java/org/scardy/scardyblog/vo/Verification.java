package org.scardy.scardyblog.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Verification {
	private static Verification verificationInstance;
	private int verificationCode;
	private boolean verificated = false;
	private boolean checkTel = false;
	private boolean checkId = false;
	private boolean checkPw = false;	
	private boolean checkNickName = false;
	
	private Verification() {
		System.out.println("instance");
	}
	public static Verification getVerificationInstance() {
		return verificationInstance;
	}

	

}
