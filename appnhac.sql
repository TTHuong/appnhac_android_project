-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 26, 2020 lúc 02:15 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id13174950_appnhac`
--
CREATE DATABASE IF NOT EXISTS `id13174950_appnhac` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id13174950_appnhac`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `album`
--

CREATE TABLE `album` (
  `idAlbum` int(11) NOT NULL,
  `TenAlbum` varchar(255) NOT NULL,
  `TenCaSiAlbum` varchar(255) NOT NULL,
  `HinhAlbum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `album`
--

INSERT INTO `album` (`idAlbum`, `TenAlbum`, `TenCaSiAlbum`, `HinhAlbum`) VALUES
(1, 'Lá Xa Lìa Cành (Single)', 'Lê Bảo Bình', 'https://doanappnhac.000webhostapp.com/images/album/L%C3%A1%20Xa%20L%C3%ACa%20C%C3%A0nh%20(Single).jpg'),
(3, 'Cháu Con Tiên Rồng Ngại Gì Corona (Single)', 'Nguyên Jenda, Bảo Yến Rosie, Yến Tatoo, Phạm Việt Thắng, Ý Tiên', 'https://doanappnhac.000webhostapp.com/images/baihat/7a6a364bbc79379cdaf0405f3e03cf33.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

CREATE TABLE `baihat` (
  `idBaiHat` int(11) NOT NULL,
  `idAlbum` varchar(255) NOT NULL,
  `idTheLoai` varchar(255) NOT NULL,
  `idPlayList` varchar(255) NOT NULL,
  `TenBaiHat` varchar(255) NOT NULL,
  `HinhBaiHat` varchar(255) NOT NULL,
  `Casi` varchar(255) NOT NULL,
  `LinkBaiHat` varchar(255) NOT NULL,
  `LuotThich` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`idBaiHat`, `idAlbum`, `idTheLoai`, `idPlayList`, `TenBaiHat`, `HinhBaiHat`, `Casi`, `LinkBaiHat`, `LuotThich`) VALUES
(1, '1', '0', '0', 'Lá Xa Lìa Cành', 'https://doanappnhac.000webhostapp.com/images/baihat/d2a8fe2f80b1da9ed5ca4d3fc921446f.jpg\r\n', 'Lê Bảo Bình', 'https://doanappnhac.000webhostapp.com/musics/Rindu%20Semalam%20(DJ%E7%89%88)%20-%20Nh%E1%BA%A1c%20g%C3%A2y%20nghi%E1%BB%87n%20tr%C3%AAn%20Tiktok%20Trung%20Qu%E1%BB%91c%20-%20Douyin%20Music.mp3', 12),
(2, '0', '1', '1', 'Hơn cả yêu', 'https://doanappnhac.000webhostapp.com/images/baihat/a9ed142c215560ab45f6b2b433907f90.jpg', 'Đức Phúc', 'https://doanappnhac.000webhostapp.com/musics/Hon-Ca-Yeu-Duc-Phuc.mp3', 3),
(3, '3', '0', '1', 'Trúc Xinh', 'https://doanappnhac.000webhostapp.com/images/baihat/6748158e7a6e0d405266aeeb99d98ff9.jpg', 'Minh Vương', 'https://doanappnhac.000webhostapp.com/musics/Truc-Xinh-Minh-Vuong-M4U-Viet-ACV.mp3\r\n', 1),
(4, '0', '0', '0', 'Chẳng Gì Là Mãi Mãi', 'https://doanappnhac.000webhostapp.com/images/baihat/37d06f31946caaedac6d56f20f695206.jpg', 'Châu Khải Phong', 'https://doanappnhac.000webhostapp.com/musics/Chang-Gi-La-Mai-Mai-Chau-Khai-Phong.mp3', 3),
(5, '2', '0', '0', 'Cháu Con Tiên Rồng Ngại Gì Corona', 'https://doanappnhac.000webhostapp.com/images/baihat/7a6a364bbc79379cdaf0405f3e03cf33.jpg', 'Nguyên Jenda, Bảo Yến Rosie, Yến Tatoo, Phạm Việt Thắng, Ý Tiên', 'https://doanappnhac.000webhostapp.com/musics/Chau-Con-Tien-Rong-Ngai-Gi-Corona-Nguyen-Jenda-Bao-Yen-Rosie-Yen-Tatoo-Pham-Viet-Thang-Y-Tien.mp3', 58),
(6, '0', '0', '3', 'Chỉ Khi Anh Một Mình', 'https://doanappnhac.000webhostapp.com/images/baihat/0c11ef66d29ff0c4496fd70ac17a7e5e.jpg', 'Vũ Duy Khánh, Đạt G', 'https://doanappnhac.000webhostapp.com/musics/Chi-Khi-Anh-Mot-Minh-Vu-Duy-Khanh-Dat-G.mp3', 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

CREATE TABLE `chude` (
  `idChuDe` int(11) NOT NULL,
  `TenChuDe` varchar(255) NOT NULL,
  `HinhChuDe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`idChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
(1, 'Nhạc Việt', 'https://doanappnhac.000webhostapp.com/images/chude/1e0f4998259f2f8a0ae7de1a7110bb62.jpg'),
(2, 'Nhạc Âu Mỹ', 'https://doanappnhac.000webhostapp.com/images/chude/nhacaumy.jpg'),
(3, 'Nhạc Hàn', 'https://doanappnhac.000webhostapp.com/images/chude/nhachan.jpg'),
(4, 'Nhạc Hoa', 'https://doanappnhac.000webhostapp.com/images/chude/nhachoa.jpg'),
(5, 'Nhạc Trịnh', 'https://doanappnhac.000webhostapp.com/images/chude/nhactrinh.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `idPlayList` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `Hinhnen` varchar(255) NOT NULL,
  `Hinhicon` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`idPlayList`, `Ten`, `Hinhnen`, `Hinhicon`) VALUES
(1, 'Top 100 Bài Hát Nhạc Trẻ Hay Nhất Việt Nam', 'https://doanappnhac.000webhostapp.com/images/playlist/fe1b806c9dd1bae58f041a4512dd956a.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/fe1b806c9dd1bae58f041a4512dd956a.jpg'),
(2, 'Top 100 Nhạc Rap Việt Nam Hay Nhất', 'https://doanappnhac.000webhostapp.com/images/playlist/rapviw.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/rapviw.jpg'),
(3, 'Top 100 Bài Hát Nhạc Trẻ Hay Nhất', 'https://doanappnhac.000webhostapp.com/images/playlist/nhactre.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/nhactre.jpg'),
(4, 'Top 100 Nhạc Electronic/Dance Âu Mỹ Hay Nhất', 'https://doanappnhac.000webhostapp.com/images/playlist/edm.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/edm.jpg'),
(5, 'Top 100 Pop Âu Mỹ Hay Nhất', 'https://doanappnhac.000webhostapp.com/images/playlist/pop.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/pop.jpg'),
(6, 'Top 100 Nhạc Dance Việt Nam Hay Nhất', 'https://doanappnhac.000webhostapp.com/images/playlist/danceviet.jpg', 'https://doanappnhac.000webhostapp.com/images/playlist/danceviet.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quangcao`
--

CREATE TABLE `quangcao` (
  `Id` int(11) NOT NULL,
  `Hinhanh` varchar(255) NOT NULL,
  `Noidung` varchar(255) NOT NULL,
  `idbaihat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quangcao`
--

INSERT INTO `quangcao` (`Id`, `Hinhanh`, `Noidung`, `idbaihat`) VALUES
(1, 'https://doanappnhac.000webhostapp.com/images/quangcao/46830030a7bd1ad3a9794f2185082699.jpg', 'Chẳng Gì Là Mãi Mãi (Single)\r\nChâu Khải Phong', 4),
(2, 'https://doanappnhac.000webhostapp.com/images/quangcao/c7c8d8dbb5b1bfa13d4045314d8ac325.jpg', 'nhằm chống dịch corona', 5),
(3, 'https://doanappnhac.000webhostapp.com/images/quangcao/f86480dfb1c134131478c745d27d414d.jpg', '', 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `idTheLoai` int(11) NOT NULL,
  `idChuDe` varchar(255) NOT NULL,
  `TenTheLoai` varchar(255) NOT NULL,
  `HinhTheLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`idTheLoai`, `idChuDe`, `TenTheLoai`, `HinhTheLoai`) VALUES
(1, '1', 'Các Ca Khúc Pop Ballad Việt Nổi Bật 2020', 'https://doanappnhac.000webhostapp.com/images/theloai/bb41fd797505cf44f757a7157609177b.jpg'),
(2, '2', 'USUK Nghe Nhiều 2020', 'https://doanappnhac.000webhostapp.com/images/theloai/USUK%20Nghe%20Nhi%E1%BB%81u%202020.jpg\r\n'),
(3, '2', 'USUK Nhạc Rap/Hip Hop Nổi Bật 2020', 'https://doanappnhac.000webhostapp.com/images/theloai/USUK%20Nh%E1%BA%A1c%20RapHip%20Hop%20N.jpg\r\n'),
(4, '2', 'USUK Nhạc EDM Nổi Bật 2020', 'https://doanappnhac.000webhostapp.com/images/theloai/USUK%20Nh%E1%BA%A1c%20EDM%20N%E1%BB%95i%20B%E1%BA%ADt%202020.jpg\r\n'),
(5, '3', 'K-POP DANCE!', 'https://doanappnhac.000webhostapp.com/images/theloai/K-POP%20DANCE!.jpg'),
(6, '3', 'Nhạc Hàn Cũ Mà Hay', 'https://doanappnhac.000webhostapp.com/images/theloai/nhachancu.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`idAlbum`);

--
-- Chỉ mục cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`idBaiHat`);

--
-- Chỉ mục cho bảng `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`idChuDe`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idPlayList`);

--
-- Chỉ mục cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`idTheLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `album`
--
ALTER TABLE `album`
  MODIFY `idAlbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `baihat`
--
ALTER TABLE `baihat`
  MODIFY `idBaiHat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `chude`
--
ALTER TABLE `chude`
  MODIFY `idChuDe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `idPlayList` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `idTheLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
