package com.ttn.reap

/*
Domain class for holding the badges status received by user from other users badges(Gold, Silver, Bronze) status
 */
class UserBadgeAwarded {

    User user
    Badge badge
    int availableCount
    Date dateCreated
    Date lastUpdated

    static mapping = {
        table: ""
    }

    static constraints = {
        availableCount(min: 0)
    }
}
