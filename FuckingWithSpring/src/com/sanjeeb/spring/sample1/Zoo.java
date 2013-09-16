package com.sanjeeb.spring.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class Zoo {
  private WildAnimal wildanimal;
 
  @Autowired
  public void setWildanimal(WildAnimal wildanimal) {
    this.wildanimal = wildanimal;
  }
 
  public void testSound() {
    System.out.println(wildanimal.sound());
  }
}