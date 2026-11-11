import java.time.Year;
import java.util.Scanner;

// LOP SACH (KET HOP YEU CAU BAI 7 VA BAI 8)
public class Sach {
    // BAI 8 - YEU CAU 1: Tat ca cac thuoc tinh phai duoc khai bao voi tu khoa private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() {
    }

    // BAI 8 - YEU CAU 4: Constructor co day du tham so
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.setNamXuatBan(namXuatBan); 
        this.setSoLuong(soLuong);      
    }

    // BAI 8 - YEU CAU 2 & 3: PUBLIC GETTERS VA SETTERS
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    // BAI 8 - YEU CAU 3: setNamXuatBan dam bao namXuatBan > 0 va <= nam hien tai
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("[-] Loi: Nam xuat ban (" + namXuatBan + ") khong hop le! Phai > 0 va <= " + currentYear + ".");
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

    // BAI 8 - YEU CAU 3: setSoLuong dam bao soLuong khong am (soLuong >= 0)
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("[-] Loi: So luong (" + soLuong + ") khong duoc am! Phai >= 0.");
        }
    }

    // PHUONG THUC NHAP VA HIEN THI THONG TIN
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine().trim();

        System.out.print("Nhap tieu de (ten sach): ");
        this.tieuDe = sc.nextLine().trim();

        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine().trim();

        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("Nhap nam xuat ban: ");
            try {
                int nam = Integer.parseInt(sc.nextLine().trim());
                if (nam > 0 && nam <= currentYear) {
                    this.namXuatBan = nam;
                    break;
                }
                System.out.println("Nam xuat ban phai > 0 va <= " + currentYear + ". Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so nguyen!");
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
                System.out.println("So luong phai >= 0. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so nguyen!");
            }
        }
    }

    // [BAI 7 - YEU CAU 2]: Phuong thuc in ra tat ca thong tin chi tiet cua cuon sach
    public void hienThiThongTin() {
        System.out.println("Ma sach : " + this.maSach);
        System.out.println("Tieu de : " + this.tieuDe);
        System.out.println("Tac gia : " + this.tacGia);
        System.out.println("Nam xuat ban : " + this.namXuatBan);
        System.out.println("So luong : " + this.soLuong);
    }

    // Phuong thuc hien thi theo dong de in dang bang
    public void hienThiDangBang() {
        System.out.printf("| %-10s | %-25s | %-20s | %-12d | %-8d |\n",
                this.maSach, this.tieuDe, this.tacGia, this.namXuatBan, this.soLuong);
    }
}
