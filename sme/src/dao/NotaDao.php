<?php

/**
 *
 */
require_once "../src/lib/autoload.php";
class NotaDao
{
    protected $mysqli;

    public function __construct()
    {
        $this->mysqli = new Connection();
    }

    public function getAll()
    {
        $sql = "";
        return $this->mysqli->findAll($sql);
    }

    public function getAllAlumnos()
    {
        $sql = "CALL SP_ALUMNOS_SELECT_NOTAS()";
        return $this->mysqli->findAll($sql);
    }

    public function getTipoNotas()
    {
        $sql = "CALL SP_TIPONOTAS_SELECT_ALL()";
        return $this->mysqli->findAll($sql);
    }

    public function getAlumnoPorDni($dni)
    {
        $sql="CALL SP_ALUMNOS_SELECT_BY_DNI(?)";
        $conn=$this->mysqli->open();
        $stmt=$conn->prepare($sql);
        $stmt->bind_param("i", $dni);
        $result=$this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }

    

    public function getNotasPorCursoPeriodo($idAlumno,$idCurso,$idPeriodo)
    {
        $sql="CALL SP_NOTAS_SELECT_ALUMNO_CURSO_PERIODO(?,?,?)";
        $conn=$this->mysqli->open();
        $stmt=$conn->prepare($sql);
        $stmt->bind_param("iii", $idAlumno,$idCurso,$idPeriodo);
        $result=$this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }

    public function getCursos()
    {
        $sql = "CALL SP_CURSOS_SELECT_ALL_FOR_NOTAS()";
        return $this->mysqli->findAll($sql);
    }

    public function getPeriodos()
    {
        $sql = "CALL SP_PERIODOS_SELECT_ALL()";
        return $this->mysqli->findAll($sql);
    }

    public function getByID($id)
    {
        $sql = "";
        return $this->mysqli->find($sql, $id);
    }

    public function getAllByID($id)
    {
        $sql  = "CALL SP_NOTAS_SELECT_ALL_BY_ID(?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $result = $this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }

    public function getAllPromedioByTrimestreAlumno($idAlumno, $trimestre)
    {
        $sql  = "CALL SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID(?,?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param('ii', $idAlumno, $trimestre);
        $result = $this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }

    public function getAllPromedioByID($id)
    {
        $sql  = "CALL SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID(?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("i", $id);
        $result = $this->mysqli->search($stmt);
        $conn->close();

        return $result;
    }

    public function insert( $idAlumno,
                            $idCurso, 
                            $idPeriodo, 
                            $idEmpleado, 
                            $idTipoNota, 
                            $nota)
    {
        $sql  = "CALL SP_NOTAS_INSERT(?,?,?,?,?,?)";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param('iiiiii', $idAlumno,
                                    $idCurso, 
                                    $idPeriodo, 
                                    $idEmpleado, 
                                    $idTipoNota, 
                                    $nota);
        $result = $this->mysqli->executeIUD($stmt);
        $conn->close();

        return $result;
    }

    public function update($nomPerfil, $idPerfil)
    {
        $sql  = "";
        $conn = $this->mysqli->open();
        $stmt = $conn->prepare($sql);
        $stmt->bind_param('', $nomPerfil, $idPerfil);
        $result = $this->mysqli->executeIUD($stmt);
        $conn->close();

        return $result;
    }

    public function delete($id)
    {
        $sql = "";
        return $this->mysqli->delete($sql, $id);
    }
}
