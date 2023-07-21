package indexjavacoban.pxu.edu.vn;

import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class DoAnJavaCoBan {

	public static void main(String[] args) {
		inMenu();
		int n = nhapSoLuongSanPham();
		String[] masanpham = new String[n];
		String[] tensanpham = new String[n];
		String[] donvitinh = new String[n];
		double[] soluong = new double[n];
		double[] giaban = new double[n];
		double[] thanhtien = new double[n];
		char key;
		do {
			inMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("Ban chon chuc nang nao: ");
			key = sc.next().charAt(0);
			switch(key) {
			case '1': 
				nhapThongTinSanPham(masanpham, tensanpham, donvitinh, soluong, giaban);
				break;
			case '2':
				inDanhSachSanPham(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '3':
				thanhtien = tinhThanhTien(soluong, giaban);
				break;
			case '4':
				sapxepThanhTienGiamDan(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '5':
				sapxepGiaBanTangDan(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '6':
				timSanPhamTheoTen(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '7':
				luuFile(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '8':
				docFile();
				break;
			case 'Q':
				System.out.println("!!!CHƯƠNG TRÌNH ĐÃ KẾT THÚC!!!");
				System.exit(0);
				break;
			case 'q':
				System.out.println("!!!CHƯƠNG TRÌNH ĐÃ KẾT THÚC!!!");
				System.exit(0);
				break;
			}
		}while(key == 'Q' || key == 'q');
	}
	//HÀM MENU CHÍNH
	public static void inMenu() {
		System.out.println("----------------------------------MENU QUẢN LÝ SẢN PHẨM --------------------------------");
		System.out.println("|(1): Nhập thông tin sản phẩm                                                          |");
		System.out.println("|(2): Hiển thị danh sách sản phẩm                                                      |");
		System.out.println("|(3): Tính THÀNH TIỀN sản phẩm                                                         |");
		System.out.println("|(4): Sắp xếp Thành Tiền giảm dần                                                      |");
		System.out.println("|(5): Sắp xếp Gia Bán tăng dần                                                         |");
		System.out.println("|(6): Tìm sản phẩm Theo Tên                                                            |");
		System.out.println("|(Q/q): Thoát khỏi chương trình                                                        |");
		System.out.println("----------------------------------------------------------------------------------------");
	}
	// NHẬP SỐ LƯỢNG SẢN PHẨM
	public static int nhapSoLuongSanPham() {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhập số lượng hàng hóa : ");
				n = sc.nextInt();
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("ĐÃ XÃY RA LỖI TRONG QUÁ TRÌNH NHẬP DỮ LIỆU !!!");
			return -1;
		}
	}
	//HÀM NHẬP 
	// HÀM NHẬP THÔNG TIN SẢN PHẨM
	public static void nhapThongTinSanPham(String[] masanpham, String[] tensanpham, String[] donvitinh,
			double[] soluong, double[] giaban) {
		System.out.println("***************************************************************************************");
		try {
			for (int i = 0; i < masanpham.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("--------Nhập dữ liệu cho sản phẩm thứ " + (i + 1) + "--------");
				System.out.print("Nhập mã sản phẩm: ");
				masanpham[i] = sc.nextLine();
				System.out.print("Nhập tên sản phẩm: ");
				tensanpham[i] = sc.nextLine();
				System.out.print("Nhập đơn vị tính: ");
				donvitinh[i] = sc.nextLine();
				System.out.print("Nhập số lượng: ");
				soluong[i] = sc.nextDouble();
				System.out.print("Nhập giá bán (VNĐ): ");
				giaban[i] = sc.nextDouble();
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
		System.out.println("***************************************************************************************");
	}

	// HÀM TÍNH THÀNH TIỀN
	public static double[] tinhThanhTien(double[] soluong, double[] giaban) {
		double[] thanhtien = new double[soluong.length];
		for (int i = 0; i < soluong.length; i++) {
			thanhtien[i] = Math.round((soluong[i] * giaban[i]) * 1000.0) / 1000.0;
		}
		System.out.println("++++++++++++++++++++++++++++++++ ĐÃ TÍNH THÀNH TIỀN ++++++++++++++++++++++++++++++++");
		return thanhtien;
	}

	// HÀM IN DANH SÁCH SẢN PHẨM RA MÀN HÌNH
	public static void inDanhSachSanPham(String[] masanpham, String[] tensanpham, String[] donvitinh,
			double[] soluong, double[] giaban,double[] thanhtien) {
		System.out.println("\t\t\t\t\t |");
		System.out.println("\t\t\t\t\t |");
		System.out.println("\t\t\t\t\t |");
		System.out.println("\t\t\t\t\t V");
		System.out.println("\t\t\t\t DANH SÁCH SẢN PHẨM");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("%-6s%-13s%-14s%-13s%-11s%-9s%-15s\n","| STT ","| Mã sản phẩm |"," Tên sản phẩm |"," Đơn vị tính |"," Số lượng |"," Giá bán |"," Thành tiền VNĐ |");
		for (int i = 0; i < masanpham.length; i++) 
		{ 	System.out.println("|-----|-------------|--------------|-------------|----------|---------|----------------|");
			System.out.printf("%-6s%-14.14s%-15.15s%-14.14s%-11s%-10s%-16s%-15s\n","|  "+i,"| "+masanpham[i],"| "+tensanpham[i],"| "+donvitinh[i],"| "+soluong[i],"| "+giaban[i],"| "+thanhtien[i]+"VNĐ"," |");}
		System.out.println("----------------------------------------------------------------------------------------");
	}
	//HÀM SẮP XẾP THEO CHIỀU GIẢM DẦN CỦA THÀNH TIỀN
	public static void sapxepThanhTienGiamDan(String[] masanpham, String[] tensanpham, String[] donvitinh,double[] soluong, double[] giaban,double[] thanhtien) {
	for (int i = 0; i < thanhtien.length - 1; i++) {
		for (int j = i + 1; j < thanhtien.length; j++) {
			if (thanhtien[i] < thanhtien[j]) {
				// HOÁN VỊ THÀNH TIỀN
				double tam = thanhtien[i];
				thanhtien[i] =thanhtien[j];
				thanhtien[j] = tam;
				// HOÁN VỊ SỐ LƯỢNG
				tam = soluong[i];
				soluong[i] =soluong[j];
				soluong[j] = tam;
				// HOÁN VỊ GIÁ BÁN
				tam = giaban[i];
				giaban[i] =giaban[j];
				giaban[j] = tam;
				// HOÁN VỊ MÃ SẢN PHẨM
				String tam1 = masanpham[i];
				masanpham[i] = masanpham[j];
				masanpham[j] = tam1;
				// HOÁN VỊ TỂN SẢN PHẨM
				tam1 = tensanpham[i];
				tensanpham[i] = tensanpham[j];
				tensanpham[j] = tam1;
				// HOÁN VỊ ĐƠN VỊ TÍNH
				tam1 = donvitinh[i];
				donvitinh[i] = donvitinh[j];
				donvitinh[j] = tam1;
			}
		}
	}
	  System.out.println("+++++++++++++++++++++++++ ĐÃ SẮP XẾP THEO THÀNH TIỀN GIẢM DẦN +++++++++++++++++++++++++");
	inDanhSachSanPham(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
}

// HÀM SẮP XẾP THEO CHIỀU GIẢM TĂNG CỦA GIÁ BÁN
public static void sapxepGiaBanTangDan(String[] masanpham, String[] tensanpham, String[] donvitinh, double[] soluong,
		double[] giaban, double[] thanhtien) {
	for (int i = 0; i < giaban.length - 1; i++) {
		for (int j = i + 1; j < giaban.length; j++) {
			if (giaban[i] > giaban[j]) {
				// HOÁN VỊ GIÁ BÁN
				double tam = giaban[i];
				giaban[i] = giaban[j];
				giaban[j] = tam;
				// HOÁN VỊ SỐ LƯỢNG
				tam = soluong[i];
				soluong[i] = soluong[j];
				soluong[j] = tam;
				// HOÁN VỊ THÀNH TIỀN
				tam = thanhtien[i];
				thanhtien[i] = thanhtien[j];
				thanhtien[j] = tam;
				// HOÁN VỊ MÃ SẢN PHẨM
				String tam1 = masanpham[i];
				masanpham[i] = masanpham[j];
				masanpham[j] = tam1;
				// HOÁN VỊ TỂN SẢN PHẨM
				tam1 = tensanpham[i];
				tensanpham[i] = tensanpham[j];
				tensanpham[j] = tam1;
				// HOÁN VỊ ĐƠN VỊ TÍNH
				tam1 = donvitinh[i];
				donvitinh[i] = donvitinh[j];
				donvitinh[j] = tam1;
			}
		}
	}
	System.out.println("+++++++++++++++++++++++++++ ĐÃ SẮP XẾP THEO GIÁ BÁN TĂNG DẦN +++++++++++++++++++++++++++");
	inDanhSachSanPham(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
}

	// HÀM TÌM KIẾM THEO TÊN SẢN PHẨM
	public static void timSanPhamTheoTen(String[] masanpham, String[] tensanpham, String[] donvitinh, double[] soluong,
			double[] giaban, double[] thanhtien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String x;
		try {
			// do {
			System.out.print("-----------> Nhập tên sản phẩm cần tìm : ");
			x = sc.nextLine();
			// }while();

			for (int i = 0; i < tensanpham.length; i++) {
				if (tensanpham[i].equals(x)) {
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%-6s%-13s%-14s%-13s%-11s%-9s%-15s\n","| STT ","| Mã sản phẩm |"," Tên sản phẩm |"," Đơn vị tính |"," Số lượng |"," Giá bán |"," Thành tiền VNĐ |");
					 	System.out.println("|-----|-------------|--------------|-------------|----------|---------|----------------|");
						System.out.printf("%-6s%-14.14s%-15.15s%-14.14s%-11s%-10s%-16s%-15s\n","|  "+i,"| "+masanpham[i],"| "+tensanpham[i],"| "+donvitinh[i],"| "+soluong[i],"| "+giaban[i],"| "+thanhtien[i]+"VNĐ"," |");
					System.out.println("----------------------------------------------------------------------------------------");
					count = count + 1;
				}
			}
	System.out.println("================================= ĐÃ TÌM THẤY SẢN PHẨM  ================================");
			if (count == 0) {
				System.out.println("KHÔNG TÌM THẤY");
			}
		} catch (Exception e) {
			System.out.println("!!! ĐÃ XẢY RA LỖI TRONG QUÁ TRÌNH NHẬP DỮ LIỆU !!!");
		}
	}
	public static void luuFile(String[] masanpham, String[] tensanpham, String[] donvitinh, double[] soluong,
			double[] giaban, double[] thanhtien) {
	    try {
	        FileWriter fw = new FileWriter("D:\\LuuDoThuatToanDraw.io\\doanjavacoban.txt");
	        for (int i = 0; i < masanpham.length; i++) {
fw.write("Mã sản phẩm : "+masanpham[i] + "--Tên sản phẩm : " + tensanpham[i] + " -- Đơn vị tính: " + donvitinh[i] + " -- Số lượng: " + soluong[i] + " -- Giá bán : " +giaban[i] + "--Thành tiền : "+ thanhtien[i] +"\n");
	        }
	        fw.close();
	        System.out.println("Đã xuất file thành công!");
	    } catch (IOException e) {
	        System.out.println("Đã sảy ra lỗi trong quá trình xuất file!");
	    }
	}

	
	public static void docFile() {
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("D:\\LuuDoThuatToanDraw.io\\doanjavacoban.txt"));
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	        br.close();
	        System.out.println("Đã nhập file thành công!");
	    } catch (IOException e) {
	        System.out.println("Đã sảy ra lỗi trong quá trình nhập file!");
	    }
}

	}

