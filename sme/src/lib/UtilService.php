<?php
/**
 *
 */
class UtilService
{

//conver en formato Json
public static function response($state=false, $msg="")
{
    $stateBool=$state==true?'true':'false';
    $result = array('state'=>$stateBool,'msg'=>$msg);

    header('Content-Type: application/JSON');
    echo json_encode($result, JSON_PRETTY_PRINT);
}

//para devolver un mensaje en fomato Json (correcto o error)
public static function jsonEncodeIUD($result=0, $name, $action)
{
    if ($result==1) {
        self::response(true, $name." ".$action." correctamente");
    } else {
        self::response(false, "Error !!!. ".$name." no ".$action);
    }
}

    public static function errorResponse($msg)
    {
        self::response(false, $msg);
    }

//Convertir en formato Json
public static function jsonEncode($result)
{
    echo json_encode($result, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE);
}

//Convertir Json en un Objeto
public static function jsonDecode()
{
    $obj = json_decode(file_get_contents('php://input'));
    $objArr = (array)$obj;
    if (empty($objArr)) {
        self::errorResponse("JSON no esta definido correctamete.");
        exit();
    }
    return $obj;
}
}
