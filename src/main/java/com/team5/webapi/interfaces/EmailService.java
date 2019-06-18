package com.team5.webapi.interfaces;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}