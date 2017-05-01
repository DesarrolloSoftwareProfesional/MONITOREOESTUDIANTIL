<?php
if (!empty($_GET['page'])) {
    $page=$_GET['page'];

    switch ($page) {

            case'perfil':
                require_once('../src/service/PerfilService.php');
                $perfil = new PerfilService();
                $perfil->restApi();
            break;

            case'alumno':
                require_once('../src/service/AlumnoService.php');
                $alumno = new AlumnoService();
                $alumno->restApi();
            break;

            default:
                echo "Pagina no encontrada";
            break;
        }
} else {
    echo "Ingrese nombre de Pagina";
}
