package com.ttn.reap

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserBadgeAwardedController {

    UserBadgeAwardedService userBadgeAwardedService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userBadgeAwardedService.list(params), model:[userBadgeAwardedCount: userBadgeAwardedService.count()]
    }

    def show(Long id) {
        respond userBadgeAwardedService.get(id)
    }

    def create() {
        respond new UserBadgeAwarded(params)
    }

    def save(UserBadgeAwarded userBadgeAwarded) {
        if (userBadgeAwarded == null) {
            notFound()
            return
        }

        try {
            userBadgeAwardedService.save(userBadgeAwarded)
        } catch (ValidationException e) {
            respond userBadgeAwarded.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userBadgeAwarded.label', default: 'UserBadgeAwarded'), userBadgeAwarded.id])
                redirect userBadgeAwarded
            }
            '*' { respond userBadgeAwarded, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userBadgeAwardedService.get(id)
    }

    def update(UserBadgeAwarded userBadgeAwarded) {
        if (userBadgeAwarded == null) {
            notFound()
            return
        }

        try {
            userBadgeAwardedService.save(userBadgeAwarded)
        } catch (ValidationException e) {
            respond userBadgeAwarded.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userBadgeAwarded.label', default: 'UserBadgeAwarded'), userBadgeAwarded.id])
                redirect userBadgeAwarded
            }
            '*'{ respond userBadgeAwarded, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userBadgeAwardedService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userBadgeAwarded.label', default: 'UserBadgeAwarded'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userBadgeAwarded.label', default: 'UserBadgeAwarded'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
