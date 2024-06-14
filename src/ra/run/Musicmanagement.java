package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;

import java.text.ParseException;
import java.util.Scanner;

public class Musicmanagement {
    SingerController singerController = new SingerController();
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SingerController singerController = new SingerController();
        SongController songController = new SongController();
        SearchManagement searchManagement = new SearchManagement();
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CYAN = "\u001B[36m";

        while (true) {
            System.out.println(ANSI_CYAN + "╔════════════════════════════════════════════════════════════════════════╗");
            System.out.println("                             MUSIC-MANAGEMENT");
            System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 1. Quản lý ca sĩ                                                       ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 2. Quản lý bài hát                                                     ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 3. Tìm kiếm bài hát                                                    ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "║ 4. Thoát                                                               ║" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "╚════════════════════════════════════════════════════════════════════════╝" + ANSI_RESET);
            System.out.print(ANSI_RED + "Lựa chọn của bạn là: " + ANSI_RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    singerController.manageSingers();
                    break;
                case 2:
                    songController.manageSongs();
                    break;
                case 3:
                    searchManagement.showSearchMenu();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không đúng, vui lòng nhập lại.");
            }
        }
    }
}
