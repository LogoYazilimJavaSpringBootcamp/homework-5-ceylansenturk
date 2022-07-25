package com.java.moviereviewsite.services;


import com.java.moviereviewsite.client.PaymentClient;
import com.java.moviereviewsite.dto.CurrencyType;
import com.java.moviereviewsite.dto.EmailDto;
import com.java.moviereviewsite.dto.Payment;
import com.java.moviereviewsite.model.User;
import com.java.moviereviewsite.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RabbitMQService rabbitMQService;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private PaymentClient paymentClient;

    public User signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email){
        rabbitTemplate.convertAndSend("moviereviewsite.email", new EmailDto("user@gmail.com", "Movie",
                "Hoşgeldin! Üyelik satın alıp sınırsız erişim hakkına sahip olabilirsin."));

       if(userRepository.findByUsername(username).isPresent()){
           log.info("this username is used");}

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        Payment payment = paymentClient.createPayment(new Payment(LocalDateTime.now(), CurrencyType.TL, BigDecimal.TEN, Month.of(1)));
        log.info(payment.toString());
        return userRepository.save(user);
    }
    public User signIn(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("email") String email){
        Optional<User> user = userRepository.findByUsername(username);
        boolean isPresent = user.isPresent();
        if(isPresent){
            return user.get();
        }else{
        log.info("user missed");}
        return null;
    }

    public User updateUser(User user) {

        String sql = "Update User set email = yeniemail where id =1";

        User foundUser = userRepository.findById(user.getId()).get();

        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());

        return userRepository.save(foundUser);
    }

}
