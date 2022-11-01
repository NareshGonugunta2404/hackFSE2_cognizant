package com.united.stock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.united.stock.entity.UserNum;

@Repository
public interface UserNumRepository extends MongoRepository<UserNum, String> {
  UserNum findTopByOrderByIdDesc();
}
