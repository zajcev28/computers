package com.nbp_calculator.nbp_computers.computer_model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerInterface extends MongoRepository <ComputerModel, String> {
}
