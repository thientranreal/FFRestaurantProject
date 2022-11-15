import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManage implements ReadWriteFile{
    private int amount;
    private Employee[] employeeArray;
    private static Scanner sc = new Scanner(System.in);
    public EmployeeManage() {
    }

    public EmployeeManage(int amount) {
        if (amount > 0) {
            this.amount = amount;
            employeeArray = new Employee[amount];
        }
    }

    public EmployeeManage(int amount, Employee[] employeeArray) {
        this.amount = amount;
        this.employeeArray = employeeArray;
    }

    public int getAmount() {
        return amount;
    }

    public Employee[] getEmployeeArray() {
        return employeeArray;
    }

    public void input(Branch[] brs) {
        for (int i=0; i < amount; i++) {
            System.out.print("Bạn muốn thêm nhân viên gì (waiter, guard, cleaning staff): ");
            String typeEm = sc.nextLine();
            while (!typeEm.equalsIgnoreCase("waiter") && !typeEm.equalsIgnoreCase("guard") && !typeEm.equalsIgnoreCase("cleaning staff")) {
                System.out.print("Vui lòng nhập lại: ");
                typeEm = sc.nextLine();
            }
            if (typeEm.equalsIgnoreCase("waiter")) {
                employeeArray[i] = new Waiter();
            }
            else if (typeEm.equalsIgnoreCase("guard")) {
                employeeArray[i] = new Guard();
            }
            else {
                employeeArray[i] = new CleaningStaff();
            }
            employeeArray[i].input(brs);
        }
    }

    @Override
    public void readFile(String filename) {
        String[] data;
        String line = "";
        int i = 0;

        try {
            File file_url = new File(filename);
            InputStream inputStream = new FileInputStream(file_url);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            // Đọc số lượng của mảng từ file gán vào amount, khởi tạo mảng employee mới
            amount = Integer.parseInt(reader.readLine());
            employeeArray = new Employee[amount];

            // Đọc dữ liệu từ FILE
            while((line = reader.readLine()) != null) {
                data = line.split("[|]");
                if (data[0].equalsIgnoreCase("waiter")) {
                    employeeArray[i] = new Waiter();
                }
                else if (data[0].equalsIgnoreCase("cleaning staff")) {
                    employeeArray[i] = new CleaningStaff();
                }
                else {
                    employeeArray[i] = new Guard();
                }
                employeeArray[i].setName(data[1]);
                employeeArray[i].setBirthyear(Integer.parseInt(data[2]));
                employeeArray[i].setGender(data[3]);
                employeeArray[i].setAddress(data[4]);
                employeeArray[i].setPhonenumber(data[5]);
                employeeArray[i].setEmail(data[6]);
                employeeArray[i].setId(data[7]);
                employeeArray[i].setWage(Integer.parseInt(data[8]));
                employeeArray[i].setType(data[9]);
                employeeArray[i].setWorkingarea(data[10]);
                employeeArray[i].setBranchID(data[11]);
                employeeArray[i].setWorkingdays(Integer.parseInt(data[12]));
                ++i;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không mở được file.");
        } catch (IOException e) {
            System.out.println("Không đọc được file.");
        }
    }

    @Override
    public void writeFile(String filename) {
        if (employeeArray == null) {
            System.out.println("Chưa tạo danh sách nhân viên.");
            return;
        }
        String dsheader = String.format("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");

        try {
            File file = new File(filename);
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            // ghi file
            // ghi danh sach waiter ra file
            outputStreamWriter.write("Waiter Employees:\n" + dsheader);
            for (Employee em : employeeArray) {
                if (em.getClass().equals(Waiter.class)) {
                    outputStreamWriter.write(em.toString() + "\n");
                }
            }
            // ghi danh sach guard ra file
            outputStreamWriter.write("Guard Employees:\n" + dsheader);
            for (Employee em : employeeArray) {
                if (em.getClass().equals(Guard.class)) {
                    outputStreamWriter.write(em.toString() + "\n");
                }
            }
            // ghi danh sach Cleaning Staff ra file
            outputStreamWriter.write("Cleaning Staffs:\n" + dsheader);
            for (Employee em : employeeArray) {
                if (em.getClass().equals(CleaningStaff.class)) {
                    outputStreamWriter.write(em.toString() + "\n");
                }
            }
            // end ghi file
            outputStreamWriter.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Không mở được file.");
        } catch (IOException e) {
            System.out.println("Không ghi được file.");
        }
        System.out.println("Đã ghi được file nhân viên.");
    }

    public void show() {
        if (employeeArray == null) {
            System.out.println("Chưa tạo danh sách nhân viên.");
            return;
        }
        // xuất ra danh sách Waiter
        System.out.println("Waiter Employees:");
        System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");
        for (Employee em : employeeArray) {
            if (em.getClass().equals(Waiter.class)) {
                System.out.println(em.toString());
            }
        }
        System.out.println("=======================================================================");
        // xuất ra danh sách Guard
        System.out.println("Guard Employees:");
        System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");
        for (Employee em : employeeArray) {
            if (em.getClass().equals(Guard.class)) {
                System.out.println(em.toString());
            }
        }
        System.out.println("=======================================================================");
        // xuất ra danh sách Cleaning Staff
        System.out.println("Cleaning Staffs:");
        System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");
        for (Employee em : employeeArray) {
            if (em.getClass().equals(CleaningStaff.class)) {
                System.out.println(em.toString());
            }
        }
        System.out.println("=======================================================================");
    }
    public void sortSalary() {
        Arrays.sort(employeeArray, (Employee a, Employee b) -> {
            return a.calSalary() - b.calSalary();
        });
    }
    public Employee findEmployee(String id) {
        for (Employee em : employeeArray) {
            if (em.getId().compareToIgnoreCase(id) == 0) { return em; }
        }
        return null;
    }
    public void findEmployeeByName(String name) {
        if (employeeArray == null) {
            System.out.println("Chưa tạo danh sách nhân viên.");
            return;
        }
        System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");
        for (Employee em : employeeArray) {
            if (em.getName().compareToIgnoreCase(name) == 0) {
                System.out.println(em.toString());
            }
        }
    }
    public void remove(String id) {
        if (employeeArray == null) {
            System.out.println("Chưa tạo danh sách nhân viên.");
            return;
        }
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        if (findEmployee(id) == null) {
            System.out.println("Nhân viên không tồn tại.");
            return;
        }
        int j = 0;
        amount = amount - 1;
        Employee[] copy = new Employee[amount];
        // kiểm tra những phần tử trong array nếu là pt không muốn xóa thì sẽ copy vào mảng copy
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getId().compareToIgnoreCase(id) != 0) {
                copy[j++] = employeeArray[i];
            }
        }
        employeeArray = copy;
    }
    public void add(Employee em) {
        // nếu chưa có danh sách thì sẽ tạo ra danh sách mới
        if (employeeArray == null) {
            amount = 1;
            employeeArray = new Employee[amount];
            employeeArray[0] = em;
            return;
        }
        // tăng số lượng lên 1 và copy các pt trong mảng sang mảng mới
        amount = amount + 1;
        employeeArray = Arrays.copyOf(employeeArray, amount);
        // pt cuối cùng là employee muốn thêm vào mảng
        employeeArray[amount - 1] = em;
    }
    public void edit(String id, Branch[] brs) {
        if (employeeArray == null) {
            System.out.println("Chưa tạo danh sách nhân viên.");
            return;
        }
        if (findEmployee(id) == null) {
            System.out.println("Nhân viên không tồn tại.");
            return;
        }
        // lấy vị trí pt muốn sửa trong mảng gán vị trí vào i
        int i, chon;
        for (i = 0; i < amount; i++) {
            if (employeeArray[i].getId().compareToIgnoreCase(id) == 0) {
                break;
            }
        }
        while (true) {
            System.out.printf("1. Sửa mã NV.\n");
            System.out.printf("2. Sửa họ tên.\n");
            System.out.printf("3. Sửa năm sinh.\n");
            System.out.printf("4. Sửa giới tính.\n");
            System.out.printf("5. Sửa địa chỉ.\n");
            System.out.printf("6. Sửa điện thoại.\n");
            System.out.printf("7. Sửa email.\n");
            System.out.printf("8. Sửa lương theo ngày.\n");
            System.out.printf("9. Sửa loại NV.\n");
            System.out.printf("10. Sửa khu vực làm việc.\n");
            System.out.printf("11. Sửa số ngày làm việc.\n");
            System.out.printf("12. Sửa mã chi nhánh làm việc.\n");
            System.out.printf("Hãy chọn thông tin muốn sửa.\n");
            chon = Integer.parseInt(sc.nextLine());
            if (chon <= 0 || chon > 12) { break; }
            switch (chon) {
                case 1:
                    System.out.print("Hãy nhập mã nhân viên: ");
                    employeeArray[i].setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Hãy nhập họ và tên: ");
                    employeeArray[i].setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Hãy nhập năm sinh: ");
                    employeeArray[i].setBirthyear(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Hãy nhập giới tính: ");
                    employeeArray[i].setGender(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Hãy nhập địa chỉ: ");
                    employeeArray[i].setAddress(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Hãy nhập số điện thoại: ");
                    employeeArray[i].setPhonenumber(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Hãy nhập email: ");
                    employeeArray[i].setEmail(sc.nextLine());
                    break;
                case 8:
                    System.out.print("Hãy nhập lương một ngày: ");
                    employeeArray[i].setWage(Integer.parseInt(sc.nextLine()));
                    break;
                case 9:
                    System.out.print("Hãy nhập loại nhân viên (full-time, part-time): ");
                    employeeArray[i].setType(sc.nextLine());
                    break;
                case 10:
                    System.out.print("Hãy nhập khu vực làm việc (kitchen, counter, toilet, parking lot): ");
                    employeeArray[i].setWorkingarea(sc.nextLine());
                    break;
                case 11:
                    System.out.print("Hãy nhập số ngày làm việc: ");
                    employeeArray[i].setWorkingdays(Integer.parseInt(sc.nextLine()));
                    break;
                case 12:
                    System.out.print("Hãy nhập mã chi nhánh làm việc: ");
                    employeeArray[i].setBranchIDStrict(sc.nextLine(), brs);
                    break;
            }
        }
    }
}
