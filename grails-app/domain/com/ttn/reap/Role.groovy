package com.ttn.reap

import com.fasterxml.jackson.databind.JsonNode
import grails.converters.JSON
import groovy.transform.ToString

/*
Domain class for holding different roles (User, Supervisor, PracticeHead, Admin)
 */
@ToString(includeFields = true, includeNames = true, includes = 'roleName')
class Role {

    String roleName
    String roleBadge
    String description
    Integer precedence
    Date dateCreated
    Date lastUpdated

    static constraints = {
        description(nullable: true, size: 4..256)
        precedence(unique: true)
    }

}
