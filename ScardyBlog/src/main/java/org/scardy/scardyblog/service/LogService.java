package org.scardy.scardyblog.service;

import org.scardy.scardyblog.entity.Account;

import net.nurigo.sdk.message.response.SingleMessageSentResponse;

public interface LogService {
	public SingleMessageSentResponse sendMassage(String tel);

	public boolean compareCode(int code);
	
	public boolean setExistsById(String id);
	
	public boolean setExistsByTel(String tel);
	
	public boolean existsById(String id);
	
	public boolean existsByTel(String tel);

	public boolean existsByNickName(String nickname);

	public void setPasswordCheck(boolean result);

	public boolean checkVerification();

	public boolean register(Account account);
	
	

}
