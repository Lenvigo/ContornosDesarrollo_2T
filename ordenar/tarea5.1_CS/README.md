# tarea5.1_CS
Tarea 5.1 de la asignatura de Contornos Servidor del ciclo de DAW _ Autenticación de usuarios

a) Crearemos un formulario html de registro como el de la imagen. Podéis ayudaros de los estilos que proporciona Bootstrap: https://getbootstrap.com/docs/5.0/forms/overview/

b) Obtendremos los roles de la BD notas y los mostraremos en una lista desplegable. Para ello usaremos PDO para conectarnos a la BD, tal y como hemos hecho en la unidad anterior.

c) Comprobaremos en el lado servidor que las contraseñas coinciden. También sería deseable que se comprobara en el lado cliente, pero esto no es objeto de este módulo.

d) Comprobaremos que el email no esté ya registrado.

e) Una vez hechas las comprobaciones, insertaremos el nuevo usuario en la tabla correspondiente. Guardaremos el hash de la contraseña con la función password_hash, el algoritmo PASSWORD_BCRYPT y las opciones por defecto. Además deberá guardarse la relación usuario-rol en la tabla correspondiente. Ambas inserciones deberán realizarse en la misma transacción.

f) Añade mensajes de éxito o fracaso de cada comprobación/acción con las alertas de Bootstrap: https://getbootstrap.com/docs/5.0/components/alerts/

g) A continuación, crearemos el formulario de inicio de sesión.

h) Comprobaremos si el email proporcionado y la contraseña proporcionada coinciden con las almacenadas en la BD utilizando la función password_verify

i) Mostraremos mensajes de éxito o fracaso de cada comprobación/acción con las alertas de Bootstrap: https://getbootstrap.com/docs/5.0/components/alerts/

j) Si la autenticación de usuario fue exitosa, obtén la lista de roles del usuario autenticado. La lista deberá contener su id y su nombre. Muéstrala en la página HTML.

