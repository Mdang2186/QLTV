-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 22, 2025 lúc 07:46 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thuviendb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `MaPhieuMuon` varchar(4) NOT NULL,
  `MaSach` varchar(3) NOT NULL,
  `TinhTrang` tinyint(1) DEFAULT NULL,
  `NgayTraSach` date DEFAULT NULL,
  `TienPhat` decimal(10,2) DEFAULT NULL,
  `MaNhanVienNhanTraSach` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`MaPhieuMuon`, `MaSach`, `TinhTrang`, `NgayTraSach`, `TienPhat`, `MaNhanVienNhanTraSach`) VALUES
('PM01', 'S01', 1, NULL, 0.00, NULL),
('PM02', 'S02', 0, '2023-02-20', 0.00, 'NV02'),
('PM03', 'S03', 0, '2023-02-25', 5.00, 'NV03'),
('PM04', 'S04', 1, NULL, 0.00, NULL),
('PM05', 'S05', 0, '2023-03-01', 0.00, 'NV05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `MaDocGia` varchar(4) NOT NULL,
  `TenDocGia` varchar(255) NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `NgayTaoThe` date DEFAULT NULL,
  `MaNhanVienTaoThe` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`MaDocGia`, `TenDocGia`, `NgaySinh`, `GioiTinh`, `DiaChi`, `NgayTaoThe`, `MaNhanVienTaoThe`) VALUES
('DG01', 'Phạm Minh Huy', '1995-04-10', 'Nam', 'Hà Nội', '2023-01-01', 'NV01'),
('DG02', 'Lê Thị Hoa', '1988-08-15', 'Nữ', 'TP.HCM', '2023-01-02', 'NV02'),
('DG03', 'Ngô Minh Tuấn', '1990-12-20', 'Nam', 'Đà Nẵng', '2023-01-03', 'NV03'),
('DG04', 'Trần Thị Lan', '1992-06-30', 'Nữ', 'Huế', '2023-01-04', 'NV04'),
('DG05', 'Đỗ Thị Mai', '1998-11-11', 'Nữ', 'Cần Thơ', '2023-01-05', 'NV05'),
('DG09', 'Tran Hung', '2009-04-03', 'Nam', 'YB', NULL, 'NV01'),
('DG10', 'Tran Hang ', '2009-09-20', 'Nam', 'HN', '2023-09-23', 'NV01'),
('DG13', 'Kien Quy', '2003-02-24', 'Nam', 'HN', NULL, 'Nv03'),
('DG76', 'Cong Minh', '2009-04-24', 'Nam', 'HN', '2025-04-22', 'NV01'),
('DG89', 'Minh', '2009-09-09', 'Nam', 'YN', '2023-09-23', 'NV01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `TenDangNhap` varchar(50) NOT NULL,
  `MatKhau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`TenDangNhap`, `MatKhau`) VALUES
('user1', 12345),
('user2', 23456),
('user3', 34567),
('user4', 45678),
('user5', 56789);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(4) NOT NULL,
  `TenNhanVien` varchar(255) NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `SoDienThoai` varchar(15) DEFAULT NULL,
  `TenDangNhap` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `GioiTinh`, `SoDienThoai`, `TenDangNhap`) VALUES
('NV01', 'Nguyễn Văn An', '1980-01-10', 'Nam', '0901234567', 'user1'),
('NV02', 'Trần Thị Bích', '1985-05-20', 'Nữ', '0902345678', 'user2'),
('NV03', 'Lê Văn Cường', '1990-03-15', 'Nam', '0903456789', 'user3'),
('NV04', 'Phạm Thị Diễm', '1978-12-25', 'Nữ', '0904567890', 'user4'),
('NV05', 'Hoàng Văn Duy', '1982-07-07', 'Nam', '0905678901', 'user5');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNhaXuatBan` varchar(5) NOT NULL,
  `TenNhaXuatBan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNhaXuatBan`, `TenNhaXuatBan`) VALUES
('NXB01', 'Kim Dong'),
('NXB02', 'Mùa Xuân'),
('NXB03', 'NXB Lao Động'),
('NXB04', 'NXB Kim Đồng'),
('NXB05', 'NXB Tổng Hợp');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `MaPhieuMuon` varchar(4) NOT NULL,
  `MaNhanVienLapPhieu` varchar(4) DEFAULT NULL,
  `NgayLapPhieu` date DEFAULT NULL,
  `MaDocGia` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieumuon`
--

INSERT INTO `phieumuon` (`MaPhieuMuon`, `MaNhanVienLapPhieu`, `NgayLapPhieu`, `MaDocGia`) VALUES
('PM01', 'NV01', '2023-02-01', 'DG01'),
('PM02', 'NV02', '2023-02-05', 'DG02'),
('PM03', 'NV03', '2023-02-10', 'DG03'),
('PM04', 'NV04', '2023-02-15', 'DG04'),
('PM05', 'NV05', '2023-02-20', 'DG05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(3) NOT NULL,
  `TenSach` varchar(255) NOT NULL,
  `LoaiSach` varchar(100) DEFAULT NULL,
  `MaTacGia` varchar(4) DEFAULT NULL,
  `MaNhaXuatBan` varchar(5) DEFAULT NULL,
  `NgayXuatBan` date DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `LoaiSach`, `MaTacGia`, `MaNhaXuatBan`, `NgayXuatBan`, `SoLuong`) VALUES
('S01', 'Truyện Kiều', 'Văn học', 'TG01', 'NXB01', '2020-05-01', 5),
('S02', 'Lão Hạc', 'Văn học', 'TG02', 'NXB02', '2021-06-15', 3),
('S03', 'Chí Phèo', 'Văn học', 'TG02', 'NXB03', '2021-07-20', 4),
('S04', 'Dế Mèn phiêu lưu ký', 'Truyện thiếu nhi', 'TG03', 'NXB04', '2022-03-10', 6),
('S05', 'Đêm Tây', 'Thơ', 'TG05', 'NXB05', '2022-10-05', 7),
('S09', 'GUVUV', 'UH', 'TG01', 'NXB01', '2009-09-08', 9),
('S12', 'GUVUV', 'UH', 'TG01', 'NXB01', '2009-09-08', 9),
('sưb', 'Chăn cừu', 'thiếu nhi', 'TG03', 'NXB03', '2023-04-30', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTacGia` varchar(4) NOT NULL,
  `TenTacGia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`) VALUES
('TG01', 'Nguyễn Du'),
('TG02', 'Nam Cao'),
('TG03', 'Tô Hoài'),
('TG04', 'Xuân Diệu'),
('TG05', 'Hàn Mặc Tử');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD PRIMARY KEY (`MaPhieuMuon`,`MaSach`),
  ADD KEY `MaSach` (`MaSach`),
  ADD KEY `MaNhanVienNhanTraSach` (`MaNhanVienNhanTraSach`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`MaDocGia`),
  ADD KEY `MaNhanVienTaoThe` (`MaNhanVienTaoThe`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`TenDangNhap`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`),
  ADD KEY `TenDangNhap` (`TenDangNhap`);

--
-- Chỉ mục cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNhaXuatBan`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`MaPhieuMuon`),
  ADD KEY `MaNhanVienLapPhieu` (`MaNhanVienLapPhieu`),
  ADD KEY `MaDocGia` (`MaDocGia`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `MaTacGia` (`MaTacGia`),
  ADD KEY `MaNhaXuatBan` (`MaNhaXuatBan`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTacGia`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`MaPhieuMuon`),
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  ADD CONSTRAINT `chitietphieumuon_ibfk_3` FOREIGN KEY (`MaNhanVienNhanTraSach`) REFERENCES `nhanvien` (`MaNhanVien`);

--
-- Các ràng buộc cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD CONSTRAINT `docgia_ibfk_1` FOREIGN KEY (`MaNhanVienTaoThe`) REFERENCES `nhanvien` (`MaNhanVien`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`TenDangNhap`) REFERENCES `nguoidung` (`TenDangNhap`);

--
-- Các ràng buộc cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `phieumuon_ibfk_1` FOREIGN KEY (`MaNhanVienLapPhieu`) REFERENCES `nhanvien` (`MaNhanVien`),
  ADD CONSTRAINT `phieumuon_ibfk_2` FOREIGN KEY (`MaDocGia`) REFERENCES `docgia` (`MaDocGia`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`MaTacGia`),
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaNhaXuatBan`) REFERENCES `nhaxuatban` (`MaNhaXuatBan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
