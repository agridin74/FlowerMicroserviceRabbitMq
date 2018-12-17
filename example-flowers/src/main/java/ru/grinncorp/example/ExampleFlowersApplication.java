package ru.grinncorp.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ru.grinncorp.example.entity.Flower;
import ru.grinncorp.example.repository.FlowersRepository;

@SpringBootApplication
public class ExampleFlowersApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ExampleFlowersApplication.class);
	
	@Autowired
	FlowersRepository flowersRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExampleFlowersApplication.class, args);
	}
	@Override
	public void run(String...strings ) throws Exception {
		Flower[] flowers = {
				new Flower("ABS001","11-DEC-18","200"),
				new Flower("ABS002","11-DEC-18","200"),
				new Flower("ABS003","11-DEC-18","250"),
				new Flower("ABS004","11-DEC-18","260"),
				new Flower("ABS005","11-DEC-18","270"),
				new Flower("ABS006","11-DEC-18","280"),
				new Flower("ABS007","11-DEC-18","290")};
		List<Flower> list = Arrays.stream(flowers).collect(Collectors.toList());
		list.forEach(flower -> flowersRepository.save(flower));
		logger.info("Тест : " 
		   + flowersRepository.getFlowerByPlantingArticleAndPlantingDate("ABS003", "11-DEC-18"));
	}
}
