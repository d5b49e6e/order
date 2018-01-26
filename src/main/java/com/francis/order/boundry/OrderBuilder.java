/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francis.order.boundry;

/**
 *
 * @author Francis Marti
 */
public class OrderBuilder {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String ticketType;
    private String card;
    private String expiration;

    public OrderBuilder() {
    }

    public OrderBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBuilder setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public OrderBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public OrderBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public OrderBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OrderBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public OrderBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public OrderBuilder setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public OrderBuilder setTicketType(String ticketType) {
        this.ticketType = ticketType;
        return this;
    }

    public OrderBuilder setCard(String card) {
        this.card = card;
        return this;
    }

    public OrderBuilder setExpiration(String expiration) {
        this.expiration = expiration;
        return this;
    }

    public Order createOrder() {
        return new Order(id, firstname, lastname, email, address, city, state, zip, ticketType, card, expiration);
    }
    
}
