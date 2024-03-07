<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Tarea 5.1</title>
</head>

<body>
<?php
require_once 'funciones.php';

$roles = findRoles();
$exito = true;

if (isset($_POST['email'], $_POST["pwd1"], $_POST["pwd2"], $_POST['rol'])) {
    $email=$_POST['email'];
    $pwd1=$_POST["pwd1"];
    $pwd2=$_POST["pwd2"];
    $rol = $_POST['rol'];
} 
$user = findUser($email);
if (!$user && $pwd1==$pwd2){
     //añadir usuario, comprobar contraseñas coincidan
     $data = array(
        "email" => $email,
        "pwd" => password_hash($pwd1, PASSWORD_BCRYPT),
        "rol_id" => $rolId
    );
    $exito = createUser($data);
}

?>



    <form method="post" action ="">
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email"  name= "email" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="pwd1" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="pwd1" name="pwd1">
        </div>

        <div class="mb-3">
            <label for="pwd2" class="form-label">Repita contraseña</label>
            <input type="password" class="form-control" id="pwd2" name="pwd2">
        </div>

        <div>
            <label for="rol">Seleccione el rol</label>
            <select name="rol" id="rol" required>
                <option value=""></option>
              
                <?php
                  // desplegable de las opciones que estan la BD para la variable rol
                if (count ($roles)>0):
                    foreach ($roles as $rol):?>
                    <option value=" <?php $rol ["id"]?>"><?php echo $rol["name"]; ?></option>
                    <?php
                    endforeach;
                endif;
                ?>
            </select>
        </div>

        <button type="submit"  name= "submit" class="btn btn-primary">Registrar usuario</button>
    </form>

    
</body>

</html>