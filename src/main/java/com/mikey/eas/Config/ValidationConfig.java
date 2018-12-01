package com.mikey.eas.Config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/11/5 22:12
 * @Version 1.0
 */
//@Configuration
public class ValidationConfig {
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class ) .configure() .addProperty( "hibernate.validator.fail_fast", "true" ).
        //为true时代表快速失败模式，false则为全部校验后再结束。 .
        buildValidatorFactory(); Validator validator = validatorFactory.getValidator();
        return validator;
        }

}
