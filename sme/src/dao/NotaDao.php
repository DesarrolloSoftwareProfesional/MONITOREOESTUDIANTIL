<?php

/**
 *
 */
 require_once("../src/lib/autoload.php");
 class NotaDao
 {
     protected $mysqli;

     public function __construct()
     {
         $this->mysqli = new Connection();
     }

     public function getAll()
     {
         $sql="";
         return $this->mysqli->findAll($sql);
     }

     public function getByID($id)
     {
         $sql="";
         return $this->mysqli->find($sql, $id);
     }

     public function getAllByID($id)
     {
         $sql="CALL SP_NOTAS_SELECT_ALL_BY_ID(?)";
         $conn=$this->mysqli->open();
         $stmt=$conn->prepare($sql);
         $stmt->bind_param("i", $id);
         $result=$this->mysqli->search($stmt);
         $conn->close();

         return $result;
     }

     public function getAllPromedioByTrimestreAlumno($idAlumno, $trimestre)
     {
         $sql="CALL SP_NOTAS_PROMEDIO_TRIMESTRE_SELECT_ALL_BY_ID(?,?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('ii', $idAlumno, $trimestre);
         $result=$this->mysqli->search($stmt);
         $conn->close();

         return $result;
     }

     public function getAllPromedioByID($id)
     {
         $sql="CALL SP_NOTAS_PROMEDIO_SELECT_ALL_BY_ID(?)";
         $conn=$this->mysqli->open();
         $stmt=$conn->prepare($sql);
         $stmt->bind_param("i", $id);
         $result=$this->mysqli->search($stmt);
         $conn->close();

         return $result;
     }

     public function insert($nomPerfil)
     {
         $sql="";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('s', $nomPerfil);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function update($nomPerfil, $idPerfil)
     {
         $sql="";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('', $nomPerfil, $idPerfil);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function delete($id)
     {
         $sql="";
         return $this->mysqli->delete($sql, $id);
     }
 }
