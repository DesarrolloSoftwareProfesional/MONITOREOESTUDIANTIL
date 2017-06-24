<?php
if (!empty($_GET['page'])) {
    header('Content-Type: application/JSON; charset=utf-8');
    header("Access-Control-Allow-Origin: *");

    $page = $_GET['page'];

    switch ($page) {

        case 'perfil':
            require_once '../src/service/PerfilService.php';
            $perfil = new PerfilService();
            $perfil->restApi();
            break;

        case 'alumno':
            require_once '../src/service/AlumnoService.php';
            $alumno = new AlumnoService();
            $alumno->restApi();
            break;

        case 'nota':
            require_once '../src/service/NotaService.php';
            $nota = new NotaService();
            $nota->restApi();
            break;

        case 'apoderado':
            require_once '../src/service/ApoderadoService.php';
            $apoderado = new ApoderadoService();
            $apoderado->restApi();
            break;

        case 'curso':
            require_once '../src/service/CursoService.php';
            $curso = new CursoService();
            $curso->restApi();
            break;

        case 'actividad':
            require_once '../src/service/ActividadService.php';
            $actividad = new ActividadService();
            $actividad->restApi();
            break;
        case 'grupo':
            require_once '../src/service/GrupoAcademicoService.php';
            $grupo = new GrupoAcademicoService();
            $grupo->restApi();
            break;

        case 'empleado':
            require_once '../src/service/EmpleadoService.php';
            $grupo = new EmpleadoService();
            $grupo->restApi();
            break;

        default:
            echo "Pagina no encontrada";
            break;
    }
} else {
    echo "Ingrese nombre de Pagina";
}
