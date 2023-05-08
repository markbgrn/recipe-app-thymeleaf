package com.groupone.recipeappbackend.user.service;

import com.groupone.recipeappbackend.user.model.SecurityQuestion;
import com.groupone.recipeappbackend.user.repository.SecurityQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SecurityQuestionLoader implements ApplicationRunner {

    private final SecurityQuestionRepository securityQuestionRepository;

    @Autowired
    public SecurityQuestionLoader(SecurityQuestionRepository securityQuestionRepository) {
        this.securityQuestionRepository = securityQuestionRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int size = securityQuestionRepository.findAll().size();

        if(size == 0) {
            securityQuestionRepository.save(new SecurityQuestion("In what city or town did your parents meet?"));
            securityQuestionRepository.save(new SecurityQuestion("What is your oldest sibling's middle name?"));
            securityQuestionRepository.save(new SecurityQuestion("What city were you born in?"));
            securityQuestionRepository.save(new SecurityQuestion("What is the name of the college you applied to but didn't attend?"));
            securityQuestionRepository.save(new SecurityQuestion("What is the name of the first school you attended?"));
            securityQuestionRepository.save(new SecurityQuestion("Where is the destination of your most memorable school field trip?"));
            securityQuestionRepository.save(new SecurityQuestion("What is your maths teacher's surname in your 8th year of school?"));
            securityQuestionRepository.save(new SecurityQuestion("What was the name of your first stuffed toy?"));
            securityQuestionRepository.save(new SecurityQuestion("What is your driving instructor's first name?"));
        }
    }
}
