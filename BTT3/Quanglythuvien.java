import java.util.Scanner;

class Sach {
    // Thuộc tính cơ bản
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;
    private int loaiSach;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong,
            int loaiSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    // --- CÁC HÀM TÍNH TOÁN (Tuần 2) ---
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    public double tinhPhiVanChuyen() {
        return this.tinhThanhTien() * 0.05;
    }

    public double tinhTongTienNhap() {
        return this.tinhThanhTien() + this.tinhPhiVanChuyen();
    }

    // BÀI 1: Kiểm tra giá > 0, số lượng >= 0, năm xuất bản hợp lệ
    public boolean kiemTraHopLe() {
        int namHienTai = Year.now().getValue();
        boolean giaHopLe = this.donGia > 0;
        boolean soLuongHopLe = this.soLuong >= 0;
        boolean namHopLe = (this.namXuatBan > 0 && this.namXuatBan <= namHienTai);

        return giaHopLe && soLuongHopLe && namHopLe;
    }

    // BÀI 2: Phân loại giá (Dùng cấu trúc if-else)
    // < 50k: thấp | 50k - 100k: trung bình | 100k - 200k: cao | > 200k: đặc biệt
    public String phanLoaiGia() {
        if (this.donGia < 50000) {
            return "Sách giá thấp";
        } else if (this.donGia <= 100000) {
            return "Sách giá trung bình";
        } else if (this.donGia <= 200000) {
            return "Sách giá cao";
        } else {
            return "Sách giá đặc biệt";
        }
    }

    // BÀI 3: Phân loại tồn kho (Dùng cấu trúc if-else)
    // 0: Hết | 1-5: Sắp hết | 6-20: Còn ít | > 20: Còn nhiều
    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Hết sách";
        } else if (this.soLuong <= 5) {
            return "Sắp hết";
        } else if (this.soLuong <= 20) {
            return "Còn ít";
        } else {
            return "Còn nhiều";
        }
    }

    // BÀI 4: Dùng switch chọn loại sách
    // 1: SGK, 2: Tham khảo, 3: Chuyên ngành, 4: Khác
    public String layTenLoaiSach() {
        switch (this.loaiSach) {
            case 1:
                return "Sách giáo khoa";
            case 2:
                return "Sách tham khảo";
            case 3:
                return "Sách chuyên ngành";
            case 4:
                return "Sách khác";
            default:
                return "Loại không xác định";
        }
    }

    // Nhập thông tin sách
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine();

        System.out.println("--- Chon loai sach ---");
        System.out.println("1. Sach giao khoa | 2. Sach tham khao | 3. Sach chuyen nganh | 4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        this.loaiSach = sc.nextInt();

        System.out.print("Nhap nam xuat ban: ");
        this.namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        this.donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextInt();

        // Xóa ký tự Enter thừa
        sc.nextLine();
    }

    // Xuất thông tin và kết quả đánh giá điều kiện
    public void xuatThongTin() {
        System.out.println("\n================= THONG TIN SACH =================");
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Ten sach: " + this.tenSach);
        System.out.println("Tac gia: " + this.tacGia);
        System.out.println("Loai sach (Bai 4): " + this.layTenLoaiSach());
        System.out.println("Nam xuat ban: " + this.namXuatBan);
        System.out.printf("Don gia: %,.0f VNĐ\n", this.donGia);
        System.out.println("So luong : " + this.soLuong);
        System.out.println("--------------------------------------------------");
        System.out.printf("Thanh tien: %,.0f VNĐ\n", this.tinhThanhTien());
        System.out.printf("Phi van chuyen : %,.0f VNĐ (5%%)\n", this.tinhPhiVanChuyen());
        System.out.printf("=> Tong tien nhap: %,.0f VNĐ\n", this.tinhTongTienNhap());
        System.out.println("--------------------------------------------------");
        System.out.println("--- KET QUA DANH GIA & RA QUYET DINH (TUAN 4) ---");
        System.out.println("Hop le (Bai 1) : " + (this.kiemTraHopLe() ? "Hop le (Dat yeu cau)" : "KHONG HOP LE!"));
        System.out.println("Phan loai gia: " + this.phanLoaiGia() + " (Bai 2)");
        System.out.println("Ton kho: " + this.phanLoaiTonKho() + " (Bai 3)");
        System.out.println("==================================================");
    }
}

// Lớp chính chứa hàm main (Trùng tên file Quanglythuvien.java)
public class Quanglythuvien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo đối tượng sách
        Sach s = new Sach();

        // 1. Nhập thông tin
        System.out.println("=== NHAP THONG TIN SACH ===");
        s.nhapThongTin(sc);

        // 2. Xuất thông tin và kết quả đánh giá điều kiện
        s.xuatThongTin();

        sc.close();
    }
}