package io.github.kickccat.java.domain;

import java.util.ArrayList;

public class MobilePhone {

    private String phoneNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.contacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }

        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with the new contact " + newContact.getName() + ".");
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if (foundPosition < 0){
            System.out.println(contact.getName() + " was not found.");
            return false;
        }

        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    public String queryContact(Contact contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }
        return  null;
    }

    public void printContacts(){
        System.out.println("Contact List: ");
        for (int i=0; i<this.contacts.size(); i++){
            System.out.println((i+1) + "." +
            this.contacts.get(i).getName() + " -> " +
            this.contacts.get(i).getPhoneNumber());
        }
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return this.contacts.get(position);
        }
        return null;
    }

    private int findContact(String name) {
        for (int i=0; i<this.contacts.size(); i++){
            if (this.contacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contact contact){
        return this.contacts.indexOf(contact);
    }
}
