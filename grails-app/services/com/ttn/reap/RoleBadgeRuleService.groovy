package com.ttn.reap

import grails.gorm.services.Service

@Service(RoleBadgeRule)
interface RoleBadgeRuleService {

    RoleBadgeRule get(Serializable id)

    List<RoleBadgeRule> list(Map args)

    Long count()

    void delete(Serializable id)

    RoleBadgeRule save(RoleBadgeRule roleBadgeRule)

}