import java.util.Scanner;

// Lớp đại diện cho đối tượng Sách
class Sach {
    // Bài 1: Thuộc tính
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Bài 2: Tính thành tiền = đơn giá * số lượng
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    // Bài 3: Phí vận chuyển = 5% giá trị sách
    public double tinhPhiVanChuyen() {
        return this.tinhThanhTien() * 0.05;
    }

    // Bài 4: Tổng tiền nhập = Thành tiền + Phí vận chuyển
    public double tinhTongTienNhap() {
        return this.tinhThanhTien() + this.tinhPhiVanChuyen();
    }

    // Bài 1: Nhập thông tin sách
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        this.donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();

        // Xóa ký tự Enter thừa trong bộ đệm bàn phím
        sc.nextLine();
    }

    // Bài 1 -> Bài 4: Hiển thị lại thông tin và hóa đơn
    public void xuatThongTin() {
        System.out.println("\n================= THONG TIN SACH =================");
        System.out.println("Ma sach : " + this.maSach);
        System.out.println("Ten sach : " + this.tenSach);
        System.out.println("Tac gia  : " + this.tacGia);
        System.out.println("Nam xuat ban : " + this.namXuatBan);
        System.out.printf("Don gia: %,.0f VNĐ\n", this.donGia);
        System.out.println("So luong: " + this.soLuong);
        System.out.println("--------------------------------------------------");
        System.out.printf("Thanh tien: %,.0f VNĐ\n", this.tinhThanhTien());
        System.out.printf("Phi van chuyen : %,.0f VNĐ (5%%)\n", this.tinhPhiVanChuyen());
        System.out.println("--------------------------------------------------");
        System.out.printf("=> Tong tien nhap: %,.0f VNĐ\n", this.tinhTongTienNhap());
        System.out.println("==================================================");
    }
}

// Lớp chính chứa hàm main (Trùng tên file Quanglythuvien.java)
public class Quanglythuvien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo đối tượng sách
        Sach s = new Sach();

        // 1. Nhập thông tin (Bài 1)
        System.out.println("=== NHAP THONG TIN SACH ===");
        s.nhapThongTin(sc);

        // 2. Xuất thông tin và kết quả tính toán (Bài 1 -> Bài 4)
        s.xuatThongTin();

        sc.close();
    }
}
