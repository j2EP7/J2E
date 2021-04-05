<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Container -->
<div class="container-fluid h-100">
    <!-- Row -->
    <div class="row h-100">
        <!-- First Column -->
        <div class="col-12 col-md-8 align-self-center loginForm">
            <!-- H1 -->
            <h1>${param.title}</h1>
            <!-- Content -->
            <br>
            <h2>Inicia sesión para jugar</h2>
            <form action="login" method="post">
                <div class="mb-3">
                    <label for="inputUsername" class="form-label">Nombre de usuario</label>
                    <input required name="username" type="username" class="form-control" id="inputUsername" aria-describedby="usernameHelp">
                    <div id="usernameHelp" class="form-text">Utiliza tu usuario de LDAP.</div>
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">Contraseña</label>
                    <input required name="password" type="password" class="form-control" id="inputPassword">
                </div>
                <div class="d-grid gap-2">
                <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                </div>
            </form>
        </div>
        <!-- Second Column -->
        <div class="col-12 col-md-4 align-self-end indexWallpaper vh-100">
        </div>
        <!-- End Row -->
    </div>
    <!-- End Container -->
</div>

