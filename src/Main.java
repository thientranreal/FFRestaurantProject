import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();
    }
    private static void Menu() {
        final String pathEm = "/Users/Admin/Documents/GitHub/FFRestaurantProject/src/data/inputE.txt";
        final String pathCus = "/Users/Admin/Documents/GitHub/FFRestaurantProject/src/data/inputC.txt";
        EmployeeManage emmanage = new EmployeeManage();
        BranchManage brmanage = new BranchManage();
        CustomerManage cusmanage = new CustomerManage();
        Scanner sc = new Scanner(System.in);
        int chon, chonmenucon;
        do {
            System.out.println("=============================================");
            System.out.println("1. Quản lý chi nhánh.");
            System.out.println("2. Quản lý nhân viên.");
            System.out.println("3. Quản lý khách hàng.");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    do {
                        System.out.println("=============================================");
                        System.out.println("1. Tạo mới danh sách chi nhánh.");
                        System.out.println("2. Xuất danh sách chi nhánh.");
                        System.out.println("3. Tìm chi nhánh bằng id.");
                        System.out.println("4. Tìm chi nhánh bằng tên chi nhánh.");
                        System.out.println("5. Xóa chi nhánh bằng id.");
                        System.out.println("6. Thêm chi nhánh vào danh sách.");
                        System.out.println("7. Sửa chi nhánh trong danh sách.");
                        System.out.println("0. Thoát quản lý chi nhánh.");
                        System.out.print("Mời bạn chọn chức năng: ");
                        chonmenucon = Integer.parseInt(sc.nextLine());
                        switch (chonmenucon) {
                            case 1:
                                System.out.print("Mời bạn nhập số lượng cho danh sách: ");
                                brmanage = new BranchManage(Integer.parseInt(sc.nextLine()));
                                brmanage.input();
                                break;
                            case 2:
                                if (brmanage.getAmount() == 0) {
                                    System.out.println("Chưa tạo danh sách.");
                                }
                                else {
                                    brmanage.show();
                                }
                                break;
                            case 3:
                                System.out.print("Mời bạn nhập mã chi nhánh: ");
                                System.out.println(brmanage.findBranch(sc.nextLine()).toString());
                                break;
                            case 4:
                                System.out.print("Mời bạn nhập tên chi nhánh: ");
                                brmanage.findBranchByName(sc.nextLine());
                                break;
                            case 5:
                                System.out.print("Mời bạn nhập mã chi nhánh: ");
                                brmanage.remove(sc.nextLine());
                                break;
                            case 6:
                                Branch nbr = new Branch();
                                nbr.input();
                                brmanage.add(nbr);
                                break;
                            case 7:
                                System.out.print("Mời bạn nhập mã chi nhánh: ");
                                brmanage.edit(sc.nextLine());
                                break;
                        }
                    } while (chonmenucon != 0);
                    break;
                case 2:
                    do {
                        System.out.println("=============================================");
                        System.out.println("1. Tạo mới danh sách nhân viên.");
                        System.out.println("2. Tạo mới danh sách nhân viên từ file.");
                        System.out.println("3. Xuất danh sách nhân viên.");
                        System.out.println("4. Tìm nhân viên bằng id.");
                        System.out.println("5. Tìm nhân viên bằng tên nhân viên.");
                        System.out.println("6. Xóa nhân viên bằng id.");
                        System.out.println("7. Thêm nhân viên vào danh sách.");
                        System.out.println("8. Sửa nhân viên trong danh sách.");
                        System.out.println("9. Sắp xếp lương nhân viên tăng dần.");
                        System.out.println("0. Thoát quản lý nhân viên.");
                        System.out.print("Mời bạn chọn chức năng: ");
                        chonmenucon = Integer.parseInt(sc.nextLine());
                        switch (chonmenucon) {
                            case 1:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập số lượng cho danh sách: ");
                                emmanage = new EmployeeManage(Integer.parseInt(sc.nextLine()));
                                emmanage.input(brmanage.getBranchArray());
                                break;
                            case 2:
                                System.out.println("=============================================");
                                try {
                                    emmanage.inputFile(pathEm);
                                } catch (IOException e) {
                                    System.out.println("Không mở được file.");
                                }
                                break;
                            case 3:
                                System.out.println("=============================================");
                                if (emmanage.getAmount() == 0) {
                                    System.out.println("Chưa tạo danh sách.");
                                }
                                else {
                                    emmanage.show();
                                }
                                break;
                            case 4:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                Employee emf = emmanage.findEmployee(sc.nextLine());
                                System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s|%-15s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV", "Luong");
                                if (emf != null) {
                                    System.out.println(emf.toString());
                                }
                                else {
                                    System.out.println("Nhân viên không tồn tại.");
                                }
                                break;
                            case 5:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập tên nhân viên: ");
                                emmanage.findEmployeeByName(sc.nextLine());
                                break;
                            case 6:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                emmanage.remove(sc.nextLine());
                                break;
                            case 7:
                                System.out.println("=============================================");
                                Employee em;
                                System.out.print("Bạn muốn thêm nhân viên gì (waiter, guard, cleaning staff): ");
                                String typeEm = sc.nextLine();
                                while (!typeEm.equalsIgnoreCase("waiter") && !typeEm.equalsIgnoreCase("guard") && !typeEm.equalsIgnoreCase("cleaning staff")) {
                                    System.out.print("Vui lòng nhập lại: ");
                                    typeEm = sc.nextLine();
                                }
                                if (typeEm.equalsIgnoreCase("waiter")) {
                                    em = new Waiter();
                                }
                                else if (typeEm.equalsIgnoreCase("guard")) {
                                    em = new Guard();
                                }
                                else {
                                    em = new CleaningStaff();
                                }
                                em.input(brmanage.getBranchArray());
                                emmanage.add(em);
                                break;
                            case 8:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                emmanage.edit(sc.nextLine(), brmanage.getBranchArray());
                                break;
                            case 9:
                                System.out.println("=============================================");
                                emmanage.sortSalary();
                                break;
                        }
                    } while (chonmenucon != 0);
                    break;
                case 3:
                    do {
                        System.out.println("=============================================");
                        System.out.println("1. Tạo mới danh sách khách hàng.");
                        System.out.println("2. Tạo mới danh sách khách hàng từ file.");
                        System.out.println("3. Xuất danh sách khách hàng.");
                        System.out.println("4. Tìm khách hàng bằng id.");
                        System.out.println("5. Tìm khách hàng bằng tên khách hàng.");
                        System.out.println("6. Xóa khách hàng bằng id.");
                        System.out.println("7. Thêm khách hàng vào danh sách.");
                        System.out.println("8. Sửa khách hàng trong danh sách.");
                        System.out.println("0. Thoát quản lý khách hàng.");
                        System.out.print("Mời bạn chọn chức năng: ");
                        chonmenucon = Integer.parseInt(sc.nextLine());
                        switch (chonmenucon) {
                            case 1:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập số lượng cho danh sách: ");
                                cusmanage = new CustomerManage(Integer.parseInt(sc.nextLine()));
                                cusmanage.input();
                                break;
                            case 2:
                                System.out.println("=============================================");
                                try {
                                    cusmanage.inputFile(pathCus);
                                } catch (IOException e) {
                                    System.out.println("Không mở được file.");
                                }
                                break;
                            case 3:
                                System.out.println("=============================================");
                                if (cusmanage.getAmount() == 0) {
                                    System.out.println("Chưa tạo danh sách.");
                                }
                                else {
                                    cusmanage.show();
                                }
                                break;
                            case 4:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã khách hàng: ");
                                Customer cusf = cusmanage.findCustomer(sc.nextLine());
                                System.out.printf("%-10s|%-10s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s\n", "MaKH", "LoaiKH", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email");
                                if (cusf != null) {
                                    System.out.println(cusf.toString());
                                }
                                else {
                                    System.out.println("Khách hàng không tồn tại.");
                                }
                                break;
                            case 5:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập tên khách hàng: ");
                                cusmanage.findCustomerByName(sc.nextLine());
                                break;
                            case 6:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã khách hàng: ");
                                cusmanage.remove(sc.nextLine());
                                break;
                            case 7:
                                System.out.println("=============================================");
                                Customer cus = new Customer();
                                cus.input();
                                cusmanage.add(cus);
                                break;
                            case 8:
                                System.out.println("=============================================");
                                System.out.print("Mời bạn nhập mã khách hàng: ");
                                cusmanage.edit(sc.nextLine());
                                break;
                        }
                    } while (chonmenucon != 0);
                    break;
            }
        } while (chon != 0);
    }
}
