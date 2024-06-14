package ra.model;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private String genre;
    private boolean gender;
    private static int autoId = 1;

    // Constructors
    public Singer() {
    }

    public Singer(String singerName, int age, String nationality, String genre, boolean gender) {
        this.singerId = autoId++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    // Getters and setters
    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    // toString method
    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", genre='" + genre + '\'' +
                ", gender=" + gender +
                '}';
    }

    // Method to input data from user
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tên ca sĩ: ");
        singerName = sc.nextLine();
        System.out.println("Tuổi: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Quốc tịch: ");
        nationality = sc.nextLine();
        System.out.println("Giới tính (true for male, false for female): ");
        gender = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Thể loại nhạc: ");
        genre = sc.nextLine();
    }
}
