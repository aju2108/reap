package com.ttn.reap

class LoginController {

    def loginService

    def index() {
        render view: 'login.gsp'
    }

    def login = {
        if (request.method == 'POST') {
            def password = params.password
            def username = params.username

            def user = loginService.login(username, password)
            if(!user){
                flash.message = "User ${username} not found"
                return [user:userCount]
            }else{
                chain(controller:'dashboard',action:'dashboard',model:[user:user])
                //redirect(controller:'dashboard',action: 'dashboard', params: [someValue: user])
            }
        }

    }
}
