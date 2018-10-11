package com.ttn.reap

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RoleBadgeRuleServiceSpec extends Specification {

    RoleBadgeRuleService roleBadgeRuleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RoleBadgeRule(...).save(flush: true, failOnError: true)
        //new RoleBadgeRule(...).save(flush: true, failOnError: true)
        //RoleBadgeRule roleBadgeRule = new RoleBadgeRule(...).save(flush: true, failOnError: true)
        //new RoleBadgeRule(...).save(flush: true, failOnError: true)
        //new RoleBadgeRule(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //roleBadgeRule.id
    }

    void "test get"() {
        setupData()

        expect:
        roleBadgeRuleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RoleBadgeRule> roleBadgeRuleList = roleBadgeRuleService.list(max: 2, offset: 2)

        then:
        roleBadgeRuleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        roleBadgeRuleService.count() == 5
    }

    void "test delete"() {
        Long roleBadgeRuleId = setupData()

        expect:
        roleBadgeRuleService.count() == 5

        when:
        roleBadgeRuleService.delete(roleBadgeRuleId)
        sessionFactory.currentSession.flush()

        then:
        roleBadgeRuleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RoleBadgeRule roleBadgeRule = new RoleBadgeRule()
        roleBadgeRuleService.save(roleBadgeRule)

        then:
        roleBadgeRule.id != null
    }
}
