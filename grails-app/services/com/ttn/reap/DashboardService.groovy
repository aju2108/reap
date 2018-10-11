package com.ttn.reap

import grails.gorm.transactions.Transactional

@Transactional
class DashboardService {

    def userBadge(user){
        return  UserBadgeAwarded.findAllByUser(user)
    }
}
