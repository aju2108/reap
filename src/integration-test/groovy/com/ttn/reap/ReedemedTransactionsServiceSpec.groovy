package com.ttn.reap

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReedemedTransactionsServiceSpec extends Specification {

    ReedemedTransactionsService reedemedTransactionsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ReedemedTransactions(...).save(flush: true, failOnError: true)
        //new ReedemedTransactions(...).save(flush: true, failOnError: true)
        //ReedemedTransactions reedemedTransactions = new ReedemedTransactions(...).save(flush: true, failOnError: true)
        //new ReedemedTransactions(...).save(flush: true, failOnError: true)
        //new ReedemedTransactions(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reedemedTransactions.id
    }

    void "test get"() {
        setupData()

        expect:
        reedemedTransactionsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ReedemedTransactions> reedemedTransactionsList = reedemedTransactionsService.list(max: 2, offset: 2)

        then:
        reedemedTransactionsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reedemedTransactionsService.count() == 5
    }

    void "test delete"() {
        Long reedemedTransactionsId = setupData()

        expect:
        reedemedTransactionsService.count() == 5

        when:
        reedemedTransactionsService.delete(reedemedTransactionsId)
        sessionFactory.currentSession.flush()

        then:
        reedemedTransactionsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ReedemedTransactions reedemedTransactions = new ReedemedTransactions()
        reedemedTransactionsService.save(reedemedTransactions)

        then:
        reedemedTransactions.id != null
    }
}
