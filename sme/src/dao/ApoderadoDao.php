
<?php
require_once("../src/lib/autoload.php");

class ApoderadoDao
{
    protected $mysqli;



    public function __construct()
    {
        $this->mysqli = new Connection();
    }

    //FUNCION PARA OBTENER TODOS LOS REGISTROS
    public function getAll()
    {
        $sql="CALL SP_APODERADOS_SELECT_ALL()";
        return $this->mysqli->findAll($sql);
    }

    //FUNCION PARA OBTENER APODERADO CON ID
    public function getByID($id)
    {
        $sql="CALL SP_APODERADOS_SELECT_BY_ID(?)";
        return $this->mysqli->find($sql, $id);
    }

    //FUNCION PARA OBTENER ALUMNOS POR ID APODERADO
    public function getAllAlumnoByIDApoderado($id)
    {
        $sql="CALL SP_APODERADOS_SELECT_ALUMNOS_BY_IDAPODERADO(?)";
        return $this->mysqli->find($sql, $id);
    }

    public function insertAlumnoApoderado($idAlumno, $idApoderado)
    {
        $sql="CALL SP_ALUMNOS_GRUPOACADEMICO_INSERT(?,?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt -> bind_param('ii', $idAlumno, $idApoderado);
        $result=$this->mysqli->executeIUD($stmt);
        $conn -> close();

        return $result;
    }

    //FUNCION PARA AGREGAR UN NUEVO APODERADO
    public function insert($apPaternoApoderado, $apMaternoApoderado, $nombresApoderado, $dniApoderado, $fechaNacApoderado, $direccionApoderado)
    {
        $sql="CALL SP_APODERADOS_INSERT(?,?,?,?,?,?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt -> bind_param('ssssss', $apPaternoApoderado, $apMaternoApoderado, $nombresApoderado, $dniApoderado, $fechaNacApoderado, $direccionApoderado);
        $result=$this->mysqli->executeIUD($stmt);
        $conn -> close();

        return $result;
    }


    //FUNCION PARA EDITAR APODERADO

    public function update($apPaternoApoderado, $apMaternoApoderado, $nombresApoderado, $dniApoderado, $fechaNacApoderado, $direccionApoderado, $idApoderado)
    {
        $sql = "CALL SP_APODERADOS_UPDATE(?,?,?,?,?,?,?)";
        $conn = $this -> $mysqli -> open();
        $stmt = $conn->prepare($sql);
        $stmt -> bind_param('ssssssi', $apPaternoApoderado, $apMaternoApoderado, $nombresApoderado, $dniApoderado, $fechaNacApoderado, $direccionApoderado, $idApoderado);
        $result = $this -> $mysqli -> executeIUD("$stmt");
        $conn -> close();

        return $result;
    }


    //FUNCION PARA ELIMINAR APODERADO

    public function delete($id)
    {
        $sql = "DELETE FROM Apoderados WHERE idApoderado = ?";
        return $this->$mysqli->delete($sql, $id);
    }

    //FUNCION PARA LOGEARSE CON USUARIO APODERADO

    public function logeo($userApoderado, $passApoderado)
    {
        $sql = "CALL SP_APODERADOS_SELECT_LOGIN(?,?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param('ss', $userApoderado, $passApoderado);
        $result = $this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }
}

 ?>
