package com.ttn.reap

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserRecognitionController {

    UserRecognitionService userRecognitionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userRecognitionService.list(params), model:[userRecognitionCount: userRecognitionService.count()]
    }

    def show(Long id) {
        respond userRecognitionService.get(id)
    }

    def create() {
        respond new UserRecognition(params)
    }

    def save(UserRecognition userRecognition) {
        if (userRecognition == null) {
            notFound()
            return
        }

        try {
            userRecognitionService.save(userRecognition)
        } catch (ValidationException e) {
            respond userRecognition.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userRecognition.label', default: 'UserRecognition'), userRecognition.id])
                redirect userRecognition
            }
            '*' { respond userRecognition, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userRecognitionService.get(id)
    }

    def update(UserRecognition userRecognition) {
        if (userRecognition == null) {
            notFound()
            return
        }

        try {
            userRecognitionService.save(userRecognition)
        } catch (ValidationException e) {
            respond userRecognition.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userRecognition.label', default: 'UserRecognition'), userRecognition.id])
                redirect userRecognition
            }
            '*'{ respond userRecognition, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userRecognitionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userRecognition.label', default: 'UserRecognition'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userRecognition.label', default: 'UserRecognition'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
