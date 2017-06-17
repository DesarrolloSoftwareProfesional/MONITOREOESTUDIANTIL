<?php
interface iCrudService
{
    public function getAll();
    public function getById();
    public function insert();
    public function update();
    public function delete();

}
