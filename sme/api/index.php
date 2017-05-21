<?php
if (!empty($_GET['page'])) {
    header('Content-Type: application/JSON; charset=utf-8');

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

            case'nota':
                require_once('../src/service/NotaService.php');
                $nota = new NotaService();
                $nota->restApi();
            break;

            case'apoderado':
                require_once('../src/service/ApoderadoService.php');
                $apoderado = new ApoderadoService();
                $apoderado->restApi();
            break;
           

            default:
                echo "Pagina no encontrada";
            break;
        }
} else {
    echo "Ingrese nombre de Pagina";
}
