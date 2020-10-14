<?php
    require "connect.php";

    $idBaiHat   =   $_POST['idBaiHat'];

    $query="DELETE FROM baihat WHERE idBaiHat='$idBaiHat' ";

    if(mysqli_query($con,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>