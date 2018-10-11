package com.ttn.reap

import grails.gorm.transactions.Transactional

@Transactional
class LoginService {

    def login(userName, password) {
        User user = User.findByUserNameAndPassword(userName, password)
        return user
    }
}
