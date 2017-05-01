<?php

/**
 *
 */
 require_once("../src/lib/autoload.php");
 class PerfilDao
 {
     protected $mysqli;

     public function __construct()
     {
         $this->mysqli = new Connection();
     }

     public function getAll()
     {
         $sql="SELECT * FROM PERFILES";
         return $this->mysqli->findAll($sql);
     }

     public function getByID($id)
     {
         $sql="SELECT * FROM PERFILES WHERE idPerfil=?";
         return $this->mysqli->find($sql, $id);
     }

     public function insert($nomPerfil)
     {
         $sql="INSERT INTO PERFILES (nomPerfil) VALUES (?)";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('s', $nomPerfil);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function update($nomPerfil, $idPerfil)
     {
         $sql="UPDATE PERFILES SET nomPerfil = ? WHERE idPerfil=?";
         $conn=$this->mysqli->open();
         $stmt = $conn->prepare($sql);
         $stmt->bind_param('si', $nomPerfil, $idPerfil);
         $result=$this->mysqli->executeIUD($stmt);
         $conn->close();

         return $result;
     }

     public function delete($id)
     {
         $sql="DELETE FROM PERFILES WHERE idPerfil =?";
         return $this->mysqli->delete($sql, $id);
     }
 }
