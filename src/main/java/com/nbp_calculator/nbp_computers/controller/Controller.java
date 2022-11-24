package com.nbp_calculator.nbp_computers.controller;

import com.nbp_calculator.nbp_computers.computer_model.ComputerModel;
import com.nbp_calculator.nbp_computers.computer_model.ManagerInterface;
import com.nbp_calculator.nbp_computers.nbp_service_calculator.NbpServiceCalculator;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;

@org.springframework.stereotype.Controller
@RequestMapping()
public class Controller {

    ManagerInterface managerInterface;

    @Autowired
    public Controller(ManagerInterface managerInterface) {
        this.managerInterface = managerInterface;
    }

    @GetMapping
    public String showComputers(Model model) {
        model.addAttribute("computersList", managerInterface.getAllComputers());
        return "computers";
    }

    @GetMapping("/add")
    public String addComputerForm() {
        return "add-computer";
    }

    @PostMapping
    public RedirectView saveComputer(ComputerModel computer) throws JSONException {
        Double priceInDolars = Double.valueOf(computer.getComputerPriceInDolars());
        Double dolarPrice = Double.valueOf(NbpServiceCalculator.getPriceFromDate(computer.getDateWhenDolarWasBroughtFromNBP_API()));
        computer.setDolarPrice(String.valueOf(dolarPrice));
        computer.setComputerPriceInPLN(String.valueOf(priceInDolars * dolarPrice));
        managerInterface.saveComputer(computer);
        return new RedirectView("/");
    }

    @PostMapping("/delete/{_id}")
    public RedirectView deleteComputer(@PathVariable String _id) {
        managerInterface.deleteComputer(_id);
        return new RedirectView("/");
    }
}
