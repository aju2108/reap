<html>
<head>
    <title>REAP - Dashboard</title>
    <meta name="layout" content="main" />
</head>
<body>
    Welcome ${logeedInUser.firstName} ${logeedInUser.lastName}

    <g:each in="${userBadgeAwardedList}" var="userBadge">
        <tr>
            <td>${userBadge.badge.name} - ${userBadge.availableCount} </td>
        </tr>
    </g:each>
</body>
</html>