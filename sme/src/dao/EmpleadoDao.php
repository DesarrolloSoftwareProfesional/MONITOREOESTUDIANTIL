<?php

require_once "../src/lib/autoload.php";

class EmpleadoDao
{
    protected $mysqli;

    public function __construct()
    {
        $this->mysqli = new Connection();
    }

    public function getEmpleados()
    {
        $sql = "CALL SP_EMPLEADOS_SELECT_ALL()";
        return $this->mysqli->findAll($sql);
    }
}
