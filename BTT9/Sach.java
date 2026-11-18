import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sach {
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public static final DateTimeFormatter DINH_DANG_NGAY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Sach() {
        this.ngayNhap = LocalDate.now();
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia >= 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Don gia phai >= 0!");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong phai >= 0!");
        }
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double tinhThanhTien() {
        return this.soLuong * this.donGia;
    }

    public void nhapThongTin(Scanner sc) {
        while (true) {
            System.out.print("Nhap ma sach: ");
            this.maSach = sc.nextLine().trim();
            if (!this.maSach.isEmpty()) {
                break;
            }
            System.out.println("Ma sach khong duoc de trong!");
        }

        while (true) {
            System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
            String strNgay = sc.nextLine().trim();
            try {
                this.ngayNhap = LocalDate.parse(strNgay, DINH_DANG_NGAY);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Dinh dang ngay khong hop le, nhap theo dd/MM/yyyy!");
            }
        }

        while (true) {
            System.out.print("Nhap don gia: ");
            try {
                double gia = Double.parseDouble(sc.nextLine().trim());
                if (gia >= 0) {
                    this.donGia = gia;
                    break;
                }
                System.out.println("Don gia phai >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so!");
            }
        }

        while (true) {
            System.out.print("Nhap so luong: ");
            try {
                int sl = Integer.parseInt(sc.nextLine().trim());
                if (sl >= 0) {
                    this.soLuong = sl;
                    break;
                }
                System.out.println("So luong phai >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so nguyen!");
            }
        }

        while (true) {
            System.out.print("Nhap nha xuat ban: ");
            this.nhaXuatBan = sc.nextLine().trim();
            if (!this.nhaXuatBan.isEmpty()) {
                break;
            }
            System.out.println("Nha xuat ban khong duoc de trong!");
        }
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + this.maSach + ", Ngay nhap: "
                + (this.ngayNhap != null ? this.ngayNhap.format(DINH_DANG_NGAY) : "Chua ro") + ", Don gia: "
                + this.donGia + ", So luong: " + this.soLuong + ", NXB: " + this.nhaXuatBan);
    }

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Sach> danhSachSach = new ArrayList<>();

    public static void khoiTaoDuLieuMau() {
        danhSachSach.clear();

        danhSachSach.add(new SachGiaoKhoa("GK001", LocalDate.of(2024, 1, 10), 25000, 40, "Giao duc", "moi"));
        danhSachSach.add(new SachGiaoKhoa("GK002", LocalDate.of(2023, 8, 15), 30000, 20, "Giao duc", "cu"));
        danhSachSach.add(new SachGiaoKhoa("GK003", LocalDate.of(2024, 2, 20), 45000, 15, "Kim Dong", "moi"));
        danhSachSach.add(new SachGiaoKhoa("GK004", LocalDate.of(2022, 11, 5), 28000, 30, "Dai hoc Quoc gia", "cu"));

        danhSachSach.add(new SachThamKhao("TK001", LocalDate.of(2024, 3, 1), 120000, 10, "Bach Khoa", 10000));
        danhSachSach.add(new SachThamKhao("TK002", LocalDate.of(2024, 4, 12), 150000, 15, "Khoa hoc Ky thuat", 15000));
        danhSachSach.add(new SachThamKhao("TK003", LocalDate.of(2023, 9, 25), 90000, 25, "Bach Khoa", 8000));
        danhSachSach
                .add(new SachThamKhao("TK004", LocalDate.of(2024, 5, 18), 80000, 12, "Thong tin & Truyen thong", 6000));
    }

    private static boolean isMaSachTonTai(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach.trim())) {
                return true;
            }
        }
        return false;
    }

    public static void nhapSach() {
        System.out.println("\nNHAP THEM SACH MOI");
        System.out.println("1. Nhap Sach Giao Khoa");
        System.out.println("2. Nhap Sach Tham Khao");
        System.out.print("Moi ban chon loai sach (1 hoac 2): ");

        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        Sach sachMoi;
        if (loai == 1) {
            System.out.println("\nNhap thong tin Sach Giao Khoa:");
            sachMoi = new SachGiaoKhoa();
        } else if (loai == 2) {
            System.out.println("\nNhap thong tin Sach Tham Khao:");
            sachMoi = new SachThamKhao();
        } else {
            System.out.println("Lua chon khong hop le, chi chon 1 hoac 2!");
            return;
        }

        sachMoi.nhapThongTin(sc);

        if (isMaSachTonTai(sachMoi.getMaSach())) {
            System.out.println("Loi: Ma sach \"" + sachMoi.getMaSach() + "\" da ton tai trong thu vien!");
            return;
        }

        danhSachSach.add(sachMoi);
        System.out.println("Da them sach thanh cong!");
    }

    public static void xuatDanhSachSach() {
        System.out.println("\nDANH SACH CAC LOAI SACH");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach hien dang trong!");
            return;
        }

        System.out.println("\n--- Sach Giao Khoa ---");
        int demGK = 0;
        for (Sach s : danhSachSach) {
            if (s instanceof SachGiaoKhoa) {
                s.hienThiThongTin();
                demGK++;
            }
        }
        System.out.println("Tong so dau sach giao khoa: " + demGK);

        System.out.println("\n--- Sach Tham Khao ---");
        int demTK = 0;
        for (Sach s : danhSachSach) {
            if (s instanceof SachThamKhao) {
                s.hienThiThongTin();
                demTK++;
            }
        }
        System.out.println("Tong so dau sach tham khao: " + demTK);
        System.out.println("Tong cong: " + danhSachSach.size() + " dau sach.");
    }

    public static void tinhTongThanhTienTungLoai() {
        System.out.println("\nTONG THANH TIEN CHO TUNG LOAI SACH");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach dang trong!");
            return;
        }

        double tongTienSGK = 0;
        int slSGK = 0;
        double tongTienSTK = 0;
        int slSTK = 0;

        for (Sach s : danhSachSach) {
            if (s instanceof SachGiaoKhoa) {
                tongTienSGK += s.tinhThanhTien();
                slSGK += s.getSoLuong();
            } else if (s instanceof SachThamKhao) {
                tongTienSTK += s.tinhThanhTien();
                slSTK += s.getSoLuong();
            }
        }

        System.out.println("1. Tong thanh tien Sach Giao Khoa (" + slSGK + " cuon): " + (long) tongTienSGK + " VND");
        System.out.println("2. Tong thanh tien Sach Tham Khao (" + slSTK + " cuon): " + (long) tongTienSTK + " VND");
        System.out.println("-> Tong gia tri cac loai sach: " + (long) (tongTienSGK + tongTienSTK) + " VND");
    }

    public static void tinhTrungBinhCongDonGiaSTK() {
        System.out.println("\nTRUNG BINH CONG DON GIA CAC SACH THAM KHAO");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach dang trong!");
            return;
        }

        double tongDonGia = 0;
        int soDauSach = 0;

        for (Sach s : danhSachSach) {
            if (s instanceof SachThamKhao) {
                tongDonGia += s.getDonGia();
                soDauSach++;
            }
        }

        if (soDauSach == 0) {
            System.out.println("Hien tai khong co sach tham khao nao!");
            return;
        }

        double tbcTheoDauSach = tongDonGia / soDauSach;
        System.out.println("So luong dau sach tham khao: " + soDauSach);
        System.out.println("Tong don gia: " + (long) tongDonGia + " VND");
        System.out.printf("=> Trung binh cong don gia: %.2f VND\n", tbcTheoDauSach);
    }

    public static void xuatSGKCuaNhaXuatBanX() {
        System.out.println("\nTIM KIEM SACH GIAO KHOA THEO NHA XUAT BAN");
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach dang trong!");
            return;
        }

        System.out.print("Nhap ten nha xuat ban can tim: ");
        String nxbCanTim = sc.nextLine().trim();

        if (nxbCanTim.isEmpty()) {
            System.out.println("Ten nha xuat ban khong duoc de trong!");
            return;
        }

        boolean timThay = false;
        for (Sach s : danhSachSach) {
            if (s instanceof SachGiaoKhoa) {
                if (s.getNhaXuatBan().equalsIgnoreCase(nxbCanTim)) {
                    s.hienThiThongTin();
                    timThay = true;
                }
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach giao khoa cua NXB: " + nxbCanTim);
        }
    }

    public static void main(String[] args) {
        khoiTaoDuLieuMau();

        int luaChon = -1;
        do {
            System.out.println("\n QUAN LY SACH THU VIEN ");
            System.out.println("1. Nhap them sach moi");
            System.out.println("2. Xuat danh sach cac loai sach");
            System.out.println("3. Tinh tong thanh tien cho tung loai sach");
            System.out.println("4. Tinh trung binh cong don gia sach tham khao");
            System.out.println("5. Xuat sach giao khoa theo nha xuat ban ");
            System.out.println("6. Nap lai du lieu mau ban dau");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Moi ban chon (0-6): ");

            try {
                luaChon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so tu 0 den 6!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    nhapSach();
                    break;
                case 2:
                    xuatDanhSachSach();
                    break;
                case 3:
                    tinhTongThanhTienTungLoai();
                    break;
                case 4:
                    tinhTrungBinhCongDonGiaSTK();
                    break;
                case 5:
                    xuatSGKCuaNhaXuatBanX();
                    break;
                case 6:
                    khoiTaoDuLieuMau();
                    System.out.println("Da nap lai du lieu mau mac dinh!");
                    xuatDanhSachSach();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh! Tam biet.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon tu 0 den 6!");
                    break;
            }
        } while (luaChon != 0);
    }
}

class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    public SachGiaoKhoa() {
        super();
        this.tinhTrang = "moi";
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,
            String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public boolean isMoi() {
        if (this.tinhTrang == null)
            return false;
        String tt = this.tinhTrang.trim().toLowerCase();
        return tt.equals("moi") || tt.equals("mới") || tt.equals("1");
    }

    @Override
    public double tinhThanhTien() {
        if (isMoi()) {
            return this.soLuong * this.donGia;
        } else {
            return this.soLuong * this.donGia * 0.5;
        }
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        while (true) {
            System.out.print("Nhap tinh trang sach 1. Moi / 2. Cu: ");
            String input = sc.nextLine().trim();
            if (input.equals("1") || input.equalsIgnoreCase("moi") || input.equalsIgnoreCase("mới")) {
                this.tinhTrang = "moi";
                break;
            } else if (input.equals("2") || input.equalsIgnoreCase("cu") || input.equalsIgnoreCase("cũ")) {
                this.tinhTrang = "cu";
                break;
            } else {
                System.out.println("Vui long nhap 1 (Moi) hoac 2 (Cu).");
            }
        }
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("SGK [Ma: " + this.maSach + ", Ngay: "
                + (this.ngayNhap != null ? this.ngayNhap.format(DINH_DANG_NGAY) : "Chua ro") + ", Gia: "
                + (long) this.donGia + ", SL: " + this.soLuong + ", NXB: " + this.nhaXuatBan + ", Tinh trang: "
                + this.tinhTrang + "] -> Thanh tien: " + (long) tinhThanhTien() + " VND");
    }
}

class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
        this.thue = 0;
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        if (thue >= 0) {
            this.thue = thue;
        } else {
            System.out.println("Thue phai >= 0!");
        }
    }

    @Override
    public double tinhThanhTien() {
        return (this.soLuong * this.donGia) + this.thue;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        while (true) {
            System.out.print("Nhap tien thue: ");
            try {
                double t = Double.parseDouble(sc.nextLine().trim());
                if (t >= 0) {
                    this.thue = t;
                    break;
                }
                System.out.println("Thue phai >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so!");
            }
        }
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("STK [Ma: " + this.maSach + ", Ngay: "
                + (this.ngayNhap != null ? this.ngayNhap.format(DINH_DANG_NGAY) : "Chua ro") + ", Gia: "
                + (long) this.donGia + ", SL: " + this.soLuong + ", NXB: " + this.nhaXuatBan + ", Thue: "
                + (long) this.thue + "] -> Thanh tien: " + (long) tinhThanhTien() + " VND");
    }
}
