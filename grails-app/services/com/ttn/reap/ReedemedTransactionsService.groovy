package com.ttn.reap

import grails.gorm.services.Service

@Service(ReedemedTransactions)
interface ReedemedTransactionsService {

    ReedemedTransactions get(Serializable id)

    List<ReedemedTransactions> list(Map args)

    Long count()

    void delete(Serializable id)

    ReedemedTransactions save(ReedemedTransactions reedemedTransactions)

}