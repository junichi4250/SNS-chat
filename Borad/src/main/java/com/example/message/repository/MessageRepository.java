package com.example.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	//Id順にソートして、ページングを実装
	List<Message> findByOrderByIdDesc(Pageable pageable);
}
