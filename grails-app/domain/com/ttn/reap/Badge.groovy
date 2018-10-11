package com.ttn.reap

import grails.gorm.transactions.Transactional
import groovy.transform.ToString

/*
Domain class for holding the badges-Category:Weightage(Gold:30, Silver:20, Bronze:10)
 */
@ToString(includeNames = true, includeFields = true, includes = 'name, weightage')
class Badge {

    String name
    String description
    int weightage
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name(blank: false, size: 4..64)
        description(nullable: true, size: 4..256)
        weightage(min: 1)
    }

}
