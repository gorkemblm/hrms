package com.gorkem.hrms.core.utilities.email.abstracts;

public interface EmailService {

    boolean isTheLinkClicked();

    String sendToVerificationMail(String email);
}
