package com.ttn.reap

/*
Domain class for holding the user reedemed transactions
 */
class ReedemedTransactions {

    User redeemedBy
    Product product
    Date dateCreated
    Date lastUpdated
    RedemptionStatus status = RedemptionStatus.PENDING

    static constraints = {
    }
}


enum RedemptionStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}