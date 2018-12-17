package ru.grinncorp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.example.entity.Flower;

public interface FlowersRepository extends JpaRepository<Flower, Long>{
	
	Flower getFlowerByPlantingArticleAndPlantingDate(String plantingArticle,String plantingDate);

}
