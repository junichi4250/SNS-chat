package com.example.message.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.message.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	//Id順にソートして、ページングを実装
	List<Message> findByOrderByIdDesc(Pageable pageable);
}
