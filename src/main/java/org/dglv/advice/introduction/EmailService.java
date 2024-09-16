package org.dglv.advice.introduction;

@EmailClient
public interface EmailService {
    void sendEmail(String email, @To String toAddress);
}
