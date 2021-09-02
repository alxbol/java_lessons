package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {
    private final Set<ContactData> delegate;

    public Contacts(Contacts Contacts) {
        this.delegate = new HashSet<>(Contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactData contact) {
        Contacts Contacts = new Contacts(this);
        Contacts.add(contact);
        return Contacts;
    }

    public Contacts without(ContactData contact) {
        Contacts Contacts = new Contacts(this);
        Contacts.remove(contact);
        return Contacts;
    }
}

