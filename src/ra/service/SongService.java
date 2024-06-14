

package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class SongService {
    private Song[] songs;

    public SongService(Song[] songs) {
        this.songs = songs;
    }

    public SongService() {
        this.songs = new Song[0];
    }

    public void addSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine();

        Song[] newSongs = new Song[numberOfSongs];

        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + (i + 1) + ":");

            String name;
            while (true) {
                System.out.print("Nhập tên bài hát: ");
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên bài hát không được để trống. Vui lòng nhập lại.");
            }

            String descriptions;
            while (true) {
                System.out.print("Mô tả: ");
                descriptions = scanner.nextLine();
                if (!descriptions.trim().isEmpty()) {
                    break;
                }
                System.out.println("Mô tả không được để trống. Vui lòng nhập lại.");
            }

            String singerName;
            while (true) {
                System.out.print("Ca sĩ trình bày: ");
                singerName = scanner.nextLine();
                if (!singerName.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập lại.");
            }
            Singer singer = new Singer();

            String author;
            while (true) {
                System.out.print("Người sáng tác: ");
                author = scanner.nextLine();
                if (!author.trim().isEmpty()) {
                    break;
                }
                System.out.println("Tên tác giả không được để trống. Vui lòng nhập lại.");
            }

            Date makingDate;
            while (true) {
                System.out.print("Ngày tạo (yyyy-mm-dd): ");
                try {
                    makingDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
                    break;
                } catch (ParseException e) {
                    System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại (yyyy-MM-dd): ");
                }
            }

            System.out.print("Trạng thái (true/false): ");
            boolean status = scanner.nextBoolean();
            scanner.nextLine();

            newSongs[i] = new Song(name, descriptions, singer, author, makingDate, status);
            System.out.println("Đã thêm bài hát: " + name);
        }


        Song[] allSongs = Arrays.copyOf(songs, songs.length + numberOfSongs);
        System.arraycopy(newSongs, 0, allSongs, songs.length, numberOfSongs);
        this.songs = allSongs;
    }

    public void updateSong(String id) {
        Scanner scanner = new Scanner(System.in);
        SingerService singerService = new SingerService();

        for (Song song : songs) {
            if (song.getSongId().equals(id)) {
                System.out.println("Nhập thông tin mới cho bài hát:");

                System.out.print("Tên bài hát: ");
                song.setSongName(scanner.nextLine());

                System.out.print("Mô tả: ");
                song.setDescriptions(scanner.nextLine());

                String singerName;
                while (true) {
                    System.out.print("Ca sĩ trình bày: ");
                    singerName = scanner.nextLine();
                    if (!singerName.trim().isEmpty()) {
                        break;
                    }
                    System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập lại.");
                }
                Singer singer = new Singer();
                song.setSinger(singer);

                System.out.print("Người sáng tác: ");
                song.setSongWriter(scanner.nextLine());

                System.out.println("Thông tin bài hát đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy bài hát với mã ID: " + id);
    }

    public Song[] getLatestSongs(int count) {

        if (count <= 0 || count > songs.length) {
            System.out.println("Không có đủ bài hát để trả về.");
            return new Song[0];
        }


        Arrays.sort(songs, Comparator.comparing(Song::getCreatedDate).reversed());


        return Arrays.copyOfRange(songs, 0, count);
    }

    public Song[] getAllSongs() {
        return songs;
    }

    public void displayAllSongs() {
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    public void deleteSong(String id) {
        if (songs.length == 0) {
            System.out.println("Không có bài hát nào để xoá.");
            return;
        }
        int newSize = songs.length - 1;
        Song[] newSongs = new Song[newSize];
        int index = 0;
        boolean found = false;
        for (Song song : songs) {
            if (song.getSongId().equals(id)) {
                found = true;
                continue;
            }
            newSongs[index++] = song;
        }
        if (!found) {
            System.out.println("Không tìm thấy bài hát với mã ID: " + id);
            return;
        }
        this.songs = newSongs;
        System.out.println("Bài hát với mã ID " + id + " đã được xoá.");
    }



}
