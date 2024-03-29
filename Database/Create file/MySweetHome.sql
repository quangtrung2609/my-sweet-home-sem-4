CREATE DATABASE MySweetHome

drop database MySweetHome

USE MySweetHome

--use master 
------------------TypeOfMember-------------------------
CREATE TABLE TypeOfMember
(
	TypeOfMemberID nvarchar(30) constraint TypeOfMember_PK primary key,
	TypeName nvarchar(200)
)

delete from TypeOfMember
INSERT INTO TypeOfMember VALUES ('1','Seller')
INSERT INTO TypeOfMember VALUES ('2','Buyer')
select * from TypeOfMember
------------------MEMBER-------------------------
CREATE TABLE Member
(
	UserName nvarchar(100) constraint Member_PK primary key,
	Password nvarchar(100),
	Email nvarchar(100),	
	Full_Name nvarchar(200),
	Date_Of_Birth nvarchar(20),
	Gender nvarchar(30),
	Address nvarchar(200),
	Telephone nvarchar(50),
	Company nvarchar(50),
	Is_Enabled nvarchar(10),
	Code nvarchar(100),
	ImageUrl nvarchar(250),
	Role nvarchar(10),
	Type_Of_Member_ID nvarchar(30) constraint Member_TypeOfMember_fk foreign key (Type_Of_Member_ID) references TypeOfMember (TypeOfMemberID)
)
INSERT INTO Member VALUES ('quanghuy','827ccb0eea8a706c4c34a16891f84e7b','qhuy@gmail.com','Ngo Quang Huy','11/11/1989','Male','12 Hai Ho','0905123456','GCafe','true','Z2CQKOGWWalakS24SLap1iHXIon8EI','','Admin','1')
INSERT INTO Member VALUES ('vulong','827ccb0eea8a706c4c34a16891f84e7b','vlong@gmail.com','Vu Long','11/12/1989','Male','13 Hai Ho','0905123123','GCafe','true','Z2CQKOGWWalakS24SLap1iHXIon8EI','','Member','2')
INSERT INTO Member VALUES ('quangvinh','827ccb0eea8a706c4c34a16891f84e7b','qvinh@gmail.com','Huynh Quang Vinh','10/10/1989','Male','15 Hai Ho','0905123654','GCafe','true','Z2CQKOGWWalakS24SLap1iHXIon8EI','','Admin','1')
INSERT INTO Member VALUES ('anhtan','827ccb0eea8a706c4c34a16891f84e7b','atan@gmail.com','Nguyen Anh Tan','05/11/1989','Male','14 Hai Ho','0905123789','GCafe','true','Z2CQKOGWWalakS24SLap1iHXIon8EI','','Member','2')
INSERT INTO Member VALUES ('xuantrung','827ccb0eea8a706c4c34a16891f84e7b','xtrung@gmail.com','Le Xuan Trung','09/11/1989','Male','16 Hai Ho','0905123888','GCafe','true','Z2CQKOGWWalakS24SLap1iHXIon8EI','','Member','2')

select * from Member

--TypeOfEstate is: rent or sell
------------------TypeOfEstate-------------------------
CREATE TABLE TypeOfEstate
(
	TypeOfEstate_ID nvarchar(30) constraint TypeOfEstate_pk primary key,
	TypeOfEstate_Name nvarchar(200)
)

select * from TypeOfEstate
delete from TypeOfEstate

INSERT INTO TypeOfEstate VALUES ('1','For Sell')
INSERT INTO TypeOfEstate VALUES ('2','For Rent')


------------------Category-------------------------
CREATE TABLE Category
(
	Category_ID nvarchar(30) constraint Category_pk primary key,
	Category_Name nvarchar(200)
)
select * from Category

INSERT INTO Category VALUES ('1', 'Residential Land')
INSERT INTO Category VALUES ('2', 'Commercial')
INSERT INTO Category VALUES ('3', 'Condominium')
INSERT INTO Category VALUES ('4', 'Townhouse')
INSERT INTO Category VALUES ('5', 'Multi-unit dwelling')

------------------Subscribe-------------------------
CREATE TABLE Subscribe
(
	Subscribe_ID nvarchar(30) constraint Subscribe_pk primary key,
	Subscribe_Name nvarchar(100),
	Fee_Per_Day nvarchar(20)
)
delete from Subscribe

INSERT INTO Subscribe VALUES ('1', 'Vip1', '1')
INSERT INTO Subscribe VALUES ('2', 'Vip2', '2')
INSERT INTO Subscribe VALUES ('3', 'Vip3', '3')

------------------City-------------------------
CREATE TABLE City
(
	City_ID nvarchar(30) constraint City_pk primary key,
	City_Name nvarchar(200)
)
delete from City

INSERT INTO City VALUES ('1','Ha Noi')
INSERT INTO City VALUES ('2','Ho Chi Minh')
INSERT INTO City VALUES ('3','Da Nang')


------------------District-------------------------
CREATE TABLE District
(
	District_ID nvarchar(30) constraint District_pk primary key,
	District_Name nvarchar(200),
	City_ID nvarchar(30) constraint City_District_fk foreign key (City_ID) references City (City_ID)
)

delete from District
select * from District

INSERT INTO District VALUES ('1','Hoan Kiem','1')
INSERT INTO District VALUES ('2','Hai Ba Trung','1')
INSERT INTO District VALUES ('3','Ba Dinh','1')

INSERT INTO District VALUES ('4','Tan Binh','2')
INSERT INTO District VALUES ('5','Thu Duc','2')
INSERT INTO District VALUES ('6','Go Vap','2')

INSERT INTO District VALUES ('7','Thanh Khe','3')
INSERT INTO District VALUES ('8','Hai Chau','3')
INSERT INTO District VALUES ('9','Lien Chieu','3')


------------------Currency-------------------------
CREATE TABLE Currency
(
	Currency_ID nvarchar(30) constraint Currency_pk primary key,
	Currency_Name nvarchar(200),
	--ti gia so voi dong viet nam (vd 1 USD = 20800 VND)
	VND_Rate nvarchar(20)
)
delete from Currency

INSERT INTO Currency VALUES ('1','USD','20800')
INSERT INTO Currency VALUES ('2','EUR','25460')
INSERT INTO Currency VALUES ('3','GBP','32391')
INSERT INTO Currency VALUES ('4','JPY','263')
INSERT INTO Currency VALUES ('5','RUB','597')
INSERT INTO Currency VALUES ('6','VND','1')

------------------Estate-------------------------
CREATE TABLE Estate
(
	Estate_ID nvarchar(30) constraint Estate_pk primary key,
	Estate_Title nvarchar(300),
	Estate_Start_Day nvarchar(15),
	Estate_End_Day nvarchar(15),
	Estate_Address nvarchar(200),
	Estate_Content nvarchar(max),
	Estate_Area nvarchar(50),
	Estate_Value nvarchar(30),
	--Estate_Driveway : duong truoc nha (3m, 5m, 10m,...)
	Estate_Driveway nvarchar(50),
	Estate_Direction nvarchar(30),
	Estate_Number_Of_Rooms nvarchar(30),
	Estate_Number_Of_Floors nvarchar(30),
	Estate_Number_Of_Toilets nvarchar(30),
	Estate_NumOfView nvarchar(100),
	Currency_ID nvarchar(30) constraint Currency_Estate_fk foreign key (Currency_ID) references Currency(Currency_ID),  		
	Is_Enabled nvarchar(5),
	Is_Paid nvarchar(5),
	--Subscribe : la loai tin dang: vip 1,2,3... 
	Subscribe_ID nvarchar(30) constraint Subscribe_Estate_fk foreign key (Subscribe_ID) references Subscribe (Subscribe_ID),
	--TypeOfEstate is: rent or sell
	TypeOfEstate_ID nvarchar(30) constraint TypeOfEstate_Estate_FK foreign key (TypeOfEstate_ID) references TypeOfEstate(TypeOfEstate_ID),
	--Category :villa, house, phong tro,....
	Category_ID nvarchar(30) constraint Category_Estate_fk foreign key (Category_ID) references Category(Category_ID),	
	--UserName: nguoi dang bai viet nay
	UserName nvarchar(100) constraint Member_Estate_fk foreign key (UserName) references Member(UserName),	
	--SumValue : dung de tinh tong gia tri cua tai san
	SumValue nvarchar(20),
	District_ID  nvarchar(30) constraint District_Estate_FK foreign key (District_ID) references District(District_ID),
	Contact_Details_ID nvarchar(30) constraint Contact_Details_Estate_FK foreign key (Contact_Details_ID) references Contact_Details(Contact_Details_ID),
	Image_Category_ID nvarchar(30) constraint Image_Category_Estate_FK foreign key (Image_Category_ID) references Image_Category(Image_Category_ID)
)

delete from Estate

--tao bang chua images duoc uplen cho moi estate(max=6)
--image_1,...6 o day chinh la ten file anh
------------------Image_Category-------------------------
CREATE TABLE Image_Category
(
	Image_Category_ID nvarchar(30) constraint Image_Category_pk primary key,
	--Estate_ID nvarchar(30) constraint Estate_Image_Category_fk foreign key (Estate_ID) references Estate(Estate_ID),	
	--khi add them image vao bang thi them Estate_ID vao truoc ten file anh. Vd: Estate001_myhome.jpg
	Image_1 nvarchar(200),
	Image_2 nvarchar(200),
	Image_3 nvarchar(200),
	Image_4 nvarchar(200),
	Image_5 nvarchar(200),
	Image_6 nvarchar(200)
)
select * from Image_Category
delete from Image_Category
--INSERT INTO Image_Category VALUES ('1','image1.jpg','image1.jpg','image1.jpg','image1.jpg', 'image1.jpg', 'image1.jpg')

--------------------Contact-------------------------
--CREATE TABLE Contact
--(
--	Contact_ID nvarchar(30) constraint Contact_pk primary key,
--	ContactDetails_ID constraint Estate_Contact_fk foreign key (Estate_ID) references Estate(Estate_ID),
--	Estate_ID nvarchar(30) constraint Estate_Contact_fk foreign key (Estate_ID) references Estate(Estate_ID),
--)
------------------Contact_Details-------------------------
CREATE TABLE Contact_Details
(
	Contact_Details_ID nvarchar(30) constraint Contact_Details_pk primary key,
	--Estate_ID nvarchar(30) constraint Estate_Contact_Details_fk foreign key (Estate_ID) references Estate(Estate_ID),
	Contact_Name nvarchar(200),
	Contact_Address nvarchar(200),
	Contact_Email nvarchar(100),
	Contact_Telephone nvarchar(50)
)
select * from Contact_Details
delete from Contact_Details

--INSERT INTO Contact_Details VALUES ('1','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')

------------------News-------------------------
create table News
(
	News_ID nvarchar(30) constraint News_PK primary key,
	News_Title nvarchar(500),
	News_Contents nvarchar(max),
	News_Image nvarchar(max)
)

select * from News

INSERT INTO News VALUES ('1','New land at Han river','New land at Han river','image1.jpg')


-----------------TransactionDetails-----------------
CREATE TABLE Transaction_Details
(
	Trans_ID nvarchar(30) constraint Trans_pk primary key,
	UserName nvarchar(100) constraint Member_Transaction_Details_fk foreign key (UserName) references Member(UserName),
	Trans_Time nvarchar(30),
	Trans_Money nvarchar(30),
	Trans_Detail nvarchar(max)
)

delete from Transaction_Details
--INSERT INTO Transaction_Details VALUES ('Tran01','Truong Van Loi','30 Day','15000 USD','Selling the house is located on the road Cao Xuan Huy, Vinh City, Nghe An')
--INSERT INTO Transaction_Details VALUES ('Tran02','Truong Trang','30 Day','1000 USD','Rentals 268 Truong Chinh road, Vinh City, Nghe An')
--INSERT INTO Transaction_Details VALUES ('Tran03','Truong Thien','30 Day','12000 USD','Land DISTRICT 9, HCM City, Do Xuan Hop front, 14.5 million/m2 price only')


-----------------Account-----------------
CREATE TABLE Account
(
	Account_Number nvarchar(30) constraint Account_pk primary key,
	Account_Password nvarchar(100),
	Account_Name nvarchar(200),
	Account_Email nvarchar(100),
	Account_Telephone nvarchar(50),
	Account_Balance nvarchar(50)
)
delete from Account
INSERT INTO Account VALUES('123456789','827ccb0eea8a706c4c34a16891f84e7b','QHuy','qhuy@gmail.com','0905123456','100000')
INSERT INTO Account VALUES('123456790','827ccb0eea8a706c4c34a16891f84e7b','VLong','vlong@gmail.com','0905523456','15000')

-----------------FAQs-----------------
CREATE TABLE FAQs
(
	FAQs_ID nvarchar(50) constraint FAQs_pk primary key,
	Question nvarchar(250),
	Answer nvarchar(max)
)
