Para que la BBDD del examen no diera problemas le he añadido un usuario y una contraseña.
Usa el script "proyectos_empleados_2024" que adjunto aquí o añade lo siguiente al final del script de Tomás:

create user admin_unir identified by 'admin';
grant all privileges on proyectos_empleados_2024.* to admin_unir;

Usa el script "insert_bbdd" para darle contenido a la BBDD.

 
