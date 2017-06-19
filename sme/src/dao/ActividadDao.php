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

     public function getLastInserted()
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_LAST_INSERTED()";
         return $this->mysqli->findAll($sql);
     }

     public function getNotificationByID($id)
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_NOTIFICATION_BY_ID(?)";
         return $this->mysqli->find($sql, $id);
     }

     public function getByID($id)
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_BY_ID(?)";
         return $this->mysqli->find($sql, $id);
     }

     public function getAllByIDGpoAcademico($id)
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_BY_GPOACADEMICO(?)";
         return $this->mysqli->findByIdString($sql, $id);
     }

     public function getAllByIDApoderado($id)
     {
         $sql="CALL SP_ACTIVIDADES_SELECT_BY_ID_APODERADO(?)";
         return $this->mysqli->find($sql, $id);
     }

     public function getByIDActividadIDAlumno($idActividad, $idAlumno)
     {
         $sql  = "CALL SP_ACTIVIDADES_SELECT_BY_IDACTIVIDAD_IDALUMNO(?,?)";
         $conn = $this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('ii', $idActividad, $idAlumno);
         $result = $this->mysqli->search($stmt);
         $conn->close();

         return $result;
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

     public function update($idEmpleado, $idCurso, $codGrupoAcademico, $nomActividad, $descrActividad,
                            $fechaRealizacion, $horaInicio, $horaFin, $frecuenciaAviso, $idActividad)
     {
         $sql="CALL SP_ACTIVIDADES_UPDATE(?,?,?,?,?,?,?,?,?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('iissssssii', $idEmpleado, $idCurso, $codGrupoAcademico, $nomActividad, $descrActividad,
                                $fechaRealizacion, $horaInicio, $horaFin, $frecuenciaAviso, $idActividad);
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
