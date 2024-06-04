package com.miniproject.service;

import com.miniproject.entity.Contact;

import java.util.List;

public interface ContactService {
    public String saveContact(Contact contact);
    public List<Contact> viewContact();
    public Contact getConcatById(Integer contactId);
    public String updateContact(Contact contact);
    public String deleteContactById(Integer contactId);

}
