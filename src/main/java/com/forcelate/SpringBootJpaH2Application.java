package com.forcelate;


import com.forcelate.model.Article;
import com.forcelate.model.User;
import com.forcelate.repositpry.ArticleRepository;
import com.forcelate.repositpry.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.forcelate.model.Color.*;

@SpringBootApplication
public class SpringBootJpaH2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaH2Application.class, args);
    }

   @Bean
   CommandLineRunner runner(UserRepository userRepository, ArticleRepository articleRepository) {
       return args -> {
           userRepository.save(new User("Pavlo", 22));
           userRepository.save(new User("Petro", 20));
           userRepository.save(new User("Ivan", 30));
           userRepository.save(new User("Oleh", 35));
           userRepository.save(new User("Adam", 24));
           userRepository.save(new User("Roman", 28));
           userRepository.save(new User("Igor", 19));

           articleRepository.save(new Article("6 Instant Confidence Boosters", GREEN, userRepository.getOne(Long.valueOf(1))));
           articleRepository.save(new Article("Parenting Guru: From Chaos to Access", RED, userRepository.getOne(Long.valueOf(2))));
           articleRepository.save(new Article("Rob Banks Legally", BLUE, userRepository.getOne(Long.valueOf(1))));
           articleRepository.save(new Article("Are You Too Clever For Success?", GREEN, userRepository.getOne(Long.valueOf(3))));
           articleRepository.save(new Article("Six Types Of Investors – Which Group Are You In?", RED, userRepository.getOne(Long.valueOf(1))));
           articleRepository.save(new Article("How I Doubled My Money With Facebook Ads", BLUE, userRepository.getOne(Long.valueOf(4))));
           articleRepository.save(new Article("For At Risk Youths, Learning Digital Media Is A Luxury", YELLOW, userRepository.getOne(Long.valueOf(5))));
           articleRepository.save(new Article("The Ultimate Guide to Making Money Online", PINK, userRepository.getOne(Long.valueOf(1))));
           articleRepository.save(new Article("21 Ways to Dominate Youtube: The Ultimate Guide", GREY, userRepository.getOne(Long.valueOf(6))));
           articleRepository.save(new Article("Thousands Already Make Millions Online And So Can You", BROWN, userRepository.getOne(Long.valueOf(6))));
           articleRepository.save(new Article("No Cellphones – By Law", BLACK, userRepository.getOne(Long.valueOf(7))));
       };
   }

}
