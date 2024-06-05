package com.miniproject.service;

import com.miniproject.entity.Contact;
import com.miniproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactrepo;
    @Override

    public String saveContact(Contact contact) {

        Contact savedContact = contactrepo.save(contact); // insertion operation
        if(savedContact.getContactId()!=null){
            return "Contact saved Sucessfully!";
        }
        else{
            return "unable to save the contact details";
        }

    }
    @Override
    public List<Contact> viewContact() {
        return this.contactrepo.findAll();
    }
    @Override
    public Contact getConcatById(Integer contactId) {
        Optional<Contact> byId = contactrepo.findById(contactId);
        if(byId.isPresent()){
            return byId.get();
        }
        else{
            return null;
        }
    }
    @Override
    //modified form data
    public String updateContact(Contact contact) {
        if(contactrepo.existsById(contact.getContactId())){
            contactrepo.save(contact); // will perform updation
            return "Contact updated sucessfully";
        }else{
            return "No record found";
        }

    }
    @Override
    public String deleteContactById(Integer contactId) {
       if(this.contactrepo.existsById(contactId)){

        this.contactrepo.deleteById(contactId);
    }
       else{
           return "Cannot find the account";
       }
       return "Contact deleted sucessfully";
    }

    @Override
    public List<Contact> filterContact() {
        List<Contact> contactNames = contactrepo.findAll(Sort.by("contactName"));
        return contactNames;
    }
}
