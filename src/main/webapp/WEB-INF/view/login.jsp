<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/07/2023
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
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

        <link href="<c:url value="/static/css/login.css"/>" rel="stylesheet" type="text/css">

</head>
<body>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">
                <div class="card" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="/static/image/loginImage.jpg"
                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form action="/login?action=login" method="post">

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <img style="height: 80px" src="/static/image/MutiWorld_ngang.png">
<%--                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>--%>
<%--                                        <span class="h1 fw-bold mb-0">Logo</span>--%>
                                    </div>

                                    <h5 class="mb-3 pb-3" style="letter-spacing: 1px; font-size: x-large; font-weight: 500;">Sign into your account</h5>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="username" id="form2Example17" class="form-control form-control-lg" />
                                        <label class="form-label" for="form2Example17">Username</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="password" name="password" id="form2Example27" class="form-control form-control-lg" />
                                        <label class="form-label" for="form2Example27">Password</label>
                                    </div>
                                    <c:if test="${loginMessage != null}">
                                        <div style="color: red; font-size: medium" class="mb-4">${loginMessage}</div>
                                    </c:if>
                                    <div class="pt-1 mb-4">
                                        <button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
                                    </div>

                                    <a class="small" style="color: #4088d2; font-weight: 700" href="#!">Forgot password?</a>
                                    <p class="mb-5 text-muted pb-lg-2">Don't have an account?
                                        <a href="/register" style="color: #4088d2; font-weight: 700">Register here</a></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
></script>
</body>
</html>

