
package ra.model;
import ra.model.Singer;
import java.util.Date;
import java.util.Scanner;
public class Song {
    private static int autoSongId = 1;
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song(String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = String.valueOf(autoSongId++);
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public Song() {
    }

    // Getters and setters
    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}';
    }



    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên bài hát: ");
        this.songName = scanner.nextLine();
        System.out.print("Mô tả: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Ca sĩ: ");
        this.singer = new Singer();
        System.out.print("Nhạc sĩ: ");
        this.songWriter = scanner.nextLine();
        this.createdDate = new Date();
        System.out.print("Trạng thái bài hát (true/false): ");
        this.songStatus = scanner.nextBoolean();
    }
}
