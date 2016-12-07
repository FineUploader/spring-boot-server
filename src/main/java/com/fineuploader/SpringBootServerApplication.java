package com.fineuploader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@SpringBootApplication
@EnableConfigurationProperties(UploadServerProperties.class)
public class SpringBootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (args) -> {
		Path path = Paths.get("uploads");
			System.out.println("Path: " + path);
			String s = "Hello World! ";
			byte data[] = s.getBytes();
			Path p = Paths.get("./logfile.txt");

			try (OutputStream out = new BufferedOutputStream(
					Files.newOutputStream(p, CREATE, APPEND))) {
				out.write(data, 0, data.length);
			} catch (IOException x) {
				System.err.println(x);
			}
		};
	}
}
