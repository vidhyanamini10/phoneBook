package com.miniproject.service;

import com.miniproject.entity.Contact;
import com.miniproject.repository.ContactRepository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class Service implements ContactService{
    private ContactRepository contactrepo;
    @Override
    @PostMapping(
            value = "/contactdetails",
            consumes = {"application/xml","application/json"}
    )
    public String saveContact(Contact contact) {

        Contact savedContact = this.contactrepo.save(contact);
        return "Contact saved Sucessfully!";
    }

    @Override
    public List<Contact> viewContact() {


        return this.contactrepo.findAll();
    }

    @Override
    public Contact getConcatById(Integer contactId) {


        return this.contactrepo.findAllById(contactId);
    }

    @Override
    public String updateContact(Contact contact) {
        try {
            Contact con = this.contactrepo.getById(contact.getContactId());
            con.setContactName(contact.getContactName());
            con.setContactEmail(contact.getContactEmail());
            con.setContactNumber(contact.getContactNumber());
            Contact updateContact = this.contactrepo.save(con);
        }catch (Exception e){
            System.out.println("Contact Id does not exits");
        }
        return "Contact updated sucessfully";
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
}
