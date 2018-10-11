package com.ttn.reap

import groovy.transform.ToString

/*
Domain class for holding the redemption products catalogue items
 */
@ToString(includes =  'productName,stockCount' ,includeFields = true, includeNames = true)
class Product {

    String productName
    String description
    int valuePoints
    int stockCount
    Date dateCreated
    Date lastUpdated

    static constraints = {
        productName(blank: false, size: 4..128)
        description(blank: true, nullable: true, size: 4..256)
        valuePoints(min: 1)
        stockCount(min: 0)
    }

    Boolean fetchProductAvailability(){
        stockCount as Boolean
    }
}
