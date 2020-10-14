<?php
    require "connect.php";

    $idBaiHat   =   $_POST['idBaiHat'];
    $idAlbum    =   $_POST['idAlbum'];
    $idTheLoai  =   $_POST['idTheLoai'];
    $idPlayList =   $_POST['idPlayList'];
    $TenBaiHat  =   $_POST['TenBaiHat'];
    $HinhBaiHat =   $_POST['HinhBaiHat'];
    $Casi       =   $_POST['Casi'];
    $LinkBaiHat =   $_POST['LinkBaiHat'];
    $LuotThich  =   $_POST['LuotThich'];

    $query="UPDATE baihat SET idAlbum='$idAlbum',idTheLoai ='$idTheLoai', idPlayList='$idPlayList',TenBaiHat='$TenBaiHat' , HinhBaiHat='$HinhBaiHat',Casi='$Casi',LinkBaiHat='$LinkBaiHat' WHERE idBaiHat= '$idBaiHat' ";

    if(mysqli_query($con,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>