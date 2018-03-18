package com.wawcode.smogue.domain;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.wawcode.smogue.domain.api.SubscriberDto;
import com.wawcode.smogue.domain.api.SubscriberService;
import com.wawcode.smogue.domain.persistence.Subscriber;
import com.wawcode.smogue.domain.persistence.SubscriberRepository;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Override
    public void sendConfirmationEmail(SubscriberDto subscriberDto) throws EmailException, MalformedURLException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("infosmogwaw", "infosmog111"));
        email.setSSLOnConnect(true);
        email.setFrom("infosmogwaw@gmail.com");
        email.setSubject("Confirm subscription");
        email.setMsg("CLICK THE LINK http://localhost:8081/api/email-confirmed?email="+subscriberDto.getEmail()); //TODO Message
        email.addTo(subscriberDto.getEmail());
        email.send();

        this.registerSubscriber(subscriberDto);
    }

    @Override
    public void sendSmsNewsletter(String email) {
        Subscriber subscriber = subscriberRepository.findByEmail(email);
        this.confirmActiveSubscriber(subscriber);

        String ACCOUNT_SID =
                "ACcb33ff76fa454d1f2fba66cb78917ea6";
        String AUTH_TOKEN =
                "3a684412494cf794416fa65ca30d8bf3";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+48"+subscriber.getNumber()), new PhoneNumber("+48732483483"),
                "Tomorrow's forecast in Financial District, San Francisco is Clear").create(); //TODO Message
    }

    private void registerSubscriber(SubscriberDto subscriberDto){
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(subscriberDto.getEmail());
        subscriber.setName(subscriberDto.getName());
        subscriber.setNumber(subscriberDto.getNumber());
        subscriber.setActiveUser(false);
        subscriber.setEmailSent(true);
        subscriberRepository.save(subscriber);
    }

    private void confirmActiveSubscriber(Subscriber subscriber){
        subscriber.setEmailSent(false);
        subscriber.setActiveUser(true);
        subscriberRepository.save(subscriber);
    }
}
