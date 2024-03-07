<?php

const FILE='db_settings.ini';

/**
 * Summary of getConnection
 * Crea un objeto PDO
 * @return PDO|null un objeto PDO si ha habido éxito creando la conexión, null en caso contrario
 */

function getConnection()
{   
   
    
        if (!$settings = parse_ini_file(FILE, true))
        throw new Exception("ERROR: Unable to open" . FILE .'.');

    $con = null;
    $driver = $settings["database"]["driver"];
    $host = $settings["database"]["host"];
    $db = $settings["database"]["schema"];
    $user = $settings["database"]["username"];
    $pass = $settings["database"]["password"];
    $dsn = $driver . ":host=$host;dbname=$db";
    $persistent = $settings["database"]["persistent"];

    try {

        $con = new PDO($dsn, $user, $pass,  array(
            PDO::ATTR_PERSISTENT => $persistent
        ));

    
    } catch (PDOException $ex) {

        echo "Error en la conexión: mensaje: " . $ex->getMessage();
    }
    return $con;
}

//punto b
/**
     * Summary of findRoles
     * Conexion  y consulta a la base de datos para mostrar los diferentes roles que existen en ella
     * @return array
     */
function findRoles(): array
    {
        $conProyecto = getConnection();
        $pdostmt = $conProyecto->prepare("SELECT * FROM rol");
        $pdostmt->execute();
        $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);
        return $array;

    }


    //punto d
/**
 * Summary  of findUser
 * Conex. y consulta a la Base de datos con PDO para mostrar el usuario al que corresponde el email, si no existe devuelve false.
 * @param string $email
 * @return array|bool
 */
function findUser(string $email): array|bool
{
    $conProyecto = getConnection();
    $pdostmt = $conProyecto->prepare("SELECT * FROM usuario WHERE email= ?");
    // Pasamos el email como un array asociativo puesto que tenia problemas a la hora de pasarle  un string y esperar un array o un boolean de vuelta
    //ojo: este codigo seguro que es mejorable
    $pdostmt->execute([$email]);
    $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);
    return $array ? $array : false;
}

// punto e
/**
 * Summary of createUser
 * Conexion  a la BD para la creacion del usuario
 * @param array $data
 * @throws \Exception
 * @return bool
 */
function createUser(array $data): bool
{
    try {
        $conProyecto = getConnection();
        $conProyecto->beginTransaction();

        //Insercion en usuario
        $pdostmt_user = $conProyecto->prepare("INSERT INTO usuario (email,pwdhash) VALUES (:email,:pwd)");
        //Parametros
        $pdostmt_user->bindParam("email", $data["email"]);
        $pdostmt_user->bindParam("pwd", $data["pwd"]);

        //Creamos el usuario y recuperamos el id
        if ($pdostmt_user->execute()) $user_id = $conProyecto->lastInsertId();
        else throw new Exception();

        //Creamos la referencia en la tabla usuario_rol
        $pdostmt_user_rol = $conProyecto->prepare("INSERT INTO usuario_rol (idUsuario,idRol) VALUES (:user_id,:rol_id)");
        $pdostmt_user_rol->bindParam("user_id", $user_id);
        $pdostmt_user_rol->bindParam("rol_id", $data["rol_id"]);
        if (!$pdostmt_user_rol->execute()) throw new Exception();

        //Finaliza la transaccion
        $conProyecto->commit();
    } catch (Exception $e) {
        $conProyecto->rollBack();
        echo "Ocurrio un error al intentar crear el usuario, mensaje: " . $e->getMessage();
        return false;
    }

    return true;
}

//punto j
/**
 * Summary of findRolesById
 *  Conex. y consulta a la Base de datos con PDO para mostrar el usuario al que corresponde el rol.
 * @param int $user_id
 * @return array
 */
function findRolesById(int $user_id): array
{
    $conProyecto = getConnection();
    $pdostmt = $conProyecto->prepare("SELECT idRol, name from usuario_rol join rol 
    ON usuario_rol.idRol = rol.id 
    WHERE usuario_rol.idUsuario = ?");
    $pdostmt->execute([$user_id]);
    $array = $pdostmt->fetchAll(PDO::FETCH_ASSOC);
    return $array;
}

?>
