package com.united.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.united.stock.entity.UserNum;
import com.united.stock.repository.UserNumRepository;

@Service
public class UserNumService {

  @Autowired
  private UserNumRepository userNumRepository;

  public long getNext() {
    UserNum last = userNumRepository.findTopByOrderByIdDesc();
    if(last == null) {
    	last= new UserNum();
    	last.setSeq(10000);
    }
    Integer lastNum = last.seq;
    UserNum next = new UserNum(lastNum+1);
    userNumRepository.save(next);
    return next.seq;
  }
}
