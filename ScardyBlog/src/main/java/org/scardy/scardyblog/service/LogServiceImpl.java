package org.scardy.scardyblog.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Service
public class LogServiceImpl implements LogService{
	final DefaultMessageService messageService;
	public static int verificationNumber;
    private LogServiceImpl() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSKO8YI59EXNTER", "QMLBESR7DYZOFCJXNTNG90XJQD0BZOBH", "https://api.coolsms.co.kr");
    }
    
	@Override
	//SingleMessageSentResponse
	public SingleMessageSentResponse sendMassage(long tel) {
		Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01063462516");
        //message.setTo(String.valueOf(tel));
        message.setTo("01063462516");
        Random random = new Random();
        verificationNumber = random.nextInt(899999)+100000;
        message.setText("인증번호는 " + verificationNumber + "입니다.");
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        return response;
	}

}
