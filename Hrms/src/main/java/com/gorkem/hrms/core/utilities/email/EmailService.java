package com.gorkem.hrms.core.utilities.email;

public interface EmailService {

    boolean isTheLinkClicked();

    String sendToVerificationMail(String email);
}
