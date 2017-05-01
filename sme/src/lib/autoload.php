<?php
//Metod para cargar de forma automatica los achivos necesarios
function __autoload($class_name) {
        //nombre de los directorios
        $directoryBase='../src/';
        $directorys = array(
            $directoryBase.'dbcn/',
            $directoryBase.'dao/',
            $directoryBase.'interface/',
            $directoryBase.'service/',
            $directoryBase.'lib/'
        );

        //recorremos cada directorio
        foreach($directorys as $directory)
        {
            //verificanos si la clase existe
            if(file_exists($directory.$class_name . '.php'))
            {
                require_once($directory.$class_name . '.php');
                return;
            }
        }
    }

?>
