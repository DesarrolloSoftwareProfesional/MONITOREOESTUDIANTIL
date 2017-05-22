<?php
/**
 *
 */
require_once("../src/lib/autoload.php");
class GrupoAcademicoService implements iCrudService
{
    const TABLE = "Grupo academico";
    protected $dao;

    public function __construct()
    {
        $this->dao = new GrupoAcademicoDao();
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
            UtilService::errorResponse("No ingreso codigo de ".self::TABLE);
        }
    }

    public function insert()
    {
        // $obj = UtilService::jsonDecode();
    }

    public function update()
    {
        // $obj = UtilService::jsonDecode();
    }

    public function delete()
    {
        // if (!empty($_GET[UtilConst::ID])) {
        //     $result = $this->dao->delete($_GET[UtilConst::ID]);
        //
        //     UtilService::jsonEncodeIUD($result, self::TABLE, "Eliminado");
        // } else {
        //     UtilService::errorResponse("No ingreso codigo de ".self::TABLE);
        // }
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
        default:
          UtilService::errorResponse("Metodo no existe");
      break;
      }
      } else {
          UtilService::errorResponse("No indico ningun metodo");
      }
  }
}
