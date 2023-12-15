<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 16/07/2023
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Word</title>
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

    <link href="https://fonts.googleapis.com/css2?family=Tektur:wght@400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <link href="<c:url value="/static/css/login.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<section >
  <div class="container py-5">
    <div class="row">
      <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
          <ol class="breadcrumb mb-0">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Create World</li>
          </ol>
        </nav>
      </div>
    </div>
    <form action="/world?action=createWorld" method="post">
      <div class="row">
        <div class="col-lg-4">
          <div class="card mb-4">
            <div class="card-body text-center">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                   class="rounded-circle img-fluid" style="width: 150px;">
              <h5 class="my-3">World's Name</h5>
              <!--                        <p class="text-muted mb-1">Full Stack Developer</p>-->
              <!--                        <p class="text-muted mb-4">Bay Area, San Francisco, CA</p>-->
              <!--                        <div class="d-flex justify-content-center mb-2">-->
              <!--            <button type="button" class="btn btn-primary">Update</button>-->
              <div class="d-flex justify-content-center">
                <div class="btn btn-primary" style="font-size: 15px">
                  <label class="form-label text-white m-1" for="customFile2">Update Image</label>
                  <input type="file" class="form-control d-none" id="customFile2" />
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-8">
          <div class="card">
            <div class="card-body">
              <div class="form-outline mb-4">
                <input type="text" id="form5Example" class="form-control" name="worldName"/>
                <label class="form-label" for="form5Example1">Name</label>
              </div>
              <div class="form-outline mb-4">
                <input type="text" id="form5Example1" class="form-control" name="worldFantasy"/>
                <label class="form-label" for="form5Example1">Fantasy</label>
              </div>
              <!-- Submit button -->
              <div class="text-center">
                <button type="submit" class="btn btn-info">Confirm</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</section>

<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
></script>
</body>
</html>
