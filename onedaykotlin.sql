-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 13, 2020 at 08:32 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onedaykotlin`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `id` int(11) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `gambar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kategori`
--

INSERT INTO `tb_kategori` (`id`, `kategori`, `gambar`) VALUES
(1, 'Baju', 'kategori_pakaian.jpeg'),
(2, 'Celana', 'kategori_celana.png'),
(3, 'Sepatu', 'kategori_sepatu.png'),
(4, 'Handphone', 'kategori_handphone.png'),
(5, 'Laptop', 'kategori_laptop.jpeg'),
(6, 'Elektronik', 'kategori_elektronik.png');

-- --------------------------------------------------------

--
-- Table structure for table `tb_keranjang`
--

CREATE TABLE `tb_keranjang` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_produk`
--

CREATE TABLE `tb_produk` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `harga` varchar(100) NOT NULL,
  `stok` int(11) NOT NULL,
  `gambar` text NOT NULL,
  `deskripsi` text NOT NULL,
  `promo` int(11) NOT NULL DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_produk`
--

INSERT INTO `tb_produk` (`id`, `nama`, `id_kategori`, `harga`, `stok`, `gambar`, `deskripsi`, `promo`, `created_at`) VALUES
(1, 'iPhone XS', 4, '24000000', 10, 'handphone1.png', '', 1, '2020-01-09 00:46:28'),
(2, 'Sepatu nike', 3, '300000', 15, 'sepatu1.png', '', 1, '2020-01-05 06:58:27'),
(3, 'Macbook pro 15inc', 5, '23000000', 5, 'laptop1.png', 'Sistem Operasi : Sierra Tipe Grafis : Intel Iris Graphics 540 Memori RAM 8 GB & HDD 128 GB Prosesor dual-core Intel Core i5 Ukuran layar 13 Inch LED-Backlit IPS Retina Display', 1, '2020-01-05 17:11:22'),
(4, 'Celana jeans', 2, '100000', 20, 'celana1.png', '', 0, '2020-01-05 05:04:03'),
(5, 'Baju red', 1, '75000', 23, 'baju1.png', '', 0, '2020-01-05 05:01:00');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` text NOT NULL,
  `fullname` varchar(20) NOT NULL,
  `nohp` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id`, `username`, `password`, `fullname`, `nohp`, `alamat`, `created_at`) VALUES
(1, 'mrafiulwap', '4297f44b13955235245b2497399d7a93', 'Muhammad Rafi', '085217721558', 'Tangerang Selatan', '2020-01-02 05:38:56'),
(2, 'mrup', '4297f44b13955235245b2497399d7a93', 'Mrup Ya', '08234567', 'Ciputat', '2020-01-02 07:04:18'),
(3, 'mrup123', '4297f44b13955235245b2497399d7a93', 'Mrup Ya', '08234567', 'Ciputat', '2020-01-03 04:39:42'),
(4, 'mrup1', '4297f44b13955235245b2497399d7a93', 'Mrup Ya', '08234567', 'Ciputat', '2020-01-03 04:42:19'),
(5, 'rafi', '4297f44b13955235245b2497399d7a93', 'Muhammad Rafi', '085231546', 'Tangerang Selatan', '2020-01-03 05:20:57');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_kategori`
--
ALTER TABLE `tb_kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_kategori`
--
ALTER TABLE `tb_kategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `tb_produk`
--
ALTER TABLE `tb_produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
