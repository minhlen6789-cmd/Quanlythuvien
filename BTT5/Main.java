import java.util.ArrayList;
import java.util.Scanner;

// Lop Sach luu tru thong tin sach
class Sach {
    private String maSach;
    private String tenSach;
    private double donGia;
    private int soLuong;

    // Constructor
    public Sach() {
    }

    public Sach(String maSach, String tenSach, double donGia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Tinh thanh tien = so luong * don gia
    public double getThanhTien() {
        return this.soLuong * this.donGia;
    }

    // Nhap thong tin cho 1 cuon sach
    public void nhap(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();

        System.out.print("Nhap don gia: ");
        this.donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        this.soLuong = Integer.parseInt(sc.nextLine());
    }

    // Xuat thong tin 1 cuon sach
    public void xuat() {
        System.out.printf(
                "Ma sach: %-10s | Ten sach: %-20s | Don gia: %-10.2f | So luong: %-5d | Thanh tien: %-12.2f\n",
                maSach, tenSach, donGia, soLuong, getThanhTien());
    }
}

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Sach> danhSach = new ArrayList<>();

    // BAI 1: Nhap n sach bang vong lap
    public static void bai1_NhapNSach() {
        System.out.print("\nNhap so luong sach n: ");
        int n = Integer.parseInt(sc.nextLine());

        // Vong lap nhap n cuon sach
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap cuon sach thu " + (i + 1) + " ---");
            Sach s = new Sach();
            s.nhap(sc);
            danhSach.add(s);
        }

        System.out.println("\n==> Da nhap thanh cong " + n + " cuon sach!");
        System.out.println("--- Danh sach sach hien co ---");
        for (Sach s : danhSach) {
            s.xuat();
        }
    }

    // BAI 2: Tinh tong so luong va tong gia tri sach
    public static void bai2_TinhTongSoLuongVaGiaTri() {
        if (danhSach.isEmpty()) {
            System.out.println("\nDanh sach sach dang trong! Vui long nhap sach truoc.");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0;

        // Vong lap tinh tong so luong va tong gia tri
        for (Sach s : danhSach) {
            tongSoLuong += s.getSoLuong();
            tongGiaTri += s.getThanhTien();
        }

        System.out.println("\n================ KET QUA BAI 2 ================");
        System.out.println("Tong so luong sach : " + tongSoLuong);
        System.out.printf("Tong gia tri sach  : %,.2f VND\n", tongGiaTri);
        System.out.println("================================================");
    }

    // BAI 4: Tim sach theo ma
    public static void bai4_TimSachTheoMa() {
        if (danhSach.isEmpty()) {
            System.out.println("\nDanh sach sach dang trong! Vui long nhap sach truoc.");
            return;
        }

        System.out.print("\nNhap ma sach can tim: ");
        String maCanTim = sc.nextLine();

        boolean timThay = false;
        // Vong lap tim kiem theo ma
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                System.out.println("\n[+] Tim thay sach:");
                s.xuat();
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("[-] Khong tim thay sach co ma: " + maCanTim);
        }
    }

    public static void main(String[] args) {
        int chon = 0;

        // BAI 3: Menu lap den khi chon Thoat
        do {
            System.out.println("\n===================== MENU =====================");
            System.out.println("1. Bai 1: Nhap n sach bang vong lap");
            System.out.println("2. Bai 2: Tinh tong so luong va tong gia tri sach");
            System.out.println("3. Bai 4: Tim sach theo ma");
            System.out.println("4. Thoat chuong trinh (Bai 3: Menu lap den khi chon Thoat)");
            System.out.print("Moi ban chon (1-4): ");

            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui long nhap so hop le!");
                continue;
            }

            switch (chon) {
                case 1:
                    bai1_NhapNSach();
                    break;
                case 2:
                    bai2_TinhTongSoLuongVaGiaTri();
                    break;
                case 3:
                    bai4_TimSachTheoMa();
                    break;
                case 4:
                    System.out.println("\nBan da chon Thoat. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (chon != 4); // Vong lap lap lai cho den khi chon 4 (Thoat)
    }
}
