import java.time.Year;
import java.util.Scanner;

// Lop dai dien cho doi tuong Sach
class Sach {
    // ==========================================
    // [BTT3 - BAI 1]: Cac thuoc tinh co ban
    // ==========================================
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double donGia;
    private int soLuong;

    // ==========================================
    // [BTT4 - BAI 4]: Thuoc tinh bo sung loai sach
    // (1: SGK, 2: Tham khao, 3: Chuyen nganh, 4: Khac)
    // ==========================================
    private int loaiSach;

    // Ham tao khong doi so
    public Sach() {
    }

    // Ham tao day du doi so (ket hop BTT3 va BTT4)
    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, double donGia, int soLuong, int loaiSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.loaiSach = loaiSach;
    }

    // =========================================================================
    //                        CAC PHUONG THUC BTT3
    // =========================================================================

    // [BTT3 - BAI 2]: Tinh thanh tien = don gia * so luong
    public double tinhThanhTien() {
        return this.donGia * this.soLuong;
    }

    // [BTT3 - BAI 3]: Phi van chuyen = 5% gia tri sach
    public double tinhPhiVanChuyen() {
        return this.tinhThanhTien() * 0.05;
    }

    // [BTT3 - BAI 4]: Tong tien nhap = Thanh tien + Phi van chuyen
    public double tinhTongTienNhap() {
        return this.tinhThanhTien() + this.tinhPhiVanChuyen();
    }

    // =========================================================================
    //                        CAC PHUONG THUC BTT4
    // =========================================================================

    // [BTT4 - BAI 1]: Kiem tra gia > 0, so luong >= 0, nam xuat ban hop le (> 0 va <= nam hien tai)
    public boolean kiemTraHopLe() {
        int namHienTai = Year.now().getValue();
        boolean giaHopLe = this.donGia > 0;
        boolean soLuongHopLe = this.soLuong >= 0;
        boolean namXbHopLe = (this.namXuatBan > 0 && this.namXuatBan <= namHienTai);

        return giaHopLe && soLuongHopLe && namXbHopLe;
    }

    // Chi tiet loi neu khong hop le de thong bao ro rang cho nguoi dung
    public String chiTietLoiHopLe() {
        int namHienTai = Year.now().getValue();
        StringBuilder loi = new StringBuilder();
        if (this.donGia <= 0) {
            loi.append("- Don gia phai > 0. ");
        }
        if (this.soLuong < 0) {
            loi.append("- So luong phai >= 0. ");
        }
        if (this.namXuatBan <= 0 || this.namXuatBan > namHienTai) {
            loi.append("- Nam xuat ban phai tu 1 den ").append(namHienTai).append(". ");
        }
        return loi.length() == 0 ? "Hop le" : loi.toString();
    }

    // [BTT4 - BAI 2]: Phan loai gia: thap, trung binh, cao, dac biet
    // - Gia < 50.000       -> Sach gia thap
    // - 50.000 - 100.000   -> Sach gia trung binh
    // - 100.000 - 200.000  -> Sach gia cao
    // - > 200.000          -> Sach gia dac biet
    public String phanLoaiGia() {
        if (this.donGia < 50000) {
            return "Sach gia thap";
        } else if (this.donGia <= 100000) {
            return "Sach gia trung binh";
        } else if (this.donGia <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    // [BTT4 - BAI 3]: Phan loai ton kho: het, sap het, con it, con nhieu
    // - 0      -> Het sach
    // - 1 - 5  -> Sap het
    // - 6 - 20 -> Con it
    // - > 20   -> Con nhieu
    public String phanLoaiTonKho() {
        if (this.soLuong == 0) {
            return "Het sach";
        } else if (this.soLuong <= 5) {
            return "Sap het";
        } else if (this.soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    // [BTT4 - BAI 4]: Dung switch-case chon loai sach
    // 1: Sach giao khoa, 2: Sach tham khao, 3: Sach chuyen nganh, 4: Sach khac
    public String layTenLoaiSach() {
        switch (this.loaiSach) {
            case 1:
                return "Sach giao khoa";
            case 2:
                return "Sach tham khao";
            case 3:
                return "Sach chuyen nganh";
            case 4:
                return "Sach khac";
            default:
                return "Loai sach khong xac dinh";
        }
    }

    // [BTT4 - GOI Y THEM]: Danh gia sach moi hay cu (<= 3 nam gan day la sach moi)
    public String phanLoaiMoiCu() {
        int namHienTai = Year.now().getValue();
        if (namHienTai - this.namXuatBan <= 3) {
            return "Sach moi";
        } else {
            return "Sach cu";
        }
    }

    // =========================================================================
    //             NHAP & XUAT THONG TIN (KET HOP BTT3 VA BTT4)
    // =========================================================================

    // Nhap thong tin sach
    public void nhapThongTin(Scanner sc) {
        // [BTT3]: Nhap thong tin co ban
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

        // [BTT4 - BAI 4]: Menu lua chon loai sach
        System.out.println("--- Chon loai sach [BTT4 - Bai 4] ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        this.loaiSach = sc.nextInt();

        // Xoa ky tu Enter thua trong bo dem
        sc.nextLine();
    }

    // Xuat thong tin sach
    public void xuatThongTin() {
        System.out.println("\n================= THONG TIN SACH =================");
        // Thong tin chung
        System.out.println("Ma sach                  : " + this.maSach);
        System.out.println("Ten sach                 : " + this.tenSach);
        System.out.println("Tac gia                  : " + this.tacGia);
        System.out.println("Loai sach [BTT4 - Bai 4] : " + this.layTenLoaiSach());
        System.out.println("Nam xuat ban             : " + this.namXuatBan);
        System.out.printf("Don gia                  : %,.0f VND\n", this.donGia);
        System.out.println("So luong                 : " + this.soLuong);

        // [BTT3]: Hoa don va tinh toan
        System.out.println("----------------- HOA DON (BTT3) -----------------");
        System.out.printf("Thanh tien [BTT3 - Bai 2]   : %,.0f VND\n", this.tinhThanhTien());
        System.out.printf("Phi van chuyen [BTT3 - Bai 3]: %,.0f VND (5%%)\n", this.tinhPhiVanChuyen());
        System.out.println("--------------------------------------------------");
        System.out.printf("=> Tong tien nhap [BTT3]    : %,.0f VND\n", this.tinhTongTienNhap());

        // [BTT4]: Ra quyet dinh va danh gia
        System.out.println("----------- RA QUYET DINH & DANH GIA (BTT4) -----------");
        System.out.println("Hop le? [BTT4 - Bai 1]      : " + (this.kiemTraHopLe() ? "Hop le" : "Khong hop le (" + this.chiTietLoiHopLe() + ")"));
        System.out.println("Phan loai gia [BTT4 - Bai 2]: " + this.phanLoaiGia());
        System.out.println("Ton kho [BTT4 - Bai 3]      : " + this.phanLoaiTonKho());
        System.out.println("Danh gia moi/cu             : " + this.phanLoaiMoiCu());
        System.out.println("==================================================");
    }
}

// Lop chinh chua ham main
public class Quanglythuvien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khoi tao doi tuong sach
        Sach s = new Sach();

        // 1. Nhap thong tin sach (BTT3 + BTT4)
        System.out.println("=== NHAP THONG TIN SACH ===");
        s.nhapThongTin(sc);

        // 2. Xuat thong tin, hoa don va cac quyet dinh danh gia
        s.xuatThongTin();

        sc.close();
    }
}
