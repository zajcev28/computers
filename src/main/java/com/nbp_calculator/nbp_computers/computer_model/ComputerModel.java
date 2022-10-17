package com.nbp_calculator.nbp_computers.computer_model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Computers")
public class ComputerModel {

    @Id
    String id_;
    String dolarPrice;
    String computerName;
    String computerPriceInDolars;
    String computerPriceInPLN;

    String dateWhenDolarWasBroughtFromNBP_API;

    public ComputerModel(String id_, String dolarPrice, String computerName, String computerPriceInDolars, String computerPriceInPLN,
                          String dateWhenDolarWasBroughtFromNBP_API) {
        this.id_ = id_;
        this.dolarPrice = dolarPrice;
        this.computerName = computerName;
        this.computerPriceInDolars = computerPriceInDolars;
        this.computerPriceInPLN = computerPriceInPLN;
        this.dateWhenDolarWasBroughtFromNBP_API = dateWhenDolarWasBroughtFromNBP_API;
    }

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getDolarPrice() {
        return dolarPrice;
    }

    public void setDolarPrice(String dolarPrice) {
        this.dolarPrice = dolarPrice;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerPriceInDolars() {
        return computerPriceInDolars;
    }

    public void setComputerPriceInDolars(String computerPriceInDolars) {
        this.computerPriceInDolars = computerPriceInDolars;
    }

    public String getComputerPriceInPLN() {
        return computerPriceInPLN;
    }

    public void setComputerPriceInPLN(String computerPriceInPLN) {
        this.computerPriceInPLN = computerPriceInPLN;
    }

    public String getDateWhenDolarWasBroughtFromNBP_API() {
        return dateWhenDolarWasBroughtFromNBP_API;
    }

    public void setDateWhenDolarWasBroughtFromNBP_API(String dateWhenDolarWasBroughtFromNBP_API) {
        this.dateWhenDolarWasBroughtFromNBP_API = dateWhenDolarWasBroughtFromNBP_API;
    }
}
