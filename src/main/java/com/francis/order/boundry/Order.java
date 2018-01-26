/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order.boundry;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Francis Marti
 */
//@Entity
public class Order {        
    private Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String zip;
    @NotNull
    private String ticketType;
    @NotNull
    private String card;
    @NotNull
    private String expiration;

    public Order() {
    }

    public Order(Long id, String firstname, String lastname, String email, String address, String city, String state, String zip, String ticketType, String card, String expiration) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ticketType = ticketType;
        this.card = card;
        this.expiration = expiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", ticketType=" + ticketType + ", card=" + card + ", expiration=" + expiration + '}';
    }
    
    
    
    
    
}
