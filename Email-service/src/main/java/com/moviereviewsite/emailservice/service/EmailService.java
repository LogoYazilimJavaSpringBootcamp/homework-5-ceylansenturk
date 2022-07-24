package com.moviereviewsite.emailservice.service;

import com.moviereviewsite.emailservice.model.Email;
import com.moviereviewsite.emailservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
    public void sendEmail(String email){

        Email emailTemp = new Email();
        emailTemp.setToEmail(email);
        emailTemp.setEmailMessage("Sisteme yeni bir film eklendi.");
        emailTemp.setTitle("Yeni film uyarısı.");
        emailRepository.save(emailTemp);
    }
}
