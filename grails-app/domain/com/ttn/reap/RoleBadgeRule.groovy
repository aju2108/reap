package com.ttn.reap

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/*
Domain class for User Badge Assignment-Role::Gold:Silver:Bronze(User::3:2:1, Supervisor::6:3:2, PracticeHead::9:6:3)
 */
@EqualsAndHashCode
@ToString()
class RoleBadgeRule {

    Role role
    Badge badge
    Integer count

    static constraints = {
    }
}
