import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                        System.out.println("2. Xuất danh sách nhân viên.");
                        System.out.println("3. Tìm nhân viên bằng id.");
                        System.out.println("4. Tìm nhân viên bằng tên nhân viên.");
                        System.out.println("5. Xóa nhân viên bằng id.");
                        System.out.println("6. Thêm nhân viên vào danh sách.");
                        System.out.println("7. Sửa nhân viên trong danh sách.");
                        System.out.println("8. Sắp xếp lương nhân viên tăng dần.");
                        System.out.println("0. Thoát quản lý nhân viên.");
                        System.out.print("Mời bạn chọn chức năng: ");
                        chonmenucon = Integer.parseInt(sc.nextLine());
                        switch (chonmenucon) {
                            case 1:
                                System.out.print("Mời bạn nhập số lượng cho danh sách: ");
                                emmanage = new EmployeeManage(Integer.parseInt(sc.nextLine()));
                                emmanage.input();
                                break;
                            case 2:
                                if (emmanage.getAmount() == 0) {
                                    System.out.println("Chưa tạo danh sách.");
                                }
                                else {
                                    emmanage.show();
                                }
                                break;
                            case 3:
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                System.out.println(emmanage.findEmployee(sc.nextLine()).toString());
                                break;
                            case 4:
                                System.out.print("Mời bạn nhập tên nhân viên: ");
                                emmanage.findEmployeeByName(sc.nextLine());
                                break;
                            case 5:
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                emmanage.remove(sc.nextLine());
                                break;
                            case 6:
                                Employee em = new Employee();
                                em.input();
                                emmanage.add(em);
                                break;
                            case 7:
                                System.out.print("Mời bạn nhập mã nhân viên: ");
                                emmanage.edit(sc.nextLine());
                                break;
                            case 8:
                                emmanage.sortSalary();
                                break;
                        }
                    } while (chonmenucon != 0);
                    break;
                case 3:
                    do {
                        System.out.println("=============================================");
                        System.out.println("1. Tạo mới danh sách khách hàng.");
                        System.out.println("2. Xuất danh sách khách hàng.");
                        System.out.println("3. Tìm khách hàng bằng id.");
                        System.out.println("4. Tìm khách hàng bằng tên khách hàng.");
                        System.out.println("5. Xóa khách hàng bằng id.");
                        System.out.println("6. Thêm khách hàng vào danh sách.");
                        System.out.println("7. Sửa khách hàng trong danh sách.");
                        System.out.println("0. Thoát quản lý khách hàng.");
                        System.out.print("Mời bạn chọn chức năng: ");
                        chonmenucon = Integer.parseInt(sc.nextLine());
                        switch (chonmenucon) {
                            case 1:
                                System.out.print("Mời bạn nhập số lượng cho danh sách: ");
                                cusmanage = new CustomerManage(Integer.parseInt(sc.nextLine()));
                                cusmanage.input();
                                break;
                            case 2:
                                if (cusmanage.getAmount() == 0) {
                                    System.out.println("Chưa tạo danh sách.");
                                }
                                else {
                                    cusmanage.show();
                                }
                                break;
                            case 3:
                                System.out.print("Mời bạn nhập mã khách hàng: ");
                                System.out.println(cusmanage.findCustomer(sc.nextLine()).toString());
                                break;
                            case 4:
                                System.out.print("Mời bạn nhập tên khách hàng: ");
                                cusmanage.findCustomerByName(sc.nextLine());
                                break;
                            case 5:
                                System.out.print("Mời bạn nhập mã khách hàng: ");
                                cusmanage.remove(sc.nextLine());
                                break;
                            case 6:
                                Customer cus = new Customer();
                                cus.input();
                                cusmanage.add(cus);
                                break;
                            case 7:
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
