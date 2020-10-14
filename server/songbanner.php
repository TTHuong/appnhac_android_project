<?php
    require "connect.php";
    $query="SELECT quangcao.Id,quangcao.Hinhanh,quangcao.Noidung,quangcao.idbaihat,baihat.TenBaiHat,baihat.HinhBaiHat 
    FROM `baihat` INNER JOIN `quangcao` ON quangcao.idbaihat=baihat.idBaiHat 
    WHERE quangcao.idbaihat=baihat.idBaiHat";

    $data=mysqli_query($con,$query);

    class QuangCao{
        function QuangCao($idquangcao,$hinhanh,$noidung,$idbaihat,$tenbaihat,$hinhbaihat){
            $this->IdQuangCao=$idquangcao;
            $this->HinhAnh=$hinhanh;
            $this->NoiDung=$noidung;
            $this->IdBaiHat=$idbaihat;
            $this->TenBaiHat=$tenbaihat;
            $this->HinhBaiHat=$hinhbaihat;

        }
    }

    $mangquangcao=array();
    while($row=mysqli_fetch_assoc($data) ){
        array_push($mangquangcao,new QuangCao($row['Id'],$row['Hinhanh'],
        $row['Noidung'],$row['idbaihat'],$row['TenBaiHat'],$row['HinhBaiHat']
        ));
    }

    echo json_encode($mangquangcao);
?>