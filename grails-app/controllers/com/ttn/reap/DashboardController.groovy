package com.ttn.reap

class DashboardController {

    def dashboardService

    def index() {
        render (view: 'editUsers.gsp')
    }


    def dashboard(Long userId) {
       // List<UserBadgeAwarded> userBadgeAwardedList = dashboardService.userBadge(chainModel?.user)
        //render (view: 'dashboard.gsp', collection: userBadgeAwardedList, model:[logeedInUser:chainModel?.user])
       // render (view: 'dashboard.gsp', model:[userBadgeAwardedList:userBadgeAwardedList, logeedInUser:chainModel?.user])
        render (view: 'editUsers.gsp')
    }
}
