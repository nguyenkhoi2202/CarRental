USE [CarRental]
GO
/****** Object:  Table [dbo].[tblCars]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCars](
	[carID] [varchar](50) NOT NULL,
	[carName] [nvarchar](100) NOT NULL,
	[imageSrc] [nvarchar](4000) NOT NULL,
	[color] [nvarchar](50) NOT NULL,
	[year] [varchar](10) NOT NULL,
	[categoryID] [varchar](10) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[description] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[carID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCategoris]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategoris](
	[categoryID] [varchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDiscounts]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDiscounts](
	[discount] [varchar](50) NOT NULL,
	[dateEnd] [date] NULL,
 CONSTRAINT [PK_tblDiscounts] PRIMARY KEY CLUSTERED 
(
	[discount] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblPayPal]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPayPal](
	[userName] [varchar](50) NOT NULL,
	[dateBuy] [varchar](50) NULL,
	[price] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRates]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRates](
	[userName] [nvarchar](50) NULL,
	[carName] [varchar](50) NULL,
	[rate] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRentalDetails]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRentalDetails](
	[detailID] [int] IDENTITY(1,1) NOT NULL,
	[rentalID] [int] NULL,
	[carID] [varchar](50) NULL,
	[carName] [varchar](50) NULL,
	[quantity] [int] NULL,
	[price] [float] NULL,
 CONSTRAINT [PK__tblRenta__83077839B0215D05] PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRentals]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRentals](
	[rentalID] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](50) NULL,
	[totalPrice] [float] NULL,
	[checkin] [date] NULL,
	[checkout] [date] NULL,
	[bookDate] [varchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK__tblRenta__016470CE5BF30A65] PRIMARY KEY CLUSTERED 
(
	[rentalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [varchar](10) NOT NULL,
	[roleName] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 3/19/2021 12:57:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userName] [nvarchar](50) NOT NULL,
	[password] [varchar](100) NULL,
	[email] [varchar](200) NULL,
	[name] [nvarchar](200) NULL,
	[phone] [varchar](20) NULL,
	[address] [nvarchar](300) NULL,
	[status] [bit] NULL,
	[roleID] [varchar](10) NULL,
	[createDate] [date] NULL,
 CONSTRAINT [PK__tblUsers__66DCF95D6345F972] PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'1', N'Civic', N'./image/civic.jfif', N'red', N'2020', N'H', 25, 5, N'Honda Civic 1.5 Turbo 2020 sở hữu kích thước Dài x Rộng x Cao lần lượt là: 4648 x 1799 x 1416 (mm). Xe có khoảng sáng gầm xe 133mm và chiều dài cơ sở 2700mm. Honda Civic 2020 là dòng xe có kích thước lớn nhất phân khúc C hiện nay. Chính vì vậy đây là mẫu xe được người dùng đánh giá cao về độ rộng rãi của nội thất và cảm giác thoải mái khi vận hành.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'10', N'Bidio', N'./image/Honda-Birio.jpg', N'red', N'2019', N'H', 30, 6, N'Honda Brio 2019 vừa được ra mắt tại thị trường Việt Nam vào ngày 18/06/2019 với 3 phiên bản có mức giá từ 418 – 454 triệu đồng. Honda Brio (hay Honda Burio, Honda Brio Satya) là mẫu xe hạng nhỏ dành cho thành thị (city car) của hãng xe Honda, Nhật Bản.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'11', N'Ghost', N'./image/rollroyceghost.jpg', N'grey', N'2020', N'RR', 100, 5, N'Ghost Series II được đưa về Việt Nam với 2 tông màu Đen – Bạc rất ấn tượng. Diện mạo bên ngoài của Ghost Series II tươi trẻ và “đáng yêu” hơn rất nhiều, khác với diện mạo sang trọng “khó tiếp cận” như thông thường nhờ những cải tiến đáng kể ở đầu xe và thân xe.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'2', N'Roll Royce', N'./image/rollroyce.jfif', N'black', N'2019', N'RR', 150, 8, N'Black Bagde là phiên bản bespoke được ra mắt vào năm 2016, và trở thành tùy chọn có sẵn trong dải sản phẩm của Rolls-Royce. Hiện Black Badge chỉ áp dụng trên 4 mẫu xe: Cullinan, Ghost, Wraith và Dawn. Tại Việt Nam, chỉ dòng Ghost và Wraith Black Badge được nhập về, số lượng đếm trên đầu ngón tay. Chiếc Ghost Black Badge về nước từ 2018, của một showroom tại Hà Nội.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'3', N' Accord ', N'./image/honda-accord.jpg', N'while', N'2020', N'H', 35, 9, N'Honda Accord là mẫu Sedan 5 chỗ ra mắt lần đầu tiên vào năm 1976. Cho tới nay, Honda đã bán được hơn 13 triệu sản phẩm này trên toàn thế giới. Con số không phải là quá lớn nhưng cũng đủ để chúng ta thấy vị thế vững vàng của Accord. ')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'4', N'City', N'./image/city.jpg', N'black', N'2019', N'H', 26, 12, N'Tiếp nối thành công của City các thế hệ trước, tháng 11/2019, Honda City thế hệ thứ 5 được ra mắt lần đầu tiên trên thế giới tại thị trường Thái Lan đã nhanh chóng khẳng định vị thế dẫn đầu với doanh số đạt 39% thị phần trong phân khúc B (dữ liệu trong nửa đầu năm 2020) và trở thành mẫu xe bán chạy nhất của Honda Thái Lan.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'5', N'CR-V', N'./image/honda-cr-v-2020.jpg', N'Blue', N'2020', N'H', 40, 13, N'Không gian xe rộng rãi thoải mái để mọi trải nghiệm hành trình luôn tuyệt vời.

Ở bên trong, nội thất của Honda CR-V 2020 không khác biệt nhiều so với đời trước. Tuy nhiên, hãng xe Nhật đã thiết kế lại bảng điều khiển trung tâm, hộc đựng đồ rộng rãi hơn và các cổng kết nối USB được bố trí cao hơn.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'6', N'Rolls-Royce Cullinan', N'./image/RollroyceCuli.jpg', N'Black', N'2020', N'RR', 200, 10, N'Trên phiên bản Black Badge, Rolls-Royce vẫn cung cấp cho Cullinan danh sách đầy đủ 44.000 màu sơn khác nhau. ')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'7', N'BMW I8', N'./image/BMWi8.jpg', N'Grey', N'2019', N'BMW', 60, 9, N'BMW i8 là siêu xe thể thao hybrid có thiết kế cực đẹp, được thương hiệu xe Đức giới thiệu vào hồi tháng 6/2014. Hiện tại, i8 BMW đang được phân phối chính thức tại hơn 50 thị trường nhưng không có Việt Nam. Khách hàng tại Việt Nam có nhu cầu mua xe BMW i8 chỉ có thể liên hệ với các đơn vị kinh doanh xe nhập khẩu tư nhân để đặt cọc. Vậy giá xe BMW i8 là bao nhiêu? Cùng tìm hiểu trong bài viết dưới đây.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'8', N'BMW X7', N'./image/BMW-X7.jpg', N'While', N'2020', N'BMW', 50, 9, N'BMW X7 là mẫu SUV thể thao cỡ lớn hạng sang (Luxury Sport Utility Vehicle) hoàn toàn mới của hãng xe BMW, Đức. X7 bản thương mại đã chính thức ra mắt vào tháng 10/2018. Dự án X7 được BMW tiết lộ lần đầu tiên vào tháng 03/2014. Sau đó, giới mộ điệu đã được chiêm ngưỡng ý tưởng này bằng một bản Concept X7 iperformance tại Triển lãm ô tô quốc tế Frankfurt 2017.')
INSERT [dbo].[tblCars] ([carID], [carName], [imageSrc], [color], [year], [categoryID], [price], [quantity], [description]) VALUES (N'9', N'BMW 320i', N'./image/bmw-320i.jpg', N'red', N'2017', N'BMW', 45, 8, N'BMW 320i GT 2017 sở hữu ngoại hình khá thể thao dù thuộc dòng sedan. Đầu xe vẫn là cụm lưới tản nhiệt hình quả thận viền chrome đặc trưng của hãng, nối với cụm đèn pha Adaptive LED tạo nên tổng thể cuốn hút. Bên dưới là hốc gió tích hợp với cản trước và tích hợp đèn sương mù. Phần đuôi xe là cụm đèn hậu nằm ngang, ôm gọn phần đuôi cùng ống xả kép dạng tròn.')
GO
INSERT [dbo].[tblCategoris] ([categoryID], [categoryName]) VALUES (N'BMW', N'BMW')
INSERT [dbo].[tblCategoris] ([categoryID], [categoryName]) VALUES (N'H', N'Honda')
INSERT [dbo].[tblCategoris] ([categoryID], [categoryName]) VALUES (N'RR', N'Roll Royce')
GO
INSERT [dbo].[tblDiscounts] ([discount], [dateEnd]) VALUES (N'2202', CAST(N'2021-05-06' AS Date))
INSERT [dbo].[tblDiscounts] ([discount], [dateEnd]) VALUES (N'ahihi', CAST(N'2021-04-04' AS Date))
GO
INSERT [dbo].[tblPayPal] ([userName], [dateBuy], [price]) VALUES (N'khoi2202', N'20210317194904', 432)
INSERT [dbo].[tblPayPal] ([userName], [dateBuy], [price]) VALUES (N'nhanqt', N'20210318090230', 720)
GO
INSERT [dbo].[tblRates] ([userName], [carName], [rate]) VALUES (N'khoi2202', N' Ghost', N'7')
INSERT [dbo].[tblRates] ([userName], [carName], [rate]) VALUES (N'khoi2202', N' BMW X7', N'10')
INSERT [dbo].[tblRates] ([userName], [carName], [rate]) VALUES (N'khoi2202', N' CR-V', N'7')
GO
SET IDENTITY_INSERT [dbo].[tblRentalDetails] ON 

INSERT [dbo].[tblRentalDetails] ([detailID], [rentalID], [carID], [carName], [quantity], [price]) VALUES (29, 37, N'5', N'CR-V', 1, 40)
INSERT [dbo].[tblRentalDetails] ([detailID], [rentalID], [carID], [carName], [quantity], [price]) VALUES (30, 37, N'6', N'Rolls-Royce Cullinan', 1, 200)
INSERT [dbo].[tblRentalDetails] ([detailID], [rentalID], [carID], [carName], [quantity], [price]) VALUES (31, 38, N'11', N'Ghost', 2, 100)
SET IDENTITY_INSERT [dbo].[tblRentalDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[tblRentals] ON 

INSERT [dbo].[tblRentals] ([rentalID], [userName], [totalPrice], [checkin], [checkout], [bookDate], [status]) VALUES (37, N'khoi2202', 432, CAST(N'2021-03-18' AS Date), CAST(N'2021-03-20' AS Date), N'2', 1)
INSERT [dbo].[tblRentals] ([rentalID], [userName], [totalPrice], [checkin], [checkout], [bookDate], [status]) VALUES (38, N'nhanqt', 720, CAST(N'2021-03-19' AS Date), CAST(N'2021-03-23' AS Date), N'4', 1)
SET IDENTITY_INSERT [dbo].[tblRentals] OFF
GO
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'admin', N'admin')
INSERT [dbo].[tblRoles] ([roleID], [roleName]) VALUES (N'user', N'user')
GO
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'admin', N'1', N'admin@gmail.com', N'admin', N'00000000', N'america', 1, N'admin', CAST(N'2021-03-02' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'huynhphi', N'1', N'huynh@gmail.com', N'Huynh Phi', N'0354896428', N'Binh thuan', 1, N'user', CAST(N'2021-03-11' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'khoi2202', N'1', N'khoi@gmail.com', N'khoi tran', N'0942691091', N'daklak', 1, N'user', CAST(N'2021-03-03' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'lam', N'1', N'lamdntse140089@fpt.edu.vn', N'lam do', N'987654', N'sdujdnv', 0, N'user', CAST(N'2021-03-16' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'Nguyên Khôi', NULL, NULL, N'Nguyên Khôi', NULL, NULL, 1, N'user', CAST(N'2021-03-16' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'nhan', N'1', N'khoitnse141108@fpt.edu.vn', N'nhan quang trong', N'0987654321', N'go vap', 1, N'user', CAST(N'2021-03-18' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'nhanqt', N'1', N'nhanqtse140052', N'nhan quang trong', N'0987654321', N'cu bao', 0, N'user', CAST(N'2021-03-18' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'quang', N'1', N'quangnvse140025@fpt.edu.vn', N'qunag lol', N'0987654', N'hcm', 0, N'user', CAST(N'2021-03-12' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'triet', N'1', N'trietmnse141098', N'minh triet', N'0987654', N'go vap', 0, N'user', CAST(N'2021-03-17' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'triet1', N'1', N'trietnmse141098@fpt.edu.vn', N'kjghfd', N'09876543', N'hcm', 1, N'user', CAST(N'2021-03-17' AS Date))
INSERT [dbo].[tblUsers] ([userName], [password], [email], [name], [phone], [address], [status], [roleID], [createDate]) VALUES (N'triet123', N'1', N'trietmnse141098@fpt.edu.vn', N'triet minh', N'0987654321', N'hcm', 0, N'user', CAST(N'2021-03-17' AS Date))
GO
ALTER TABLE [dbo].[tblUsers] ADD  CONSTRAINT [DF__tblUsers__status__24927208]  DEFAULT ((0)) FOR [status]
GO
ALTER TABLE [dbo].[tblCars]  WITH CHECK ADD  CONSTRAINT [ADD2] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategoris] ([categoryID])
GO
ALTER TABLE [dbo].[tblCars] CHECK CONSTRAINT [ADD2]
GO
ALTER TABLE [dbo].[tblRentalDetails]  WITH CHECK ADD  CONSTRAINT [ADD4] FOREIGN KEY([rentalID])
REFERENCES [dbo].[tblRentals] ([rentalID])
GO
ALTER TABLE [dbo].[tblRentalDetails] CHECK CONSTRAINT [ADD4]
GO
ALTER TABLE [dbo].[tblRentals]  WITH CHECK ADD  CONSTRAINT [ADD3] FOREIGN KEY([userName])
REFERENCES [dbo].[tblUsers] ([userName])
GO
ALTER TABLE [dbo].[tblRentals] CHECK CONSTRAINT [ADD3]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [ADD1] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [ADD1]
GO
