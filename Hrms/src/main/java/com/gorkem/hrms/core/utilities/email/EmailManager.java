package com.gorkem.hrms.core.utilities.email;

import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Override
    public boolean isTheLinkClicked() {
        return true;
    }

    @Override
    public String sendToVerificationMail(String email) {
        return "Confirmation email has been sent. Please check your inbox";
    }
}
