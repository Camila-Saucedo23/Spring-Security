package com.examplevideo2.demo2;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.examplevideo2.demo2.models.ERole;
import com.examplevideo2.demo2.models.RoleEntity;
import com.examplevideo2.demo2.models.UserEntity;
import com.examplevideo2.demo2.repositories.UserRepository;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
//
//@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Bean
//	CommandLineRunner init(){
//		return args -> {
//
//			UserEntity userEntity = UserEntity.builder()
//					.email("santiago@mail.com")
//					.username("santiago")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.ADMIN.name()))
//							.build()))
//					.build();
//
//			UserEntity userEntity2 = UserEntity.builder()
//					.email("anyi@mail.com")
//					.username("anyi")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.USER.name()))
//							.build()))
//					.build();
//
//			UserEntity userEntity3 = UserEntity.builder()
//					.email("andrea@mail.com")
//					.username("andrea")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(RoleEntity.builder()
//							.name(ERole.valueOf(ERole.INVITED.name()))
//							.build()))
//					.build();
//
//			userRepository.save(userEntity);
//			userRepository.save(userEntity2);
//			userRepository.save(userEntity3);
//		};
//	}

}
