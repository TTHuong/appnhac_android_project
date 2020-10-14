<?php
    require "connect.php";
    
    class Baihat{
        function Baihat($idBaiHat,$idAlbum,$idTheLoai,$idPlayList,$TenBaiHat,$HinhBaiHat,$Casi,$LinkBaiHat,$LuotThich){
            $this->idBaiHat=$idBaiHat;
            $this->idAlbum=$idAlbum;
            $this->idTheLoai=$idTheLoai;
            $this->idPlayList=$idPlayList;
            $this->TenBaiHat=$TenBaiHat;
            $this->HinhBaiHat=$HinhBaiHat;
            $this->Casi=$Casi;
            $this->LinkBaiHat=$LinkBaiHat;
            $this->LuotThich=$LuotThich;
        }
    }

    $arrayalbum=array();
    $query="SELECT * FROM baihat ";
    $data = mysqli_query($con,$query);

    while($row=mysqli_fetch_assoc($data)){
        array_push($arrayalbum,new Baihat($row['idBaiHat'],
                                        $row['idAlbum'],
                                        $row['idTheLoai'],
                                        $row['idPlayList'],
                                        $row['TenBaiHat'],
                                        $row['HinhBaiHat'],
                                        $row['Casi'],
                                        $row['LinkBaiHat'],
                                        $row['LuotThich']
                                    ));
    }

    echo json_encode($arrayalbum);
?>