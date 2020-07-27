-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th12 13, 2019 lúc 10:28 PM
-- Phiên bản máy phục vụ: 5.7.26
-- Phiên bản PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_projectjava`
--
CREATE DATABASE IF NOT EXISTS `db_projectjava` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `db_projectjava`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

DROP TABLE IF EXISTS `chitiethd`;
CREATE TABLE IF NOT EXISTS `chitiethd` (
  `maHD` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `maHH` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` double NOT NULL,
  `thanhTien` double NOT NULL,
  PRIMARY KEY (`maHD`,`maHH`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`maHD`, `maHH`, `soLuong`, `donGia`, `thanhTien`) VALUES
('HD1', 'NIKE02', 1, 200000, 200000),
('HD1', 'ADDIDAS01', 1, 250000, 250000),
('HD1', 'CAOCAP02', 1, 450000, 450000),
('HD2', 'ADDIDAS02', 2, 230000, 230000),
('HD3', 'NIKE03', 2, 300000, 300000),
('HD3', 'CAOCAP01', 1, 450000, 450000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hanghoa`
--

DROP TABLE IF EXISTS `hanghoa`;
CREATE TABLE IF NOT EXISTS `hanghoa` (
  `maHH` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenHH` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGiaNhap` double NOT NULL,
  `donGiaBan` double NOT NULL,
  `ghiChu` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`maHH`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hanghoa`
--

INSERT INTO `hanghoa` (`maHH`, `tenHH`, `soLuong`, `donGiaNhap`, `donGiaBan`, `ghiChu`) VALUES
('NIKE01', 'ÁO THUN NAM NIKE ĐỎ', 20, 150000, 200000, 'ÁO THUN'),
('NIKE02', 'ÁO THUN NAM NIKE TRẮNG', 20, 150000, 200000, 'ÁO THUN'),
('NIKE03', 'ÁO KHOÁC NIKE ĐEN', 10, 250000, 300000, 'ÁO KHOÁC'),
('NIKE04', 'ÁO THUN NAM NIKE VÀNG', 20, 150000, 200000, 'ÁO THUN'),
('NIKE05', 'ÁO THUN NAM NIKE ĐEN TRẮNG', 20, 150000, 200000, 'ÁO THUN'),
('ADDIDAS01', 'ÁO SƠ MI NAM ADDIDAS CARO', 39, 200000, 250000, 'ÁO SƠ MI'),
('ADDIDAS02', 'QUẦN SHORT NAM TRẮNG', 30, 180000, 230000, 'QUẦN SHORT'),
('ADDIDAS03', 'ÁO THUN ADDIDAS VÀNG', 40, 150000, 200000, 'ÁO THUN'),
('CAOCAP01', 'ÁO SƠ MI CAO CẤP TRẮNG', 25, 400000, 450000, 'ÁO SƠ MI'),
('CAOCAP02', 'ÁO SƠ MI CAO CẤP XANH', 25, 400000, 450000, 'ÁO SƠ MI'),
('CAOCAP03', 'ÁO SƠ MI CAP CẤP TÍM', 25, 400000, 450000, 'ÁO SƠ MI'),
('ss', 'áo sơ mi', 3, 200000, 200000, 'Áo sơ mi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `maHD` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maKH` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngayLap` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tongTien` double NOT NULL,
  PRIMARY KEY (`maHD`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`maHD`, `maKH`, `maNV`, `ngayLap`, `tongTien`) VALUES
('HD1', 'KH01', 'NV01', '13/12/2019', 900000),
('HD2', 'KH02', 'NV01', '14/12/2019', 460000),
('HD3', 'KH03', 'NV02', '15/12/2019', 750000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `maKH` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `tenKH` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `soDT` varchar(100) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`maKH`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`maKH`, `tenKH`, `diaChi`, `soDT`) VALUES
('KH01', 'Nguyễn Lan Trinh', 'Hà Nội', '0905082240'),
('KH02', 'Trần Thành Nam', 'Hồ Chí Minh', '0862532314'),
('KH03', 'Nguyễn Thị Lan Thư', 'Hồ Chí Minh', '0702526825'),
('KH04', 'Cao Thành Đạt', 'Quảng Nam', '0901141774');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `maNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenNV` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `gioiTinh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `soDT` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phanQuyen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `tenNV`, `matKhau`, `gioiTinh`, `diaChi`, `soDT`, `ngaySinh`, `phanQuyen`) VALUES
('admin01', 'Cao Thành Đạt', '111', 'Nam', 'Quảng Nam', '0901141774', '03/03/2000', 'ADMIN'),
('admin02', 'Hồ Khắc Lĩnh', '222', 'Nam', 'Hà Tĩnh', '0262585245', '01/01/2000', 'ADMIN'),
('nv01', 'Trần Thảo Trinh', '333', 'Nữ', 'Đà Nẵng', '0852435214', '18/06/2000', 'NHANVIEN'),
('nv02', 'Nguyễn Thu Trang', '444', 'Nữ', 'Hồ Chí Minh', '0325249824', '12/07/1995', 'NHANVIEN'),
('nv03', 'Đinh Công Sơn', '555', 'Nam', 'Hà Nội', '0752341126', '22/10/1998', 'NHANVIEN');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
