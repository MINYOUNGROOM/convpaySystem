package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// springboot를 쓰면 기본적으로 Component가 켜져있음
// 그래서  springboot 할 때는 @Component 어노테이션을 사용하면 된다
@ComponentScan(basePackages ="com.zerobase.convpay")
//@ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {



}
