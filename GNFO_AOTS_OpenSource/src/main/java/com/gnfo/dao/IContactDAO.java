package com.gnfo.dao;

import java.util.List;

import com.gnfo.model.Contact;

public interface IContactDAO {
    
    public void saveOrUpdate(Contact contact);
     
    public void delete(int contactId);
     
    public Contact get(int contactId);
     
    public List<Contact> list();
}
