package com.ttn.reap

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RoleBadgeRuleController {

    RoleBadgeRuleService roleBadgeRuleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond roleBadgeRuleService.list(params), model:[roleBadgeRuleCount: roleBadgeRuleService.count()]
    }

    def show(Long id) {
        respond roleBadgeRuleService.get(id)
    }

    def create() {
        respond new RoleBadgeRule(params)
    }

    def save(RoleBadgeRule roleBadgeRule) {
        if (roleBadgeRule == null) {
            notFound()
            return
        }

        try {
            roleBadgeRuleService.save(roleBadgeRule)
        } catch (ValidationException e) {
            respond roleBadgeRule.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roleBadgeRule.label', default: 'RoleBadgeRule'), roleBadgeRule.id])
                redirect roleBadgeRule
            }
            '*' { respond roleBadgeRule, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond roleBadgeRuleService.get(id)
    }

    def update(RoleBadgeRule roleBadgeRule) {
        if (roleBadgeRule == null) {
            notFound()
            return
        }

        try {
            roleBadgeRuleService.save(roleBadgeRule)
        } catch (ValidationException e) {
            respond roleBadgeRule.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'roleBadgeRule.label', default: 'RoleBadgeRule'), roleBadgeRule.id])
                redirect roleBadgeRule
            }
            '*'{ respond roleBadgeRule, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        roleBadgeRuleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'roleBadgeRule.label', default: 'RoleBadgeRule'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleBadgeRule.label', default: 'RoleBadgeRule'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
