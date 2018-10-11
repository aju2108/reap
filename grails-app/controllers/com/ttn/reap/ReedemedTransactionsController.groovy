package com.ttn.reap

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReedemedTransactionsController {

    ReedemedTransactionsService reedemedTransactionsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reedemedTransactionsService.list(params), model:[reedemedTransactionsCount: reedemedTransactionsService.count()]
    }

    def show(Long id) {
        respond reedemedTransactionsService.get(id)
    }

    def create() {
        respond new ReedemedTransactions(params)
    }

    def save(ReedemedTransactions reedemedTransactions) {
        if (reedemedTransactions == null) {
            notFound()
            return
        }

        try {
            reedemedTransactionsService.save(reedemedTransactions)
        } catch (ValidationException e) {
            respond reedemedTransactions.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reedemedTransactions.label', default: 'ReedemedTransactions'), reedemedTransactions.id])
                redirect reedemedTransactions
            }
            '*' { respond reedemedTransactions, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reedemedTransactionsService.get(id)
    }

    def update(ReedemedTransactions reedemedTransactions) {
        if (reedemedTransactions == null) {
            notFound()
            return
        }

        try {
            reedemedTransactionsService.save(reedemedTransactions)
        } catch (ValidationException e) {
            respond reedemedTransactions.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reedemedTransactions.label', default: 'ReedemedTransactions'), reedemedTransactions.id])
                redirect reedemedTransactions
            }
            '*'{ respond reedemedTransactions, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reedemedTransactionsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reedemedTransactions.label', default: 'ReedemedTransactions'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reedemedTransactions.label', default: 'ReedemedTransactions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
