<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/07/2023
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <title>Home</title>

    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
            rel="stylesheet"
    />

    <link href="https://fonts.googleapis.com/css2?family=Tektur:wght@400;500;600;700;800;900&display=swap" rel="stylesheet">

<%--    <link href="<c:url value="/static/css/home.css"/>" rel="stylesheet" type="text/css">--%>
    <link href="<c:url value="/static/css/home.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand col-4" href="#">
            <img
                    style="height: 50px"
                    src="/static/image/MutiWorld_ngang.png"
                    class="me-2"
                    height="20"
                    alt="MDB Logo"
                    loading="lazy"
            />
        </a>

        <form class="d-flex input-group w-25 col-4 mt-3">
            <input
                    type="search"
                    class="form-control rounded-7"
                    placeholder="Search"
                    aria-label="Search"
                    aria-describedby="search-addon"
            />
            <span class="input-group-text border-0" id="search-addon">
        <i class="fas fa-search"></i>
      </span>
        </form>

        <div class="dropdown col-4 d-flex" >
            <a
                    class="dropdown-toggle d-flex align-items-center hidden-arrow ms-auto"
                    href="#"
                    id="navbarDropdownMenuAvatar"
                    role="button"
                    data-mdb-toggle="dropdown"
                    aria-expanded="false"
            >
                <img
                        src="/static/userAvatar/${sessionScope.currentUser.getAvatar()}"
                        class="rounded-circle"
                        height="35"
                        alt="Black and White Portrait of a Man"
                        loading="lazy"
                />
            </a>
            <ul
                    class="dropdown-menu dropdown-menu-end"
                    aria-labelledby="navbarDropdownMenuAvatar"
            >
                <li>
                    <a class="dropdown-item" href="/profile?action=showProfile">My profile</a>
                </li>
                <li>
                    <a class="dropdown-item" href="/login?action=logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Right elements -->
    </div>
    </div>
</nav>



<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Toggle button -->
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarCenteredExample"
                aria-controls="navbarCenteredExample"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <!-- Collapsible wrapper -->
        <div
                class="collapse navbar-collapse justify-content-center"
                id="navbarCenteredExample"
        >
            <!-- Left links -->
            <ul class="navbar-nav mb-2 mb-lg-0 mx-5">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>


                <!-- Navbar dropdown -->
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        World
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown" >
                        <li>
                            <a class="dropdown-item" href="/world?action=showCreateWorldForm">Create World</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Show World</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Update World</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Exterminate World</a>
                        </li>
                        <li><hr class="dropdown-divider" /></li>
                        <li>
                            <a class="dropdown-item" href="#">Show all World</a>
                        </li>
                    </ul>
                </li>


                <!-- Navbar dropdown -->
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown1"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        Character
                    </a>
                    <!-- Dropdown menu -->
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown" >
                        <li>
                            <a class="dropdown-item" href="#">Create Chacracter</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Show Chacracter</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Update Chacracter</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">Exterminate Chacracter</a>
                        </li>
                        <li><hr class="dropdown-divider" /></li>
                        <li>
                            <a class="dropdown-item" href="#">Show all Chacracter</a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Wibu</a>
                </li>
            </ul>
            <!-- Left links -->
        </div>
        <!-- Collapsible wrapper -->
    </div>
    <!-- Container wrapper -->
</nav>


<c:forEach items="${sessionScope.worldList}" var="world">
<div class="d-flex justify-content-center">
    <div class="card col-4 mt-5">
        <div class="card-body">
            <h5 class="card-title">${world.name}</h5>
            <p class="card-text">
<%--                <jsp:getProperty name="worldBean" property="fantasy"/>--%>
                ${world.fantasy}
            </p>

            <button type="button" class="btn btn-info">Explore</button>
        </div>
        <div class="card-footer">Author: ${world.author}</div>
        <div class="card-footer">Date create: ${world.dateForShow}</div>
    </div>
</div>
</c:forEach>







<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
></script>
</body>
</html>
