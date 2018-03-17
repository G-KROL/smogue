package com.wawcode.smogue.domain.api;

public interface SubscriberService {

    void sendConfirmationEmail(String email,String name);
    void sendSmsNewsletter(String number, String name);
}
