package th.ac.ku.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.Backend.model.CustomerAccount;
import th.ac.ku.Backend.repository.CustomerAccountRepository;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestAccount {
    private CustomerAccountRepository repository;

    @Autowired
    public CustomerRestAccount(CustomerAccountRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<CustomerAccount> getAll(){
        return repository.findAll();
    }

//    @GetMapping("/{id}")
//    public CustomerAccount getOne(@PathVariable  int id){
//        try {
//            return repository.findById(id).get();
//        }
//        catch (NoSuchElementException e){
//            return null;
//        }
//    }
//
//    @GetMapping("/customer/{email}")
//    public List<CustomerAccount> getByAll(@PathVariable String name){
//        try {
//            return repository.findByName(name);
//        }
//        catch (NoSuchElementException e){
//            return null;
//        }
//    }

    @GetMapping("/customer/email/{email}")
    public CustomerAccount getByEmailAccount(@PathVariable String email){
        CustomerAccount customer = repository.findByEmail(email);
        return customer;
    }

    @PostMapping
    public void create(@RequestBody CustomerAccount customerAccount){
        System.out.println(customerAccount.toString());
        repository.save(customerAccount);
    }

    @PostMapping("customer/login")
    public CustomerAccount login(@RequestBody CustomerAccount customerAccount){
        CustomerAccount customer = null;
        if (repository.findByEmail(customerAccount.getEmail()) != null){
            customer = repository.findByEmail(customerAccount.getEmail());
        }else if (repository.findByTel(customerAccount.getTel()) != null){
            customer = repository.findByTel(customerAccount.getTel());
        }
        System.out.println(customer.getPassword());
        System.out.println(customerAccount.getPassword());
        if (customer.getPassword().equals(customerAccount.getPassword())) {
            System.out.println(customer);
            return customer;
        }
        return null;
    }

}
