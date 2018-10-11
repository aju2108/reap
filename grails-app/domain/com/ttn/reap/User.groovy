package com.ttn.reap

import groovy.transform.ToString

/*
Domain Class for holding the users, users can have multiple roles (User(Default), Supervisor, PracticeHead, Admin)
 */
@ToString(includeNames = true, includeFields = true, includes = 'userName,firstName,lastName,points')
class User {

    String userName
    String firstName
    String lastName
    String password
    String confirmPassword
    String email
    int points = 0
    Date dateCreated
    Date lastUpdated

    static hasMany = [userRoles:UserRole]
    static transients = ['confirmPassword']

    static constraints = {
        userName(blank: false, size: 4..64, matches: "[a-zA-Z0-9_]+", unique: true)
        firstName(blank: false, size: 2..32, matches: "[a-zA-Z]+")
        lastName(blank: false, size: 2..32, matches: "[a-zA-Z]+")
        password(blank: false, size: 4..32, matches: "[a-zA-Z0-9]+")
        confirmPassword(blank: false, display:true, size: 4..32, matches: "[a-zA-Z0-9]+", password: true)
        password validator: {val, obj ->
            if(val != obj.confirmPassword)
                ['user.confirmPassword.match']

        }
    }

}
