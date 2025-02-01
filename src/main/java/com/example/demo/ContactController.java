package com.example.demo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")

public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){
        return new ResponseEntity<>(contactService.createContact(contact), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id,@Valid @RequestBody Contact contact){
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search/email/{domain}")
    public List<Contact> searchByEmailDomain(@PathVariable String domain){
        return contactService.findByEmailDomain(domain);
    }
    @GetMapping("/search/age-range")
    public List<Contact> searchByAgeRange(@RequestParam int startYear, @RequestParam int endYear){
        return contactService.findContactsByAgeRange(startYear, endYear);
    }

}
