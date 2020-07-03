-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 03, 2020 lúc 04:16 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `realproperty`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `blog`
--

INSERT INTO `blog` (`id`, `description`, `image`, `title`) VALUES
(1, 'After night falls, there are many cool things to do in Hanoi including eating and shopping. However, if you are looking for a memorable night out but not at a bar or cafe, there are night markets that offer an unforgettable holiday experience, as well as a fantastic opportunity for some discount shopping. Here are some of the best night markets in Hanoi.', '4-best-night-markets-in-hanoi.jpg', '4 Best Night Markets in Hanoi to Visit'),
(2, 'Dong Xuan night market extends from the beginning of Hoan Kiem lake, through Hang Ngang, Hang Dao, Hang Duong. The only way to go straight is to make sure you have not missed an interesting stall. Products are sold here are very rich: from adult clothes, bags, wallets, belts ... to a number of household items, souvenirs, home decoration … Dong Xuan night market opens after hours and continues until 23 pm.\r\n\r\nThis is  considered a very useful and successful way to discover the traditional culture in Hanoi. You can find performers of arts like “đàn bầu” “sẩm” and other cultural activities include “ca trù”, “chèo”.', 'dong-xuan-night-market.jpg', 'Dong Xuan night market'),
(3, 'Khi nói về những căn hộ dịch vụ 5 sao, chúng ta nói tới hàng loạt các dự án lớn được xây dựng và quản lý bởi một chủ đầu tư. Ưu điểm của những căn hộ dịch vụ 5 sao phải kể đến cơ sở hạ tầng tốt và dịch vụ chuyên nghiệp. Tuy nhiên, giá thành cao và lượng cung hạn chế sẽ không đáp ứng đủ nhu cầu của thị trường khi số lượng khách nước ngoài chuyến đến Việt Nam ngày càng tăng.', 'story-realproperty.jpg', 'Câu chuyện thành công của Real Property'),
(4, '💐 Vào ngày 29-3-2019 vừa rồi, lễ hội hoa anh đào Nhật Bản đã chính thức được khai mạc tại tượng đài Lý Thái Tổ dưới sự theo dõi của hàng ngàn quý khán giả có mặt tại khu vực hồ Hoàn Kiếm và qua màn ảnh lớn. 💐 Tại lễ khai mạc, đại sứ thiện chí hoa anh đào thứ nhất-Trần Diệu Linh và đại sứ thiện chí hoa anh đào thứ hai-Phạm Ngọc Linh đã ra mắt công chúng. Với vai trò của mình, hai vị đại sứ sẽ có nhiều hoạt động nhằm thúc đẩy quan hệ hữu nghị giữa hai đất nước Nhật Bản - Việt Nam. 💐 Ngài Ijima Isao, cố vấn đặc biệt của Thủ tướng Nhật Bản đã nhắn nhủ tới người dân Thủ đô, hãy tới với lễ hội hoa anh đào Nhật Bản-Hà Nội để tận hưởng vẻ đẹp của loài hoa này và cảm nhận tình hữu nghị giữa hai đất nước. ☀ Lễ hội hoa anh đào Nhật Bản sẽ kéo dài thêm một ngày nữa (tới 22h ngày 1-4-2019), hãy cùng Property Plus đưa bạn bè và người thân tới khu vực hồ Hoàn Kiếm để được chiêm ngưỡng vẻ đẹp nghiêng đất nghiêng trời của lễ hội đặc biệt này nhé!', 'festival.jpg', 'Lễ hội hoa anh đào Nhật Bản'),
(5, 'Trong bài viết này, Property Plus sẽ tập trung vào đời sống hàng ngày của người bản địa tại Hà Nội nói riêng và người Việt Nam nói chung. “Đặc sản đời sống” có thể khác nhau dựa vào văn hóa và sinh hoạt của từng vùng miền, nhưng những thành thị lớn luôn có một số đặc điểm chung mà người nước ngoài cũng như người bản địa đều có dấu ấn sâu sắc. Hầu hết những người đến du lịch hay cư trú tại Hà Nội đều “bị ám ảnh” với một trong những vấn đề khó giải quyết nhất của người Việt Nam, đó chính là giao thông.', 'vietnampeople.jpg', 'Khác biệt về văn hóa: Đời sống thường ngày của người Việt Nam'),
(6, 'Bạn là thương nhân đang trong chuyến công tác tới Hà Nội và cần tìm nơi thuê nhà? Bạn là đại diện công ty tìm căn hộ với chất lượng đạt chuẩn để gửi người tới công tác? Bạn là trụ cột trong gia đình đang tìm kiếm một căn hộ với dịch vụ tiện nghi hàng đầu và an ninh đảm bảo? Cuộc tìm kiếm đã kết thúc vì tại Property Plus, chúng tôi tự hào với khả năng cung cấp cho khách thuê tất cả những cơ hội tốt nhất liên quan tới dịch vụ căn hộ cấp cao.', 'houserent.jpg', 'Thuê nhà tại Real Property : Chỉ cần hưởng!');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `appointment_date` date DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `property_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `client`
--

INSERT INTO `client` (`id`, `appointment_date`, `created_at`, `email`, `fullname`, `phone`, `status`, `updated_at`, `employee_id`, `property_id`) VALUES
(1, '2020-06-25', '2020-06-24', 'james@gmail.com', 'James', '0983005335', 'Fulfill', '2020-07-02', NULL, 1),
(2, '2020-06-28', '2020-06-28', 'harry@gmail.com', 'Harry', '0983005335', 'Waiting', '2020-07-02', NULL, 8),
(3, '2020-07-10', '2020-07-01', 'trung@gmail.com', 'Trần Văn Trung', '0983005335', 'Waiting', '2020-07-02', NULL, 5),
(4, '2020-07-26', '2020-07-02', 'alex@gmail.com', 'Alex', '0983005335', 'Waiting', '2020-07-03', NULL, 4),
(14, '2020-07-05', '2020-07-03', 'tdviet01@gmail.com', 'Trần Đức Việt', '0983005335', 'Waiting', '2020-07-03', 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contract`
--

CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `commission` int(11) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `property_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `contract`
--

INSERT INTO `contract` (`id`, `commission`, `created_at`, `duration`, `start_date`, `status`, `updated_at`, `client_id`, `owner_id`, `property_id`) VALUES
(1, 3200, '2020-06-28', NULL, '2020-06-28', 'Complete', '2020-07-02', 1, 1, 1),
(2, 420, '2020-07-02', 24, '2020-08-02', 'Pending', '2020-07-02', 2, 2, 8),
(4, 550, '2020-07-03', NULL, '2020-07-31', 'Complete', '2020-07-03', 14, 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `position` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `resign_date` date DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `address`, `avatar`, `birthdate`, `email`, `fullname`, `join_date`, `phone`, `position`, `resign_date`, `salary`, `status`) VALUES
(1, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user1-128x128.jpg', '1992-02-16', 'viettdd00692@fpt.edu.vn', 'Trần Đức Việt', '2016-06-20', '0983005335', 'Quản lý', NULL, 15000000, 'Standby'),
(2, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user8-128x128.jpg', '1994-01-01', 'nghiadtd00712@fpt.edu.vn', 'Đinh Tuấn Nghĩa', '2020-07-01', '0948686895', 'Nhân viên', NULL, 5000000, 'Active'),
(3, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user6-128x128.jpg', '1995-01-01', 'quydcd00783@fpt.edu.vn', 'Đinh Công Quý', '2020-07-01', '0983005335', 'Nhân viên', NULL, 4000000, 'Standby'),
(4, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user1-128x128.jpg', '1995-01-01', 'anhtdd00756@fpt.edu.vn', 'Trần Đức Anh', '2020-07-02', '0964597776', 'Nhân viên', NULL, 1000000, 'Standby'),
(5, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user2-160x160.jpg', '1995-01-01', 'hungndd00733@fpt.edu.vn', 'Nguyễn Đức Hùng', '2020-07-02', '0393064417', 'Nhân viên', NULL, 6000000, 'Standby'),
(6, 'Số 8, Tôn Thất Thuyết, Mỹ Đình, Từ Liêm, Hà Nội', 'user6-128x128.jpg', '1996-01-01', 'congncd00695@fpt.edu.vn', 'Nguyễn Chí Công', '2020-07-02', '0976701141', 'Thực tập', NULL, 500000, 'Standby');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `property_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `image`
--

INSERT INTO `image` (`id`, `image`, `property_id`) VALUES
(1, 'chung-cu-the-pride-1.jpg', 12),
(2, 'chung-cu-the-pride-2.jpg', 12),
(3, 'tap-the-thanh-cong-quan-ba-dinh-1.jpg', 11),
(4, 'chung-cu-the-pride-2.jpg', 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `owner`
--

CREATE TABLE `owner` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `owner`
--

INSERT INTO `owner` (`id`, `address`, `created_at`, `email`, `fullname`, `phone`, `status`, `updated_at`) VALUES
(1, 'Số 61 Trần Hữu Tước, Đống Đa, Hà Nội', '2020-06-30', 'nguyenleminh@gmail.com', 'Nguyễn Lê Minh', '0908955131', 'Onsales', '2020-06-30'),
(2, '424 Thụy Khuê, quận Tây Hồ, Hà Nội', '2020-07-01', 'dangngocquang@gmail.com', 'Đặng Ngọc Quang', '0978198489', 'Onsales', '2020-07-01'),
(3, '99A, phố Tam Khương, Đống Đa, Hà Nội', '2020-07-03', 'tdviet01@gmail.com', 'Nguyễn Kim Hồng', '0983005335', 'Waiting', '2020-07-03');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `property`
--

CREATE TABLE `property` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `bathroom` int(11) DEFAULT NULL,
  `bedroom` int(11) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `option` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `thumbnail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `property`
--

INSERT INTO `property` (`id`, `address`, `area`, `bathroom`, `bedroom`, `created_at`, `description`, `name`, `option`, `price`, `rate`, `status`, `thumbnail`, `type`, `updated_at`, `owner_id`) VALUES
(1, '331/38/2, Phan Huy Ích, Phường 14, Quận Gò Vấp', 64, 5, 4, '2020-06-23', 'Chính chủ cần bán gấp nhà có sổ hồng riêng tại Gò Vấp-TPHCM\r\nLiên hệ: 0908.053.234 - anh Tuấn\r\nDiện tích: 64m2 (4x16m)\r\nGiá: 7,45 tỷ\r\nNhà đúc + 1 trệt + 1 lửng + 2 lầu + sân thượng\r\nGồm: 4 phòng ngủ (có toilet riêng) + 5 toilet + phòng giặt + phòng thờ\r\nSấn thượng trước sau, nôi tất cao cấp, của gỗ căm xe\r\nTay vịn cầm thay gỗ căm xe, kính cường lực 10kg\r\nNhà được kiến trúc sư thiết kế cực đẹp, Mẫu mới 2019\r\n\r\nCông năng + phong thủy chuẩn\r\nKhu nhà lầu dân trí cao, đường rộng 6m xe hơi vào trong nhà, cách Phan Huy Ích 80m\r\nGiao thông tiện ích thuận lợi (Xem nhà ưng liền)\r\nPháp lí: Có sổ hồng riêng\r\nĐịa chỉ: 331/38/2 Phan Huy Ích, Phường 14, Gò Vấp, TPHCM', 'Nhà 4 Phòng Ngủ Tại Quận Gò Vấp', 'Mua', 32000, 10, 'Sold', 'nha4phongngu.jpg', 'Nhà riêng', '2020-07-02', 1),
(2, '346 Bến Vân Đồn, Phường 1, quận 4', 80, 2, 2, '2020-06-23', 'Căn hộ gold view quận 4 tọa lạc tại 346 Bến Vân Đồn, Phường 1, quận 4, 1 trong 4 quận trung tâm của thành phố, cách chợ Bến Thành vài phút di chuyển qua Cầu Ông Lãnh, là cửa ngõ dẫn vào khu đô thị Nam Sài Gòn thông qua cầu Kênh Tẻ, nhanh chóng di chuyển qua quận 5 bằng cầu Nguyễn Văn Cừ hoặc chỉ vài phút là đến hầm Thủ Thiêm để đến Mai Chí Thọ quận 2.', 'Căn Hộ 2 Phòng Ngủ Tại Quận 4', 'Mua', 11000, 5, 'Negotiation', 'canho2phongngu.jpg', 'Căn hộ', '2020-07-01', 1),
(3, 'Đường Thụy Khuê, Phường Thụy Khuê, Quận Tây Hồ, Hà Nội', 64, 5, 4, '2020-06-23', 'nhà riêng ngõ 460 Thụy Khuê, Bưởi, Q.Tây Hồ, Hà Nội\r\ndiện tích : 30m2x5,5 tầng\r\nthiết kế : tầng 2-3-4-5 mỗi tầng 1 phòng ngủ + vs, tầng 1 khách, bếp, vs\r\nnội thất : full đồ\r\ngiá thuê : 9 triệu / tháng\r\n+ không mất phí trung gian - gọi trực tiếp hạn chế nhắn tin\r\n+ hợp đồng dài hạn 1 năm trở lên\r\n+ thanh toán tối thiểu 3 tháng đặt cọc 1 tháng', 'Nhà riêng ngõ 460 Thụy Khuê', 'Thuê', 390, 1, 'Available', 'nha-rieng-ngo-460-thuy-khue.jpg', 'Nhà riêng', '2020-07-03', 1),
(4, 'Đường Phạm Hùng, Phường Mỹ Đình 1, Quận Nam Từ Liêm, Hà Nội', 80, 2, 2, '2020-06-23', 'Cho thuê căn hộ Vinhomes Skylake 2N full đồ\r\n- Căn hộ đã được trang bị nội thất đầy đủ: Sàn gỗ, tivi, tủ lạnh, điều hòa, giường, tủ đồ, bàn ăn nhà bếp, hệ thống tủ bếp, máy giặt, bình nóng lạnh, thiết bị vệ sinh...\r\n* Giá thuê 18 triệu/tháng.\r\n+ Nhà đang trống, vào ở luôn.\r\n+ Cho người Việt hoặc người nước ngoài đều được chào đón.\r\n+ Đăng ký tạm trú + thẻ cử dân cho người thuê đầy đủ.', 'Chung cư Vinhomes Skylake', 'Thuê', 780, 2, 'Negotiation', 'chung-cu-vinhomes-skylake.jpg', 'Căn hộ', '2020-07-03', 1),
(5, 'Hồng Tiến, Phường Bồ Đề, Quận Long Biên, Hà Nội', 32, 4, 4, '2020-06-29', 'Bán nhà 6 tầng :\r\n+ Diện tích 32 m2....MT 4m\r\n+ Địa chỉ . Bồ Đề, Long Biên -Hà Nội\r\n+ Diện tích 32m2 . Mặt tiền 4m.\r\n+ Có 1PK ,4PN ,4WC.\r\n+ Sàn gỗ Malaysia nhập khẩu .\r\n+ Cửa và tay vịn cầu thang được làm từ gỗ lim nam phi.\r\n+ Mái bắn tôn lạnh chống nóng.\r\n+ Thiết bị vệ sinh cao cấp TOTO.\r\n+ Ngõ rộng 4 m\r\n+ Nhà Hướng Tây Tứ Trạch.\r\n----------------\r\n+ Cách cầu Chhương Dương 300m,\r\n+ Gần trường Quốc Tế - Bệnh viện Tâm Anh.\r\n+ Trường mầm non , cấp 1,2 Bồ Đề.\r\n..................\r\n+ Giá Chốt Bán 3.2 tỷ VNĐ.\r\n+ Sổ đỏ chính chủ ( Bao phí sang tên )\r\n+ Ngân hàng hỗ trợ 75% GTCN .\r\n+ Trả góp trong vòng 25 năm.', 'Bán nhà phố Bố Đề', 'Mua', 140000, 10, 'Negotiation', 'ban-nha-pho-bo-de-hong-tien.jpg', 'Nhà riêng', '2020-07-01', 1),
(6, 'Đường Cầu Am, Phường Vạn Phúc, Quận Hà Đông, Hà Nội', 31, 4, 4, '2020-06-29', 'Nhà xây mới 5 tầng Vạn Phúc, Hà Đông, 3PN, full nội thất,\r\n\r\n- Diện tích: 31m2.\r\n- Mặt tiền: 3.5m.\r\n- Hướng: Tây Nam (có căn Đông Nam).\r\n- Thiết kế 5 tầng:\r\n+ Tầng 1: Phòng khách, bếp, nhà vệ sinh.\r\n+ Tầng 2,3,4: Mỗi tầng 1 phòng ngủ, nhà vệ sinh.\r\n+ Tầng 5: Phòng thờ, sân phơi.\r\n- Nội thất: Thiết bị nội thất cơ bản như: Tủ bếp, cửa và cầu thang làm bằng gỗ lim nguyên khối, cửa sổ nhôm Xingfa, thiết bị vệ sinh cao cấp...\r\n- Vị trí: Nhà ngay chân Cầu Am - Vạn Phúc. Thuộc khu trung tâm quận Hà Đông, xung quanh tiện ích đầy đủ, giao thông thuận tiện đi các phố Tố hữu, Ngô Quyền, Quang Trung...\r\n- Sổ đỏ chính chủ + GPXD.\r\n- Giá: 2,25 tỷ (có thương lượng).', 'Nhà Mới 7 Ngõ 4/16 Cầu Am', 'Mua', 98000, 5, 'Available', 'nha-moi-7-ngo-4-16-cau-am.jpg', 'Nhà riêng', '2020-07-03', 1),
(7, 'ngõ 1, Đường Võ Chí Công, Phường Nghĩa Đô, Quận Cầu Giấy, Hà Nội', 32, 3, 3, '2020-06-29', 'Cần bán nhà ngõ 1, Võ Chí Công.\r\nNhà mt rộng, vuông vắn, có sân chung để xe, từ nhà ra phố 60m.\r\nNhà thiết kế 5 tầng: Tầng 1, khách\r\nTầng: 2,3,4 mỗi tầng 1 phòng.\r\nTầng 5: phòng thờ + sân phơi.\r\nNhà xây chăc chắn, khu dân cư an ninh tốt', 'Bán nhà ngõ 1, Võ Chí Công', 'Mua', 160000, 10, 'Available', 'ban-nha-ngo-1-vo-chi-cong.jpg', 'Nhà riêng', '2020-07-01', 2),
(8, '14, Đường Phạm Ngọc Thạch, Phường Quang Trung, Quận Đống Đa, Hà Nội', 15, 1, 1, '2020-06-29', 'Cho thuê nhà khép kín 2 tầng DTSD 24m2,đầy đủ điều hoà nóng lạnh.\r\nTầng 1 bếp+nhà vs\r\nTầng 2 phòng ngủ\r\nRất phù hợp cho gia đình nhỏ\r\nRiêng biệt đi khoá về mở.', 'Cho thuê nhà riêng 2 tầng', 'Thuê', 140, NULL, 'Negotiation', 'cho-thue-nha-rieng-2.jpg', 'Nhà riêng', '2020-07-02', 2),
(9, 'Đường Cổ Nhuế, Phường Cổ Nhuế 1, Quận Bắc Từ Liêm, Hà Nội', 6, 3, 4, '2020-07-01', '1. Thông tin căn hộ\r\n- Diện tích sàn xây dựng 52 ( 60m2 ) m2*4tầng.\r\n- Sân trước rộng 3 m2.\r\n- Mặt tiền : 4m\r\n2. Thiết kế căn hộ\r\n- Nhà thiết kế 4pn .\r\n- T1 : Nhà bếp , nhà khách\r\n- T2 : 2 ngủ , 1vs\r\n- T3 : 2 ngủ , 1 vs\r\n- T4 : sân phơi , phòng thờ\r\n3. Nội thất :\r\n- Tủ bếp , 1 điều hoà , nóng lạnh , tủ lạnh , giường , tủ quần áo , bàn làm việc .... gần như đã full đồ chỉ\r\n4. Thông tin thêm\r\n- Ngõ thông , khu dân cư yên tĩnh\r\n- An ninh đảm bảo\r\n- Phù hợp cho hộ gia đình , người đi làm', 'Nhà ngõ Cổ nhuế giá rẻ 4 ngủ', 'Thuê', 370, NULL, 'Available', 'nha-ngo-co-nhue-4-phong-ngu.jpg', 'Nhà riêng', '2020-07-01', 2),
(10, 'Đường Đỗ Quang, Phường Trung Hoà, Quận Cầu Giấy, Hà Nội', 40, 1, 1, '2020-07-01', 'CHO THUÊ MBKD\r\n-ĐC: ngõ Đỗ Quang, Đường Đỗ Quang, Phường Trung Hoà, Quận Cầu Giấy.\r\n- S=40M2\r\n- Nội thất: cơ bản. Nhà mới sửa lại sạch đẹp,thông phòng.\r\n- Cho thuê tầng 1 trong nhà 5 tầng, có thể ở lại, lối đi chung.\r\n- Vị trí: đường rộng, khu phố sầm uất, đông dân, hợp mọi loại hình kinh doanh.\r\n- Phù hợp: làm văn phòng hoặc mặt bằng kinh doanh….trừ hàng ăn\r\n- Gía: 10,5Tr/tháng. Tt 3th cọc 1\r\n-Xem nhà Chốt luôn Báo D trước 60p Là E giúp KM làm nghề ạ.', 'Cho thuê Mặt bằng Kinh Doanh phố Đỗ Quang', 'Thuê', 450, NULL, 'Available', 'mat-bang-kinh-doanh-pho-do-quang.jpg', 'Nhà riêng', '2020-07-02', 2),
(11, '512, Đường Nguyên Hồng, Phường Thành Công, Quận Ba Đình, Hà Nội', 98, 2, 3, '2020-07-01', 'Bán nhà tập thể, địa chỉ tầng 5 nhà G4 tập thể Thành Công, Ba Đình, Hà Nội.\r\n\r\nDiện tích sử dụng 98m2 (Tầng5 47m2 - tầng 6 50m2). Thích hợp cho gia đình đông người ở. Sổ đỏ chính chủ. Thiết kế hợp lý. Nhà hướng Đông Nam,\r\n\r\nCác tiện ích:Khu Ngoại giao dân chí cao.An ninh tốt.Mặt trước nhà thoáng mát,Nhìn thẳng ra hồ thành công. Nhà ở vị trí cao trong khu nên đi từ nhà ra đường Láng Hạ không bị ngập nước khi có lụt. Điện nước ổn định.(Nhà đã cải tao lại toàn bộ nên rất đẹp)', 'Tập thể Thành Công quận Ba Đình', 'Mua', 105000, 5, 'Appraise', 'tap-the-thanh-cong-quan-ba-dinh.jpg', 'Căn hộ', '2020-07-02', 2),
(12, 'Đường Lê Văn Lương, Phường La Khê, Quận Hà Đông, Hà Nội', 90, 2, 3, '2020-07-01', 'Bán căn hộ Tòa CT3 The Pride Hà Đông, Hà Nội\r\n\r\nDiện tích: 90.02 m2 thông thủy, 94m2 tim tường\r\n\r\nHướng Cửa : Tây Nam Hướng Ban công: Đông Bắc\r\n\r\nThông số căn hộ: 3 pn, 2 wc, phòng khách + ban rộng rộng\r\n\r\nNội thất để lại: full nội thất, mang đi mỗi ti vi và tủ lạnh', 'Chung cư The Pride', 'Mua', 84800, 10, 'Appraise', 'chung-cu-the-pride.jpg', 'Căn hộ', '2020-07-02', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
(1, '123', 'ROLE_ADMIN', 'admin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1by1odt9gutcjgipuq0ovvv91` (`employee_id`),
  ADD KEY `FKegubqo99cojx5k1wrw0d4nlbt` (`property_id`);

--
-- Chỉ mục cho bảng `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlhq3p3xl25vvnfvyfc51ica0j` (`client_id`),
  ADD KEY `FKtb4w34w5hsk3yh5yblhwp9mcc` (`owner_id`),
  ADD KEY `FK1xiqa4m8b476yv75ivbqqkrjw` (`property_id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6oqm8c6mg2dgedoppcbu8sm5q` (`property_id`);

--
-- Chỉ mục cho bảng `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj2cohq7sjhdetbls088cupcu3` (`owner_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `contract`
--
ALTER TABLE `contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `owner`
--
ALTER TABLE `owner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `property`
--
ALTER TABLE `property`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK1by1odt9gutcjgipuq0ovvv91` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKegubqo99cojx5k1wrw0d4nlbt` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`);

--
-- Các ràng buộc cho bảng `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `FK1xiqa4m8b476yv75ivbqqkrjw` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
  ADD CONSTRAINT `FKlhq3p3xl25vvnfvyfc51ica0j` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKtb4w34w5hsk3yh5yblhwp9mcc` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`);

--
-- Các ràng buộc cho bảng `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FK6oqm8c6mg2dgedoppcbu8sm5q` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`);

--
-- Các ràng buộc cho bảng `property`
--
ALTER TABLE `property`
  ADD CONSTRAINT `FKj2cohq7sjhdetbls088cupcu3` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
