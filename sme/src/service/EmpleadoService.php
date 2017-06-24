<?php

require_once "../src/lib/autoload.php";

class EmpleadoService
{
    const TABLE = "Empleado";
    protected $dao;

    public function __construct()
    {
        $this->dao = new EmpleadoDao();
    }

    public function getEmpleados()
    {
        UtilService::jsonEncode($this->dao->getEmpleados());
    }

    //metodo que decide que accion realizara

    public function restApi()
    {
        if (!empty($_GET[UtilConst::ACCION])) {
            $action = $_GET[UtilConst::ACCION];

            switch ($action) {
                case "listar":
                    $this->getEmpleados();
                    break;
                default:
                    UtilService::errorResponse("Metodo no existe");
                    break;
            }
        } else {
            UtilService::errorResponse("No indico ningun metodo");
        }

    }
}
