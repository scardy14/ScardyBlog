package org.scardy.scardyblog.service;

import java.util.Random;

import org.scardy.scardyblog.repository.AccountRepository;
import org.scardy.scardyblog.vo.Verification;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService{
	private final DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCSKO8YI59EXNTER", "QMLBESR7DYZOFCJXNTNG90XJQD0BZOBH", "https://api.coolsms.co.kr");;
	private final AccountRepository accountRepository;
	private Verification verification = Verification.getVerificationInstance();
	
	@Override
	public boolean existsById(String id) {
		boolean result = accountRepository.existsById(id);
		return result;
	}
	@Override
	public boolean existsByTel(String tel) {
		boolean result = accountRepository.existsByTel(tel);
		return result;
	}
	
	@Override
	//SingleMessageSentResponse
	public SingleMessageSentResponse sendMassage(String tel) {
		Message message = new Message();
        message.setFrom("01063462516");
        message.setTo(tel);
        Random random = new Random();
        verification.setVerificationCode(random.nextInt(899999)+100000);
        message.setText("인증번호는 " + verification.getVerificationCode() + "입니다.");
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        return response;
	}
	
	@Override
	public boolean compareCode(int code) {
		if(code==verification.getVerificationCode()) {
			verification.setVerificated(true);
			return true;
		} else {
			verification.setVerificated(false);
			return false;
		}		
	}

	@Override
	public boolean setExistsById(String id) {
		boolean result = accountRepository.existsById(id);
		if(!result) {
			verification.setCheckId(true);
		} else {
			verification.setCheckId(false);
		}
		return result;
	}

	@Override
	public boolean setExistsByTel(String tel) {
		boolean result = accountRepository.existsByTel(tel);
		if(!result) {
			verification.setCheckTel(true);
		} else {
			verification.setCheckTel(false);
		}
		return result;
	}


	
}
