package com.ttn.reap

import grails.gorm.services.Service

@Service(UserRecognition)
interface UserRecognitionService {

    UserRecognition get(Serializable id)

    List<UserRecognition> list(Map args)

    Long count()

    void delete(Serializable id)

    UserRecognition save(UserRecognition userRecognition)

}