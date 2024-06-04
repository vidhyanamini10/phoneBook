package com.miniproject.controller;

import ch.qos.logback.core.model.Model;
import com.miniproject.entity.Contact;
import com.miniproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;
    //localhost:8080/contact
    @PostMapping(
            value = "/contact"
    )
    public String createContact(@RequestBody Contact contact){
        String status = contactService.saveContact(contact);
        return status;
    }
    //localhost:8080/viewAllContacts
    @GetMapping(
            value = "/viewAllContacts"
    )
    public List<Contact> viewAllContacts(){
        List<Contact> contacts = contactService.viewContact();
        return contacts;
    }
    //localhost:8080/viewAllContact/contactId
    @GetMapping(
            value = "/viewAllContact/{contactId}"
    )
    public Contact contactById(@PathVariable Integer contactId){

        return  contactService.getConcatById(contactId);
    }
    //localhost:8080/editcontact
    @PutMapping(
            value = "/editcontact"
    )
    public String updateRecord(@RequestBody Contact contact){

        String s = contactService.updateContact(contact);
        return  s;
    }
    //localhost:8080/deleterecord/contactId
    @DeleteMapping(
            value = "/deleterecord/{contactId}"
    )
    public String deleteRecord(@PathVariable Integer contactId){
        String s = contactService.deleteContactById(contactId);
        return s;
    }
    //localhost:8080/sortContacts
    @GetMapping("/sortContacts")
    public List<Contact> sortContacts(String contactName){
        List<Contact> contacts = contactService.filterContact(contactName);
        return contacts;
    }

}
