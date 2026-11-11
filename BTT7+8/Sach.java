import java.util.Scanner;

// YEU CAU 1 & 2: LOP SACH
public class Sach {
    // Yeu cau 1: Cac thuoc tinh (attributes)
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() {
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    // Getters va Setters
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

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Phuong thuc nhap thong tin tu ban phim
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine().trim();

        System.out.print("Nhap tieu de (ten sach): ");
        this.tieuDe = sc.nextLine().trim();

        System.out.print("Nhap tac gia: ");
        this.tacGia = sc.nextLine().trim();

        while (true) {
            System.out.print("Nhap nam xuat ban: ");
            try {
                this.namXuatBan = Integer.parseInt(sc.nextLine().trim());
                if (this.namXuatBan > 0) {
                    break;
                }
                System.out.println("Nam xuat ban phai > 0. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so nguyen!");
            }
        }

        while (true) {
            System.out.print("Nhap so luong: ");
            try {
                this.soLuong = Integer.parseInt(sc.nextLine().trim());
                if (this.soLuong >= 0) {
                    break;
                }
                System.out.println("So luong phai >= 0. Vui long nhap lai!");
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap so nguyen!");
            }
        }
    }

    // Yeu cau 2: Phuong thuc hienThiThongTin() (displayInfo) in tat ca chi tiet ra
    // man hinh
    public void hienThiThongTin() {
        System.out.println("Ma sach       : " + this.maSach);
        System.out.println("Tieu de       : " + this.tieuDe);
        System.out.println("Tac gia       : " + this.tacGia);
        System.out.println("Nam xuat ban  : " + this.namXuatBan);
        System.out.println("So luong      : " + this.soLuong);
    }

    // Phuong thuc hien thi theo dong de in dang bang
    public void hienThiDangBang() {
        System.out.printf("| %-10s | %-25s | %-20s | %-12d | %-8d |\n",
                this.maSach, this.tieuDe, this.tacGia, this.namXuatBan, this.soLuong);
    }
}
