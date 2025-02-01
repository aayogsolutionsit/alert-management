package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }
    public List<Contact> getAllContacts() {
            return repository.findAll();
    }

    public Contact getContactById(Long id) {
        return repository.findById(id).orElseThrow(() ->new RuntimeException("Couldn't find contact'"));
    }

    public Contact updateContact(Long id,Contact contactDetails){
        Contact contact= getContactById(id);
        BeanUtils.copyProperties(contactDetails,contact,"id");
        return repository.save(contact);
    }
    public void deleteContact(Long id) {
        repository.deleteById(id);
    }

    //find users by email domain
    public List<Contact>  findByEmailDomain(String domain){
        return repository.findByEmailContaining(domain);
    }
    //find users by date of birth range
    public List<Contact> findContactsByAgeRange(int startYear, int endYear)
    {
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        LocalDate endDate = LocalDate.of(endYear, 12, 31);
        return repository.findByDobBetween(startDate, endDate);
    }



}
