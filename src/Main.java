import model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        Student[] students =  new Student[100];
        int n = 0;

        do{
            System.out.println("""
                    ===== QUẢN LÝ ĐIỂM SINH VIÊN =====
                    1. Nhập danh sách sinh viên
                    2. Hiển thị danh sách sinh viên
                    3. Tìm kiếm sinh viên theo Học lực
                    4. Sắp xếp theo học lực giảm dần
                    5. Thoát
                    ==================================
                    """);
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:{

                    do{
                        try {
                            System.out.println("Nhập số lượng sinh viên: ");
                            n = Integer.parseInt(sc.nextLine());

                            if (n <= 0) {
                                System.out.println("Số lượng phải > 0");
                            }
                        }catch (Exception e){
                            System.out.println("Vui lòng nhập số nguyên");
                            n = 0;
                        }
                    }while(n <= 0);

                    for(int i  = 0; i<n; i++){
                        String inputID = "", inputName = "";
                        float inputScore = 0;
                        String regex  = "^SV\\d{3}$";

                        do{
                            System.out.printf("Nhập id cho sinh viên thứ %d: ", i+1);
                            inputID = sc.nextLine();
                            if (!inputID.matches(regex)){
                                System.out.println("ID sai định dạng!");
                            }
                        }while (!inputID.matches(regex));

                        do{
                            System.out.printf("Nhập tên cho sinh viên thứ %d: ", i+1);
                            inputName = sc.nextLine();
                        }while(inputName.isBlank());

                        do{
                            try{
                                System.out.printf("Nhập điểm cho sinh viên thứ %d: ", i+1);
                                inputScore = Float.parseFloat(sc.nextLine());
                                break;
                            }catch (Exception e){
                                System.out.println("Vui lòng nhập số nguyên");
                            }
                        }while(true);

                        students[i] = new Student(inputID, inputName, inputScore);
                        System.out.println("\nThêm thành công! ");
                    }
                    break;
                }

                case 2:{
                    if (n ==0 ){
                        System.out.println("Danh sách rỗng ");
                        break;
                    }
                    System.out.println("Danh sách sinh viên: ");
                    for (int i  = 0; i<n; i++){
                        System.out.println(students[i].toString());
                    }
                    break;
                }

                case 3:{
                    if (n ==0 ){
                        System.out.println("Danh sách rỗng ");
                        break;
                    }
                    String searchWord;
                    do{
                        System.out.println("Nhập học lực muốn tìm: ");
                        searchWord = sc.nextLine().trim();
                    }while (searchWord.isBlank());

                    System.out.printf("\nDanh sách sinh viên theo học lực %s \n", searchWord);
                    for(int i  = 0; i<n; i++){
                        if (students[i].getRank().equalsIgnoreCase(searchWord)){
                            System.out.println(students[i].toString());
                        }
                    }
                    break;
                }

                case 4:{
                    if (n ==0 ){
                        System.out.println("Danh sách rỗng ");
                        break;
                    }
                    for (int i  = 0; i < n-1 ; i++){
                        for (int j = 0; j<n -i -1; j++){
                            if (students[j].getScore() <  students[j+1].getScore()){
                                float temp = students[j].getScore();
                                students[j].setScore(students[j+1].getScore());
                                students[j+1].setScore(temp);
                            }
                        }
                    }

                    System.out.println("Kết quả: ");
                    for (int i  = 0; i<n; i++){
                        System.out.println(students[i].toString());
                    }
                    break;
                }

                case 5:{
                    System.out.println("Bạn chọn thoát!");
                    break;
                }
                default:{
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }while(choice!= 5);
        sc.close();
    }
}