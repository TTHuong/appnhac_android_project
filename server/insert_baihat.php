<?php
    require "connect.php";

    $idAlbum    =   $_POST['idAlbum'];
    $idTheLoai  =   $_POST['idTheLoai'];
    $idPlayList =   $_POST['idPlayList'];
    $TenBaiHat  =   $_POST['TenBaiHat'];
    $HinhBaiHat =   $_POST['HinhBaiHat'];
    $Casi       =   $_POST['Casi'];
    $LinkBaiHat =   $_POST['LinkBaiHat'];
    $LuotThich  =   $_POST['LuotThich'];

    $query="INSERT INTO baihat VALUES(null,'$idAlbum','$idTheLoai','$idPlayList','$TenBaiHat','$HinhBaiHat','$Casi','$LinkBaiHat','$LuotThich' ) ";

    if(mysqli_query($con,$query)){
        echo "success";
    }
    else{
        echo "error";
    }
?>