package com.nbp_calculator.nbp_computers.computer_model;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerInterface implements InitializingBean {

private ComputerInterface computerInterface;

    @Autowired
    public ManagerInterface(ComputerInterface computerInterface) {
        this.computerInterface = computerInterface;
    }

    public List<ComputerModel>getAllComputers (){
        return computerInterface.findAll(Sort.by("computerName"));
    }

    public void saveComputer (ComputerModel computer){
        computerInterface.save(computer);
    }

    public void deleteComputer (String _id){
        computerInterface.deleteById(_id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }


}
