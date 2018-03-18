package com.wawcode.smogue.domain.api;

import org.apache.commons.mail.EmailException;

import java.net.MalformedURLException;

public interface SubscriberService {

    void sendConfirmationEmail(SubscriberDto subscriber) throws EmailException, MalformedURLException;
    void sendSmsNewsletter(String email);
    void readFromStation();
}
