<?php

/**
 *
 */
 require_once("../src/lib/autoload.php");
 class AlumnoDao
 {
     protected $mysqli;

     public function __construct()
     {
         $this->mysqli = new Connection();
     }

     public function getAll()
     {
         $sql="CALL SP_ALUMNOS_SELECT_ALL()";
         return $this->mysqli->findAll($sql);
     }

     public function getByID($id)
     {
         $sql="CALL SP_ALUMNOS_SELECT_BY_ID(?)";
         return $this->mysqli->find($sql, $id);
     }

     public function insert($apPaternoAlumno, $apMaternoAlumno, $nombresAlumno, $dniAlumno, $fechaNacAlumno, $direccionAlumno)
     {
         $sql="CALL SP_ALUMNOS_INSERT(?,?,?,?,?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('ssssss', $apPaternoAlumno, $apMaternoAlumno, $nombresAlumno, $dniAlumno, $fechaNacAlumno, $direccionAlumno);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function update($apPaternoAlumno, $apMaternoAlumno, $nombresAlumno, $dniAlumno, $fechaNacAlumno, $direccionAlumno, $idAlumno)
     {
         $sql="CALL SP_ALUMNOS_UPDATE(?,?,?,?,?,?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('ssssssi', $apPaternoAlumno, $apMaternoAlumno, $nombresAlumno, $dniAlumno, $fechaNacAlumno, $direccionAlumno, $idAlumno);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function delete($id)
     {
         $sql="DELETE FROM ALUMNOS WHERE idAlumno =?";
         return $this->mysqli->delete($sql, $id);
     }

     public function logeo($userAlumno, $passAlumno)
     {
         $sql="CALL SP_ALUMNOS_SELECT_LOGIN(?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('ss', $userAlumno, $passAlumno);
         $result=$this->mysqli->search($stmt);
         $conn->close();

         return $result;
     }
 }
