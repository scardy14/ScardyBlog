package org.scardy.scardyblog.service;

import net.nurigo.sdk.message.response.SingleMessageSentResponse;

public interface LogService {
	public SingleMessageSentResponse sendMassage(long tel);

}
