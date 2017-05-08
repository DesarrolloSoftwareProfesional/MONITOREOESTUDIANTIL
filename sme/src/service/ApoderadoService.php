<?php 
	require_once("../src/lib/autoload.php");

	/**
	* 
	*/
	class ApoderadoService implements iCrudService
	{
		const TABLE = "Apoderado";
		protected $dao;

		public function __construct()
		{
			$this->dao = new ApoderadoDao();
		}

		public function getAll()
		{
			UtilService::jsonencode($this->dao->getAll());
		}

		public function getById()
		{
			if(!empty($_GET[UtilConst::ID]))
			{
				UtilService::jsonencode($this->dao->getById($_GET[UtilConst::ID]));
			}
			else{
				UtilService::errorResponse("No ingreso codigo de".self::TABLE);
			}
		}

		public function insert()
		{
			$obj = UtilService::jsonDecode();

			if(isset($obj->apPaternoApoderado) && isset($obj->apMaternoApoderado) && isset($obj->nombresApoderado) && isset($obj->dniApoderado) && isset($obj->fechaNacApoderado) && isset($obj->direccionApoderado))
			{
				$result=$this->dao->insert($obj->apPaternoApoderado,$obj->apMaternoApoderado,$obj->nombresApoderado,$obj->dniApoderado,$obj->fechaNacApoderado,$obj->direccionApoderado);
				UtilService::jsonencodeUID($result,self::TABLE,"Registrado");
			}else{
				UtilService::errorResponse("JSON no corresponde a ".self::TABLE);
			}
		}

		public function update(){
			$obj = UtilService::jsonDecode();

			if(isset($obj->apPaternoApoderado) && isset($obj->apMaternoApoderado) && isset($obj->nombresApoderado) && isset($obj->dniApoderado) && isset($obj->fechaNacApoderado) && isset($obj->direccionApoderado) && isset($obj->idApoderado))
			{
				$result=$this->dao->update($obj->apPaternoApoderado,$obj->apMaternoApoderado,$obj->nombresApoderado,$obj->dniApoderado,$obj->fechaNacApoderado,$obj->direccionApoderado,$obj->idApoderado);
				UtilService::jsonencodeUID($result,self::TABLE,"Registrado");
			}else{
				UtilService::errorResponse("JSON no corresponde a ".self::TABLE);
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

		public function logeo()
		{
			 $obj = UtilService::jsonDecode();

	        if (isset($obj->userApoderado) && isset($obj->passApoderado)) {
	            $result = $this->dao->logeo($obj->userApoderado, $obj->passApoderado);
	            UtilService::jsonEncode($result);
	        } else {
	            UtilService::errorResponse("JSON no coressponde a ".self::TABLE);
	        }
		}


		public function restApi()
		{
			if(!empty($_GET[UtilConst::ACCION])){
				header("Content-Type: application/JSON; charset=utf-8");

				$action = $_GET[UtilConst::ACCION];

				switch ($action) {
					case UtilConst::LISTAR:
						$this->getAll();
						break;
					case UtilConst::BUSCAR:
						$this->findById();
						break;
					case UtilConst::REGISTRAR:
						$this->insert();
						break;
					case UtilConst::ACTUALIZAR:
						$this->update();
						break;
					case UtilConst::ELIMINAR:
						if($_SERVER['REQUEST_METHOD']=="DELETE"){
							$this->delete();
						}else{
							UtilService::errorResponse("Use metodo DELETE");
						}
						break;
					case 'logeo':
						$this->logeo();
						break;
					default:
						UtilService::errorResponse("Metodo no existe");
						break;
				}
			}else{
				UtilService::errorResponse("No indico ningun metodo");
			}
		}


	}
 ?>