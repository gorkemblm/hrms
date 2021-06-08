package com.gorkem.hrms.core.adapters.google;

import com.gorkem.hrms.core.utilities.email.EmailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("googleCheckService")
public class GoogleServiceAdapter implements EmailService {

    @Override
    public boolean isTheLinkClicked() {
        return true;
    }

    @Override
    public String sendToVerificationMail(String email) {
        return "Confirmation email has been sent with Google. Please check your inbox";
    }
}
