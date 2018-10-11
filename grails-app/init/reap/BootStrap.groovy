package reap

import com.ttn.reap.Badge
import com.ttn.reap.Product
import com.ttn.reap.Role
import com.ttn.reap.User
import com.ttn.reap.UserBadgeAwarded
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        // User Test Data
        if(Environment.isDevelopmentMode()) {
            def user = User.build(firstName: 'Ajay', lastName: 'Yadav', userName: 'ajay', password: 'ttn1234', confirmPassword: 'ttn1234')
            def user2 = User.build(userName: 'manish', password: 'ttn1234', confirmPassword: 'ttn1234')

            //Badge Test Data
            def gold = Badge.build(name: 'Gold', weightage: 30)
            def silver = Badge.build(name: 'Silver', weightage: 20)
            def bronze = Badge.build(name: 'Bronze', weightage: 10)

            // UserBadgeAwarded Test Data
            UserBadgeAwarded.build(user: user, badge: gold, availableCount: 3)
            UserBadgeAwarded.build(user: user, badge: silver, availableCount: 2)
            UserBadgeAwarded.build(user: user, badge: bronze, availableCount: 1)

            // Role Test Data
            (1..4).collect { Role.build(roleName: "Role${it}", precedence: it) }
            /*def userRole = Role.build(roleName: 'User', precedence: 4)
        def supervisorRole = Role.build(roleName: 'Supervisor', precedence: 3)
        def practiceHeadRole = Role.build(roleName: 'Practice Head', precedence: 2)
        def adminRole = Role.build(roleName: 'Admin', precedence: 1)*/

            // Products Test Data
            (1..5).collect { Product.build(productName: "product${it}", valuePoints: it + 5, stockCount: it) }

            //Badge Test Data
            //(1..3).collect{Badge.build(name: "badge${it}", weightage: it+1)}
        }
    }
    def destroy = {
    }
}
