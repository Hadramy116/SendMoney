package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.service.imp.OperationServiceImp;
import mr.send.money.sendmoney.service.util.UserDto.CreditOrDebitForm;
import mr.send.money.sendmoney.service.util.UserDto.SendingForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping( "/operations" )
public class OperationController {

    private OperationServiceImp operationServiceImp;
    
    Logger LOGGER =LoggerFactory.getLogger(OperationController.class);

    public OperationController(OperationServiceImp operationServiceImp) {
    	
        this.operationServiceImp = operationServiceImp;
    }

    @PostMapping( "/credit" )
    public Transaction credit(@RequestBody @Valid @NotNull CreditOrDebitForm creditOrDebitForm) {
    	LOGGER.info("Entree dans le methode credit avec le parametre creditOrDebitForm:{}",creditOrDebitForm );
        return operationServiceImp.creditAccount(creditOrDebitForm);
    }

    @PostMapping( "/debit" )
    public Transaction debit(@RequestBody @Valid @NotNull CreditOrDebitForm creditOrDebitForm) {
    	LOGGER.info("Entree dans le methode debit avec le parametre creditOrDebitForm:{}",creditOrDebitForm );
        return operationServiceImp.debitAccount(creditOrDebitForm);
    }

    @PostMapping( "/send" )
    public Transaction send(@RequestBody @Valid @NotNull SendingForm sendingForm) {
    	LOGGER.info("Entree dans le methode send avec le parametre sendingForm:{}",sendingForm );
        return operationServiceImp.sendMoney(sendingForm);
    }

}
