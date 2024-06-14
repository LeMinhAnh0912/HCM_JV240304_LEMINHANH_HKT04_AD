package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;
import java.util.Scanner;

public class SingerController {
    private SingerService singerService;

    public SingerController(Singer[] singers) {
        this.singerService = new SingerService(singers);
    }

    public SingerController() {
        this.singerService = new SingerService();
    }

    public void manageSingers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    singerService.addSinger();
                    break;
                case 2:
                    singerService.displayAllSingers();
                    break;
                case 3:
                    System.out.print("Nhập mã số ca sĩ cần chỉnh sửa: ");
                    int updateId = scanner.nextInt();
                    singerService.updateSinger(updateId);
                    break;
                case 4:
                    System.out.print("Nhập mã số ca sĩ cần xoá: ");
                    int deleteId = scanner.nextInt();
                    singerService.deleteSinger(deleteId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn sai,vui lòng nhập lại");
            }
        }
    }
}
