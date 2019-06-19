package com.bridgelabz.fundooApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bridgelabz.fundooApp.model.Label;

public interface LabelRespository extends MongoRepository<Label, String>{

}
