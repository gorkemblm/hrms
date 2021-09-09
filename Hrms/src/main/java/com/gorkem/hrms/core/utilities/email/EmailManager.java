package com.gorkem.hrms.core.utilities.email;

import com.gorkem.hrms.business.constants.Messages;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("defaultEmailService")
public class EmailManager implements EmailService {

    @Override
    public boolean isTheLinkClicked() {
        return true;
    }

    @Override
    public String sendToVerificationMail(String email) {
        return Messages.SEND_TO_VERIFICATION_MAIL;
    }
}
