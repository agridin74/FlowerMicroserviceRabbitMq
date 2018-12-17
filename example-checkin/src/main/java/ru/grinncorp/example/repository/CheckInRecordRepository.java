package ru.grinncorp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.example.entity.CheckInRecord;

public interface CheckInRecordRepository extends JpaRepository<CheckInRecord, Long>{

}
