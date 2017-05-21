<?php

/**
 *
 */
 require_once("../src/lib/autoload.php");
 class ActividadDao
 {
     protected $mysqli;

     public function __construct()
     {
         $this->mysqli = new Connection();
     }

     public function getAll()
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_ALL()";
         return $this->mysqli->findAll($sql);
     }

     public function getAllPending()
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_ALL_PENDING()";
         return $this->mysqli->findAll($sql);
     }

     public function getByID($id)
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_BY_ID(?)";
         return $this->mysqli->find($sql, $id);
     }

     public function insert($idEmpleado, $idCurso, $codGrupoAcademico, $nomActividad, $descrActividad,
                            $fechaRealizacion, $horaInicio, $horaFin, $frecuenciaAviso)
     {
         $sql="CALL SP_ACTIVIDADES_INSERT(?,?,?,?,?,?,?,?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('iissssssi', $idEmpleado, $idCurso, $codGrupoAcademico, $nomActividad, $descrActividad,
                                    $fechaRealizacion, $horaInicio, $horaFin, $frecuenciaAviso);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function update()
     {
         $sql="CALL (?,?,?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('sss', '');
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function delete($id)
     {
         $sql="DELETE FROM ACTIVIDADES WHERE idActividad =?";
         return $this->mysqli->delete($sql, $id);
     }
 }
