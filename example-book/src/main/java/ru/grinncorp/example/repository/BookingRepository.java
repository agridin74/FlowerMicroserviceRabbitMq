package ru.grinncorp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.grinncorp.example.entity.BookingRecord;

public interface BookingRepository extends JpaRepository<BookingRecord, Long>{

}
