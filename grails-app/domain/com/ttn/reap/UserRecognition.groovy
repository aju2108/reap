package com.ttn.reap

/*
Domain class for holding the transactions i.e, batch assigment by a awardedBy to receiver including the batch category
 */
class UserRecognition {

    User awardedBy
    User awardedTo
    Badge badge
    String message
    Date dateCreated
    Date lastUpdated

    static constraints = {
        message(blank: false, size: 4..512)
        awardedBy validator: {val, obj ->
            if(obj.awardedTo == val)
                ['userrecognition.awardedBy.duplicate']
        }
    }
}
