<?php

/**
 *
 */
 require_once("../src/lib/autoload.php");
 class CursoDao
 {
     protected $mysqli;

     public function __construct()
     {
         $this->mysqli = new Connection();
     }

     public function getAll()
     {
         $sql="CALL SP_CURSOS_SELECT_ALL()";
         return $this->mysqli->findAll($sql);
     }

     public function getByID($id)
     {
         $sql="CALL SP_CURSOS_SELECT_BY_ID(?)";
         return $this->mysqli->find($sql, $id);
     }
 }
