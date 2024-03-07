<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Login</title>
</head>

<?php
require_once "funciones.php";
require_once "registro_sesion";

// Leer los datos del formulario y comprobar que esten bien
$exito = false;
if (isset(
    $_POST['email'],
    $_POST['pwd1'],
)) {
    $email = $_POST['email'];
    $pwd = $_POST['pwd1'];
    
    // Comprobar que el usuario no exista ya
    $user = findUser($email);
    if ($user && password_verify($pwd,$user['pwdhash'])){
        $exito = true;
        $roles_usuario = findRolesById($user['id']);
    } 
        
}

?>

<body>
    <div class="container border border-3 rounded-4 mt-5 bg-light p-4 mb-3" id="form-container">
        <h1 class="h1">Inicio de sesión</h1>
        <form class="form-floating p-3" method="post">
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email"  name= "email" aria-describedby="emailHelp" 
                placeholder="tudireccion@email.com" required>
                <label for="email" class="form-label">Email</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="pwd1" name="pwd1" required>
                <label for="pwd1" class="form-label">Contraseña</label>
            </div>
            <button type="submit" class="btn btn-primary">Iniciar sesión</button>
            <a href="registro_sesion.php" class="btn btn-link">Regístrese aquí</a>
        </form>
    </div>
    <div id="mensajes"class="container mb-3"> 
        <?php
        if (isset($_POST["email"])) {
            if ($exito) {
                echo "<div class='alert alert-success' role='alert'>Enhorabuena, se ha autenticado con exito</div>";
            } else {
                echo "<div class='alert alert-danger' role='alert'>Datos de acceso no validos</div>";
            }
        }
        ?>
    </div>
    <div id="datos-usuario" class="container mb-3">
        <?php
        if (isset($_POST["email"]) && $exito) {
            echo "<pre>";
            print_r($roles_usuario);
            echo "</pre>";
        }
        ?>
    </div>
</body>

</html>