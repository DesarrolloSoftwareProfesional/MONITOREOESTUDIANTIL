<?php
/**
 *
 */
class Connection
{

//Metodo para abrir una conexion a la BD
    public function open()
    {
        $mysqli = new mysqli("localhost", "admin", "123", "BD_SGMEV3");

        if ($mysqli->connect_error) {
            die("error de conexion: " . $mysqli->connect_errno);
            exit();
        }

        return $mysqli;
    }

//Realizar un busqueda por id de la Tabla
    public function find($sql, $id)
    {
        $mysqli = $this->open();
        $stmt   = $mysqli->prepare($sql);
        $stmt->bind_param('i', $id);
        $stmt->execute();
        $result = $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
        $stmt->close();
        $mysqli->close();
        return $result;
    }

//Realizar un busqueda por id (String) de la Tabla
    public function findByIdString($sql, $id)
    {
        $mysqli = $this->open();
        $stmt   = $mysqli->prepare($sql);
        $stmt->bind_param('s', $id);
        $stmt->execute();
        $result = $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
        $stmt->close();
        $mysqli->close();
        return $result;
    }

//Realizar un select completo
    public function findAll($sql)
    {
        $mysqli = $this->open();
        $stmt   = $mysqli->query($sql);
        $result = $stmt->fetch_all(MYSQLI_ASSOC);
        // $result = array();
        // while ($row = mysqli_fetch_assoc($stmt)) {
        //     $result[] = array_map('utf8_encode', $row);
        // }
        $stmt->close();
        $mysqli->close();
        return $result;
    }

//realizar una busqueda por varios parametros
    public function search($stmt)
    {
        $stmt->execute();
        $result = $stmt->get_result()->fetch_all(MYSQLI_ASSOC);
        $stmt->close();
        return $result;
    }

//Realizar {Registo,Actualizar,Eliminar}
    public function executeIUD($stmt)
    {
        $stmt->execute();
        $result = $stmt->affected_rows;
        $stmt->close();
        return $result;
    }

//Elimina un regisgro por id
    public function delete($sql, $id)
    {
        $mysqli = $this->open();
        $stmt   = $mysqli->prepare($sql);
        $stmt->bind_param('i', $id);
        $stmt->execute();
        $result = $stmt->affected_rows;
        $stmt->close();
        $mysqli->close();
        return $result;
    }
}
