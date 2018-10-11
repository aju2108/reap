package com.ttn.reap

import grails.gorm.services.Service

@Service(UserBadgeAwarded)
interface UserBadgeAwardedService {

    UserBadgeAwarded get(Serializable id)

    List<UserBadgeAwarded> list(Map args)

    Long count()

    void delete(Serializable id)

    UserBadgeAwarded save(UserBadgeAwarded userBadgeAwarded)

}