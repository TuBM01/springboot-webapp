package com.tubm.webapp.backend;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner testConnection(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("--- KẾT NỐI POSTGRES THÀNH CÔNG! ---");
				System.out.println("Database: " + conn.getMetaData().getDatabaseProductName());
			} catch (Exception e) {
				System.out.println("--- KẾT NỐI THẤT BẠI: " + e.getMessage());
			}
		};
	}

}
