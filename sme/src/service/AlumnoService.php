<?php
/**
 *
 */
require_once "../src/lib/autoload.php";
class AlumnoService implements iCrudService
{
    const TABLE = "Alumno";
    protected $dao;

    public function __construct()
    {
        $this->dao = new AlumnoDao();
    }

    public function getAll()
    {
        UtilService::jsonEncode($this->dao->getAll());
    }

    public function getById()
    {
        if (!empty($_GET[UtilConst::ID])) {
            UtilService::jsonEncode($this->dao->getById($_GET[UtilConst::ID]));
        } else {
            UtilService::errorResponse("No ingreso codigo de " . self::TABLE);
        }
    }

    public function insert()
    {
        $obj = UtilService::jsonDecode();

        if (isset($obj->apPaternoAlumno) && isset($obj->apMaternoAlumno) && isset($obj->nombresAlumno) && isset($obj->dniAlumno) && isset($obj->fechaNacAlumno) && isset($obj->direccionAlumno)) {
            $result = $this->dao->insert($obj->apPaternoAlumno, $obj->apMaternoAlumno, $obj->nombresAlumno, $obj->dniAlumno, $obj->fechaNacAlumno, $obj->direccionAlumno);
            UtilService::jsonEncodeIUD($result, self::TABLE, "Registrado");
        } else {
            UtilService::errorResponse("JSON no coressponde a " . self::TABLE);
        }
    }

    public function update()
    {
        $obj = UtilService::jsonDecode();

        if (isset($obj->apPaternoAlumno) && isset($obj->apMaternoAlumno) && isset($obj->nombresAlumno) && isset($obj->dniAlumno) && isset($obj->fechaNacAlumno) && isset($obj->direccionAlumno) && isset($obj->idAlumno)) {
            $result = $this->dao->update($obj->apPaternoAlumno, $obj->apMaternoAlumno, $obj->nombresAlumno, $obj->dniAlumno, $obj->fechaNacAlumno, $obj->direccionAlumno, $obj->idAlumno);
            UtilService::jsonEncodeIUD($result, self::TABLE, "Actualizado");
        } else {
            UtilService::errorResponse("JSON no coressponde a " . self::TABLE);
        }
    }
    public function updateFcmToken()
    {
        $obj = UtilService::jsonDecode();

        if (($obj->fcmToken) && isset($obj->idAlumno)) {
            $result = $this->dao->updateFcmToken($obj->fcmToken, $obj->idAlumno);
            UtilService::jsonEncodeIUD($result, self::TABLE, "fcm token Actualizado");
        } else {
            UtilService::errorResponse("JSON no coressponde a " . self::TABLE);
        }
    }
    public function delete()
    {
        if (!empty($_GET[UtilConst::ID])) {
            $result = $this->dao->delete($_GET[UtilConst::ID]);

            UtilService::jsonEncodeIUD($result, self::TABLE, "Eliminado");
        } else {
            UtilService::errorResponse("No ingreso codigo de " . self::TABLE);
        }
    }

    public function logeo()
    {
        $obj = UtilService::jsonDecode();

        if (isset($obj->userAlumno) && isset($obj->passAlumno)) {
            $result = $this->dao->logeo($obj->userAlumno, $obj->passAlumno);
            UtilService::jsonEncode($result);
        } else {
            UtilService::errorResponse("JSON no coressponde a " . self::TABLE);
        }
    }

    //FUNCION PARA LISTAR ALUMNO POR LOGEO DE APODERADO

    public function getAlumByIdApoderado()
    {
        if (!empty($_GET[UtilConst::ID])) {
            UtilService::jsonEncode($this->dao->list_alum_by_IDapoderado($_GET[UtilConst::ID]));
        } else {
            UtilService::errorResponse("No ingreso codigo de" . self::TABLE);
        }
    }

//Metodo que decide que accion se realizara
    public function restApi()
    {
        if (!empty($_GET[UtilConst::ACCION])) {
            $action = $_GET[UtilConst::ACCION];

            switch ($action) {
                case UtilConst::LISTAR:
                    $this->getAll();
                    break;
                case UtilConst::BUSCAR:
                    $this->getById();
                    break;
                case UtilConst::REGISTRAR:
                    $this->insert();
                    break;
                case UtilConst::ACTUALIZAR:
                    $this->update();
                    break;
                case UtilConst::ELIMINAR:
                    if ($_SERVER['REQUEST_METHOD'] == "DELETE") {
                        $this->delete();
                    } else {
                        UtilService::errorResponse("Use metodo DELETE");
                    }
                    break;
                case 'logeo':
                    $this->logeo();
                    break;
                case UtilConst::LISTA_ALUM_BY_APOD:
                    $this->getAlumByIdApoderado();
                    break;
                case 'updtoken':
                    $this->updateFcmToken();
                    break;

                default:
                    UtilService::errorResponse("Metodo no existe");
                    break;
            }
        } else {
            UtilService::errorResponse("No indico ningun metodo");
        }
    }
}
