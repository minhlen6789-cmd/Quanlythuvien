import java.util.ArrayList;
import java.util.Scanner;

// KET HOP YEU CAU BAI 7 VA BAI 8
public class Test {
    private static Scanner sc = new Scanner(System.in);

    // [BAI 7 - YEU CAU 4]: Tao va quan ly danh sach Sach bang ArrayList
    private static ArrayList<Sach> danhSachSach = new ArrayList<>();

    // Khoi tao du lieu mau ban dau de test nhanh
    public static void khoiTaoDuLieuMau() {
        danhSachSach.clear();
        danhSachSach.add(new Sach("S001", "Lap trinh Java co ban", "Nguyen Van A", 2021, 15));
        danhSachSach.add(new Sach("S002", "Cau truc du lieu & GT", "Tran Van B", 2020, 8));
        danhSachSach.add(new Sach("S003", "Co so du lieu SQL", "Le Thi C", 2022, 20));
        danhSachSach.add(new Sach("S004", "Lap trinh Huong doi tuong", "Pham Van D", 2023, 12));
    }

    // BAI 7 - YEU CAU 3 & BAI 8 - YEU CAU 2, 3, 4
    public static void demoYeuCau3() {

        // 1. Tao sach 1 bang Constructor day du tham so (Bai 8 - Yeu cau 4)
        System.out.println("[+] Tao sach 1 bang Constructor day du tham so (Bai 8 - YC4):");
        Sach sach1 = new Sach("B01", "Giai thuat lap trinh", "Nguyen Van An", 2022, 10);
        sach1.hienThiThongTin();

        // 2. Tao sach 2 bang Constructor khong tham so va dung Setters (Bai 8 - Yeu cau
        // 2)
        System.out.println("[+] Tao sach 2 bang Constructor khong tham so va Setters (Bai 8 - YC2):");
        Sach sach2 = new Sach();
        sach2.setMaSach("B02");
        sach2.setTieuDe("Thiet ke he thong");
        sach2.setTacGia("Tran Thi Binh");
        sach2.setNamXuatBan(2023); // Hop le
        sach2.setSoLuong(5); // Hop le
        sach2.hienThiThongTin();

        // 3. Kiem tra rang buoc du lieu cua Setters (Bai 8 - Yeu cau 3)
        System.out.println("[+] Kiem tra rang buoc du lieu cua Setters (Bai 8 - YC3):");
        System.out.println("--> Thu set nam xuat ban khong hop le (2099):");
        sach2.setNamXuatBan(2099);

        System.out.println("--> Thu set nam xuat ban am (-5):");
        sach2.setNamXuatBan(-5);

        System.out.println("--> Thu set so luong am (-10):");
        sach2.setSoLuong(-10);
    }

    // BAI 7 - YEU CAU 4: CAC THAO TAC QUAN LY ArrayList<Sach>

    // 1. Them sach moi vao danh sach
    public static void themSach() {
        System.out.println("\n--- THEM SACH MOI ---");
        Sach s = new Sach();
        s.nhapThongTin(sc);

        // Kiem tra trung ma sach
        for (Sach item : danhSachSach) {
            if (item.getMaSach().equalsIgnoreCase(s.getMaSach())) {
                System.out.println("[-] Ma sach \"" + s.getMaSach() + "\" da ton tai! Khong the them.");
                return;
            }
        }

        danhSachSach.add(s);
        System.out.println("[+] Da them sach \"" + s.getTieuDe() + "\" thanh cong vao ArrayList!");
    }

    // 2. Hien thi danh sach sach
    public static void hienThiDanhSach() {
        System.out.println("\n--- DANH SACH SACH TRONG THU VIEN (ArrayList) ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }
        System.out.printf("| %-10s | %-25s | %-20s | %-12s | %-8s |\n",
                "Ma Sach", "Tieu De", "Tac Gia", "Nam XB", "So Luong");
        for (Sach s : danhSachSach) {
            s.hienThiDangBang();
        }
        System.out.println("Tong so dau sach: " + danhSachSach.size());
    }

    // 3. Tim kiem sach theo ma sach hoac tieu de
    public static void timKiemSach() {
        System.out.println("\n--- TIM KIEM SACH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.print("Nhap tu khoa tim kiem (ma sach hoac tieu de): ");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean timThay = false;
        for (Sach s : danhSachSach) {
            if (s.getMaSach().toLowerCase().contains(keyword) || s.getTieuDe().toLowerCase().contains(keyword)) {
                if (!timThay) {
                    System.out.println("\n[+] Ket qua tim kiem:");
                    timThay = true;
                }
                s.hienThiThongTin();
            }
        }

        if (!timThay) {
            System.out.println("[-] Khong tim thay sach nao phu hop voi tu khoa: " + keyword);
        }
    }

    // 4. Xoa sach theo ma sach
    public static void xoaSach() {
        System.out.println("\n--- XOA SACH THEO MA ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.print("Nhap ma sach can xoa: ");
        String maCanXoa = sc.nextLine().trim();

        Sach sachCanXoa = null;
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanXoa)) {
                sachCanXoa = s;
                break;
            }
        }

        if (sachCanXoa != null) {
            danhSachSach.remove(sachCanXoa);
            System.out.println("[+] Da xoa thanh cong cuon sach co ma: " + maCanXoa);
        } else {
            System.out.println("[-] Khong tim thay ma sach: " + maCanXoa + " de xoa!");
        }
    }

    // 5. Tinh tong so luong sach trong thu vien
    public static void tinhTongSoLuong() {
        System.out.println("\n--- TONG SO LUONG SACH ---");
        int tong = 0;
        for (Sach s : danhSachSach) {
            tong += s.getSoLuong();
        }
        System.out.println("-> Tong so luong sach hien co trong thu vien: " + tong + " quyen.");
    }

    // Ham main thuc thi chuong trinh
    public static void main(String[] args) {
        // Nap du lieu mau ban dau
        khoiTaoDuLieuMau();

        int luaChon = -1;
        do {
            System.out.println("       CHUONG TRINH QUAN LY SACH THU VIEN         ");
            System.out.println("1.Tao doi tuong tu lop Sach (Bai 7 & Bai 8)");
            System.out.println("2.Hien thi danh sach sach (ArrayList)");
            System.out.println("3.Them sach moi vao ArrayList");
            System.out.println("4.Tim kiem sach (theo ma / tieu de)");
            System.out.println("5.Xoa sach theo ma sach");
            System.out.println("6.Tinh tong so luong tat ca sach");
            System.out.println("7. Nap lai du lieu mau ban dau");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Moi ban chon (0-7): ");

            try {
                luaChon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen tu 0 den 7!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    demoYeuCau3();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    themSach();
                    break;
                case 4:
                    timKiemSach();
                    break;
                case 5:
                    xoaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    khoiTaoDuLieuMau();
                    System.out.println("[+] Da nap lai danh sach du lieu mau mac dinh!");
                    hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh! Tam biet.");
                    break;
                default:
                    System.out.println("[-] Lua chon khong hop le, vui long chon tu 0 den 7!");
                    break;
            }
        } while (luaChon != 0);
    }
}
