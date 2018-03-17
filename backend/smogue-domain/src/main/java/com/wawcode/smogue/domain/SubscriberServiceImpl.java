package com.wawcode.smogue.domain;

import com.wawcode.smogue.domain.api.SubscriberService;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {


    @Override
    public void sendConfirmationEmail(String email, String name) {

    }

    @Override
    public void sendSmsNewsletter(String number, String name) {

    }
}
