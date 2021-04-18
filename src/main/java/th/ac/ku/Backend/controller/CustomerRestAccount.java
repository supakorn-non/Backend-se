package th.ac.ku.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.Backend.model.CustomerAccount;
import th.ac.ku.Backend.repository.CustomerAccountRepository;

import java.util.List;
import java.util.NoSuchElementException;

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
//    @GetMapping("/customer/{name}")
//    public List<CustomerAccount> getByName(@PathVariable String name){
//        try {
//            return repository.findByName(name);
//        }
//        catch (NoSuchElementException e){
//            return null;
//        }
//    }
//
//    @GetMapping("/customer/email/{email}")
//    public CustomerAccount getByEmail(@PathVariable String email){
//        CustomerAccount customer = repository.findByEmailAccount(email);
//        return customer;
//    }

    @PostMapping
    public void create(@RequestBody CustomerAccount customerAccount){
        System.out.println(customerAccount.toString());
        repository.save(customerAccount);
    }

}
