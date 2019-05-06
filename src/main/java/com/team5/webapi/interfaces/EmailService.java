package com.team5.webapi.interfaces;

import java.util.List;

import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}