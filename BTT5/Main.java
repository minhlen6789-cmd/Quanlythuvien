import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    // Bai 2: ArrayList<String> luu ma sach
    private static ArrayList<String> dsMaSach = new ArrayList<>();

    // Bai 3: ArrayList<String> danhSachSach; Moi phan tu dai dien cho thong tin cua
    // mot cuon sach
    private static ArrayList<String> danhSachSach = new ArrayList<>();

    // BAI 1: Mang int[] soLuong (nhap 5 sach, hien thi, tinh tong, tim max)

    public static void bai1_MangSoLuong() {
        int[] soLuong = new int[5];
        System.out.println("\n--- BAI 1: NHAP SO LUONG CUA 5 CUON SACH ---");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Nhap so luong cuon sach thu " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine().trim());
        }

        // Hien thi so luong
        System.out.print("\n-> Danh sach so luong 5 cuon sach: ");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print(soLuong[i] + (i < soLuong.length - 1 ? ", " : ""));
        }
        System.out.println();

        // Tinh tong va tim so luong lon nhat
        int tong = 0;
        int max = soLuong[0];
        for (int sl : soLuong) {
            tong += sl;
            if (sl > max) {
                max = sl;
            }
        }
        System.out.println("-> Tong so luong 5 cuon sach: " + tong);
        System.out.println("-> So luong lon nhat (max)   : " + max);
    }

    // BAI 2: ArrayList<String> luu ma sach (them, hien thi, tim, xoa)
    public static void bai2_ArrayListMaSach() {
        int chon = 0;
        do {
            System.out.println("\n--- BAI 2: QUAN LY MA SACH (ArrayList<String>) ---");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi danh sach ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Moi ban chon (0-4): ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                continue;
            }

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach can them: ");
                    String maThem = sc.nextLine().trim();
                    dsMaSach.add(maThem);
                    System.out.println("[+] Da them ma sach: " + maThem);
                    break;
                case 2:
                    if (dsMaSach.isEmpty()) {
                        System.out.println("[-] Danh sach ma sach dang trong!");
                    } else {
                        System.out.println("-> Danh sach ma sach: " + dsMaSach);
                    }
                    break;
                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine().trim();
                    if (dsMaSach.contains(maTim)) {
                        System.out.println("[+] Tim thay ma sach: " + maTim);
                    } else {
                        System.out.println("[-] Khong tim thay ma sach: " + maTim);
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine().trim();
                    if (dsMaSach.remove(maXoa)) {
                        System.out.println("[+] Da xoa ma sach: " + maXoa);
                    } else {
                        System.out.println("[-] Khong tim thay ma sach de xoa: " + maXoa);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);
    }

    // BAI 3 & BAI 4: CAC CHUC NANG QUAN LY SACH

    // 1. Them sach
    public static void themSach() {
        System.out.println("\n--- 1. THEM SACH ---");
        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine().trim();

        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine().trim();

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine().trim());

        // Luu thong tin sach duoi dang chuoi vao ArrayList<String>
        String thongTinSach = ma + " - " + ten + " - " + donGia + " - " + soLuong;
        danhSachSach.add(thongTinSach);
        System.out.println("[+] Da them sach thanh cong!");
    }

    // 2. Hien thi sach
    public static void hienThiSach() {
        System.out.println("\n--- 2. HIEN THI DANH SACH SACH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.println("=".repeat(70));
        System.out.printf("| %-10s | %-25s | %-12s | %-10s |\n", "Ma sach", "Ten sach", "Don gia", "So luong");
        System.out.println("-".repeat(70));
        for (String tt : danhSachSach) {
            String[] parts = tt.split(" - ");
            System.out.printf("| %-10s | %-25s | %-12s | %-10s |\n", parts[0], parts[1], parts[2], parts[3]);
        }
        System.out.println("=".repeat(70));
    }

    // 3. Tim sach
    public static void timSach() {
        System.out.println("\n--- 3. TIM SACH THEO MA ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.print("Nhap ma sach can tim: ");
        String maCanTim = sc.nextLine().trim();
        boolean timThay = false;

        for (String tt : danhSachSach) {
            String[] parts = tt.split(" - ");
            if (parts[0].equalsIgnoreCase(maCanTim)) {
                System.out.println("[+] Tim thay sach: " + tt);
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("[-] Khong tim thay sach co ma: " + maCanTim);
        }
    }

    // 4. Xoa sach
    public static void xoaSach() {
        System.out.println("\n--- 4. XOA SACH THEO MA ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.print("Nhap ma sach can xoa: ");
        String maCanXoa = sc.nextLine().trim();
        boolean daXoa = false;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split(" - ");
            if (parts[0].equalsIgnoreCase(maCanXoa)) {
                danhSachSach.remove(i);
                System.out.println("[+] Da xoa sach co ma: " + maCanXoa + " thanh cong!");
                daXoa = true;
                break;
            }
        }

        if (!daXoa) {
            System.out.println("[-] Khong tim thay sach co ma: " + maCanXoa + " de xoa!");
        }
    }

    // 5. Sua sach
    public static void suaSach() {
        System.out.println("\n--- 5. SUA THONG TIN SACH ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        System.out.print("Nhap ma sach can sua: ");
        String maCanSua = sc.nextLine().trim();
        boolean daSua = false;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split(" - ");
            if (parts[0].equalsIgnoreCase(maCanSua)) {
                System.out.println("Thong tin cu: " + danhSachSach.get(i));
                System.out.println("Nhap thong tin moi:");

                System.out.print("Nhap ten sach moi: ");
                String tenMoi = sc.nextLine().trim();

                System.out.print("Nhap don gia moi: ");
                double donGiaMoi = Double.parseDouble(sc.nextLine().trim());

                System.out.print("Nhap so luong moi: ");
                int soLuongMoi = Integer.parseInt(sc.nextLine().trim());

                String thongTinMoi = parts[0] + " - " + tenMoi + " - " + donGiaMoi + " - " + soLuongMoi;
                danhSachSach.set(i, thongTinMoi);
                System.out.println("[+] Da cap nhat thong tin sach thanh cong!");
                daSua = true;
                break;
            }
        }

        if (!daSua) {
            System.out.println("[-] Khong tim thay sach co ma: " + maCanSua + " de sua!");
        }
    }

    // 6. Tinh tong so luong
    public static void tinhTongSoLuong() {
        System.out.println("\n--- 6. TINH TONG SO LUONG ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        int tongSL = 0;
        for (String tt : danhSachSach) {
            String[] parts = tt.split(" - ");
            tongSL += Integer.parseInt(parts[3].trim());
        }
        System.out.println("-> Tong so luong sach: " + tongSL);
    }

    // 7. Tinh tong gia tri
    public static void tinhTongGiaTri() {
        System.out.println("\n--- 7. TINH TONG GIA TRI ---");
        if (danhSachSach.isEmpty()) {
            System.out.println("[-] Danh sach sach dang trong!");
            return;
        }

        double tongGiaTri = 0;
        for (String tt : danhSachSach) {
            String[] parts = tt.split(" - ");
            double donGia = Double.parseDouble(parts[2].trim());
            int soLuong = Integer.parseInt(parts[3].trim());
            tongGiaTri += (donGia * soLuong);
        }
        System.out.printf("-> Tong gia tri sach: %,.2f VND\n", tongGiaTri);
    }

    // BAI 4: Menu hoan chinh lap den khi chon Thoat (8)
    public static void main(String[] args) {
        int chon = 0;
        do {
            System.out.println("\n===================== MENU HOAN CHINH =====================");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("9. Bai 1: Mang int[] soLuong (5 cuon sach: tong, max)");
            System.out.println("10. Bai 2: ArrayList<String> Ma sach (them, xem, tim, xoa)");
            System.out.println("===========================================================");
            System.out.print("Moi ban chon (1-8 hoac 9, 10): ");

            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Vui long nhap so!");
                continue;
            }

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("\nBan da chon Thoat. Tam biet!");
                    break;
                case 9:
                    bai1_MangSoLuong();
                    break;
                case 10:
                    bai2_ArrayListMaSach();
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (chon != 8);
    }
}
