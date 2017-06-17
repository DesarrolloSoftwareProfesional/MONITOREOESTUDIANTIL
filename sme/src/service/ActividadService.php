<?php
/**
 *
 */
require_once("../src/lib/autoload.php");
class ActividadService implements iCrudService
{
    const TABLE = "Actividad";
    protected $dao;

    public function __construct()
    {
        $this->dao = new ActividadDao();
    }

    public function getAll()
    {
        UtilService::jsonEncode($this->dao->getAll());
    }

    public function getAllPending()
    {
        UtilService::jsonEncode($this->dao->getAllPending());
    }

    public function getLastInserted()
    {
        $notificacion=$this->dao->getLastInserted();
        $this->setNotification($notificacion);
    }

    public function getNotificationByID()
    {
        if (!empty($_GET[UtilConst::ID])) {
            $notificacion = $this->dao->getNotificationByID($_GET[UtilConst::ID]);
            $this->setNotification($notificacion);
            // foreach ($notificacion as $key => $value) {
            //     echo $value["id"]." ".$value["actividad"]." ".$value["fecha"];
            // }
        } else {
            UtilService::errorResponse("No ingreso codigo de ".self::TABLE);
        }
    }

    public function setNotification($notificacion)
    {
        foreach ($notificacion as $key => $value) {
            echo UtilNotification::sendNotification($value["id"], $value["actividad"], $value["fecha"]);
        }
    }

    public function getById()
    {
        if (!empty($_GET[UtilConst::ID])) {
            UtilService::jsonEncode($this->dao->getById($_GET[UtilConst::ID]));
        } else {
            UtilService::errorResponse("No ingreso codigo de ".self::TABLE);
        }
    }

    public function insert()
    {
        $obj = UtilService::jsonDecode();

        if (isset($obj->idEmpleado) && isset($obj->idCurso) && isset($obj->codGrupoAcademico) &&
            isset($obj->nomActividad) && isset($obj->descrActividad) && isset($obj->fechaRealizacion) &&
            isset($obj->horaInicio) && isset($obj->horaFin) && isset($obj->frecuenciaAviso)) {
            $result= $this->dao->insert($obj->idEmpleado, $obj->idCurso, $obj->codGrupoAcademico,
                                        $obj->nomActividad, $obj->descrActividad, $obj->fechaRealizacion,
                                         $obj->horaInicio, $obj->horaFin, $obj->frecuenciaAviso);

            UtilService::jsonEncodeIUD($result, self::TABLE, "Registrado");
        } else {
            UtilService::errorResponse("JSON no coressponde a ".self::TABLE);
        }
    }

    public function update()
    {
        $obj = UtilService::jsonDecode();

        if (isset($obj->idEmpleado) && isset($obj->idCurso) && isset($obj->codGrupoAcademico) &&
          isset($obj->nomActividad) && isset($obj->descrActividad) && isset($obj->fechaRealizacion) &&
          isset($obj->horaInicio) && isset($obj->horaFin) && isset($obj->frecuenciaAviso) && isset($obj->idActividad)) {
            $result= $this->dao->update($obj->idEmpleado, $obj->idCurso, $obj->codGrupoAcademico,
                                      $obj->nomActividad, $obj->descrActividad, $obj->fechaRealizacion,
                                       $obj->horaInicio, $obj->horaFin, $obj->frecuenciaAviso, $obj->idActividad);

            UtilService::jsonEncodeIUD($result, self::TABLE, "Actualizado");
        } else {
            UtilService::errorResponse("JSON no coressponde a ".self::TABLE);
        }
    }

    public function delete()
    {
        if (!empty($_GET[UtilConst::ID])) {
            $result = $this->dao->delete($_GET[UtilConst::ID]);

            UtilService::jsonEncodeIUD($result, self::TABLE, "Eliminado");
        } else {
            UtilService::errorResponse("No ingreso codigo de ".self::TABLE);
        }
    }

//Metodo que decide que accion se realizara
  public function restApi()
  {
      if (!empty($_GET[UtilConst::ACCION])) {
          $action =$_GET[UtilConst::ACCION];

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
          if ($_SERVER['REQUEST_METHOD']=="DELETE") {
              $this->delete();
          } else {
              UtilService::errorResponse("Use metodo DELETE");
          }
          break;
        case 'pendientes':
            $this->getAllPending();
          break;
        case 'ultimoregistro':
            $this->getLastInserted();
          break;
        case 'notificacion':
            $this->getNotificationByID();
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
