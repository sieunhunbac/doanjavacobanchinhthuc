package indexjavacoban.pxu.edu.vn;

import java.util.Scanner;

public class DoAnJavaCoBan {

	public static void main(String[] args) {
		int n = nhapSoLuongSanPham();
		String[] masanpham = new String[n];
		String[] tensanpham = new String[n];
		String[] donvitinh = new String[n];
		double[] soluong = new double[n];
		double[] giaban = new double[n];
		double[] thanhtien = new double[n];
		nhapThongTinSanPham(masanpham, tensanpham, donvitinh, soluong, giaban);
		inDanhSachSanPham(masanpham, tensanpham, donvitinh, soluong, giaban, thanhtien);
	}

	// nhap so luong san pham
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

	// NHẬP THÔNG TIN SẢN PHẨM
	public static void nhapThongTinSanPham(String[] masanpham, String[] tensanpham, String[] donvitinh,
			double[] soluong, double[] giaban) {
		System.out.println("*************************************************************");
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
		System.out.println("*************************************************************");
	}

	// HÀM TÍNH THÀNH TIỀN
	public static double[] tinhThanhTien(double[] soluong, double[] giaban) {
		double[] thanhtien = new double[soluong.length];
		for (int i = 0; i < soluong.length; i++) {
			thanhtien[i] = Math.round((soluong[i] * giaban[i]) * 1000.0) / 1000.0;
		}
		System.out.println("+++++++++++++++++++++DA TINH THANH TIEN ++++++++++++++++++++");
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
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("%-13s%-14s%-13s%-11s%-9s%-15s\n","|Mã sản phẩm |","Tên sản phẩm |","Đơn vị tính |","Số lượng |","Gía bán |","Thành tiền VNĐ|");
		for (int i = 0; i < masanpham.length; i++) 
		{ 	System.out.println("|------------|-------------|------------|---------|---------|--------------|");
			System.out.printf("%-13.13s%-14.13s%-13.13s%-10s%-10s%-15s%-15s\n","|"+masanpham[i],"|"+tensanpham[i],"|"+donvitinh[i],"|"+soluong[i],"|"+giaban[i],"|"+thanhtien[i],"|");}
		System.out.println("----------------------------------------------------------------------------");
	}
	}

