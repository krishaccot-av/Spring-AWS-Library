package com.krish.booklibrary;

import com.krish.booklibrary.bean.JsonDataLoader;
import com.krish.booklibrary.model.Data;
import com.krish.booklibrary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
@Import(JsonDataLoader.class)
public class BookLibraryConfig implements WebMvcConfigurer {

    @Override
    public  void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");
    }

    @Autowired
    private Data data;
    @Bean
    ApplicationRunner configureRepository(BookRepository bookRepository,
                                          SubscribeBookRepository subScribeBookRepository,
                                          BookReviewRepository bookReviewRepository,
                                          UserRepository useRepository,
                                          AuthorRepository authorRepository,
                                          MemberRepository memberRepository) {
        return args -> {
            bookRepository.saveAll(data.getBooks());
            subScribeBookRepository.saveAll(data.getIssues()!=null? data.getIssues(): new ArrayList<>());
            bookReviewRepository.saveAll(data.getReviews()!=null ? data.getReviews() : new ArrayList<>());
            useRepository.saveAll(data.getUsers());
            authorRepository.saveAll(data.getAuthors());
            memberRepository.saveAll(data.getMembers());
        };
    }
}
